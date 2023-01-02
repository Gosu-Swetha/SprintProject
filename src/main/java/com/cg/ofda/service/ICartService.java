package com.cg.ofda.service;

import java.util.List;

import com.cg.ofda.dto.FoodCartDto;
import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.exception.CartException;

public interface ICartService {
	
	public FoodCartDto addItemToCart(String cartId, ItemDto item) throws CartException;
	public FoodCartDto increaseQuantity(String cartId, String itemId, int quantity) throws CartException;
	public FoodCartDto reduceQuantity(String cartId, String itemId, int quantity) throws CartException;
	public FoodCartDto removeItem(String cartId, String itemId) throws CartException;
	public FoodCartDto clearCart(String cartId) throws CartException;
	public List<FoodCartDto> viewCart()throws CartException;
	
	
	

}
