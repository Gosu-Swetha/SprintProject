package com.cg.ofda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.dto.FoodCartDto;
import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.exception.CartException;
import com.cg.ofda.repository.ICartRepository;
import com.cg.ofda.repository.IItemRepository;

@Service
public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository cartRepository;
	@Autowired
	IItemRepository itemRepository;
	/* @author : Usha *
	 * @return : FoodCartDto *
	 * @description : This method adds item to cart in the repository and returns FoodCartDto */
	
	@Override
	public FoodCartDto addItemToCart(String cartId, ItemDto item) throws CartException{
		if(cartRepository.existsById(cartId)) {
		FoodCartDto cart = cartRepository.findById(cartId).get();
		List<ItemDto> items = cart.getItemList();
		items.add(item);
		return cartRepository.save(cart);
		}
		else
			throw new CartException("Cart Id not found");
	}
	/* @author : Usha *
	 * @return : FoodCartDto *
	 * @description : This method gives cartdetails according to id from the repository and returns FoodCartDto */
	public FoodCartDto viewCartById(String cartId) {
		return cartRepository.findById(cartId).get();
	}

	/* @author : Usha *
	 * @return : FoodCartDto *
	 * @description : This methodclears cart from the repository and returns FoodCartDto */
	@Override
	public FoodCartDto clearCart(String cartId) throws CartException{
		if(cartRepository.existsById(cartId)) {
			FoodCartDto cart = cartRepository.findById(cartId).get();
			cartRepository.delete(cart);
			return cart;
		}
		else throw new CartException("Cart Id not found");
	}

	/* @author : Usha *
	 * @return : List<FoodCartDto> *
	 * @description : This method gives list of cart in the repository and returns List of FoodCartDto */
	@Override
	public List<FoodCartDto> viewCart() {
		return cartRepository.findAll();
	}
	/* @author : Usha *
	 * @return : FoodCartDto *
	 * @description : This method increases quantity of a item from cart in the repository and returns FoodCartDto */

	@Override
	public FoodCartDto increaseQuantity(String cartId, String itemId, int quantity) throws CartException{
		ItemDto it = null;
		if(cartRepository.existsById(cartId)) {
		FoodCartDto cart = cartRepository.findById(cartId).get();
		List<ItemDto> items = cart.getItemList();
		for(ItemDto item : items) {
			if(item.getItemId().equals(itemId))
			 it = item;
		}
		int qty = it.getQuantity();
		it.setQuantity(quantity+qty);
		cartRepository.save(cart);
		return cart;	
		}
		else
			throw new CartException("Cart Id not found");
	}
	/* @author : Usha *
	 * @return : FoodCartDto *
	 * @description : This method decreases quantity of a item from cart in the repository and returns FoodCartDto */

	@Override
	public FoodCartDto reduceQuantity(String cartId, String itemId, int quantity) throws CartException {
		ItemDto it = null;
		if(cartRepository.existsById(cartId)) {
		FoodCartDto cart = cartRepository.findById(cartId).get();
		List<ItemDto> items = cart.getItemList();
		for(ItemDto item : items) {
			if(item.getItemId().equals(itemId))
			 it = item;
		}
		int qty = it.getQuantity();
		it.setQuantity(qty - quantity);
		cartRepository.save(cart);
		return cart;
		}
		else
			throw new CartException("Cart Id not found");
	}
	/* @author : Usha *
	 * @return : FoodCartDto *
	 * @description : This method removes item from cart in the repository and returns FoodCartDto */

	public FoodCartDto removeItem(String cartId, String itemId) throws CartException {
		if(cartRepository.existsById(cartId)) {
			FoodCartDto cart = cartRepository.findById(cartId).get();
			List<ItemDto> items = cart.getItemList();
			ItemDto it = null;
			for(ItemDto item : items) {
				if(item.getItemId().equals(itemId)) {
					it = item;
				}
			}
			itemRepository.delete(it);
			cartRepository.save(cart);
			return cart;
		}
		else throw new CartException("Cart Id not found");
		
	}

}

