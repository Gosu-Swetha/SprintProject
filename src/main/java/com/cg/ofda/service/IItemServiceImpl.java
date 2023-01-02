package com.cg.ofda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.dto.RestaurantDto;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.exception.ItemException;
import com.cg.ofda.repository.ICategoryRepository;
import com.cg.ofda.repository.IItemRepository;
import com.cg.ofda.repository.IRestaurantRepository;

@Service
public class IItemServiceImpl implements IItemService {
	
	@Autowired
	IItemRepository itemRepository;
	@Autowired
	IRestaurantRepository restaurantRepository;
	@Autowired
	ICategoryRepository cartRepository;
	
	
	/* @author : Usha 
	 * @return : Item 
	 * @description : This method adds Item to the repository and returns Item
	 */
	@Override
	public ItemDto addItem(ItemDto item) throws ItemException {
		if(itemRepository.existsById(item.getItemId())) {
			throw new ItemException("Item exists");
		}
		return itemRepository.save(item);
		
	}

	/* @author : Usha 
	 * @return : Item 
	 * @description : This method updates the  Item in the repository and returns Item
	 */
	@Override
	public ItemDto updateItem(ItemDto item) {
		itemRepository.save(item);
		return item;
	}
	
	/* @author : Usha 
	 * @return : Item 
	 * @description : This method returns the  Item by id from the repository 
	 */

	
	@Override
	public ItemDto viewItem(String itemId) {
		Optional<ItemDto> findById = itemRepository.findById(itemId);
		return findById.orElseThrow(() -> new CustomerException("There is no item having id:" + itemId));
	}
	
	/* @author : Usha
	 * @return : Item 
	 * @description : This method removes the  Item by id from the repository and returns the item 
	 */

	@Override
	public ItemDto removeItem(String itemId) throws ItemException{
		if(itemRepository.existsById(itemId)) {
		ItemDto it = itemRepository.findById(itemId).get();
		itemRepository.delete(it);
		return it;
		}
		else
			throw new ItemException("Item Id not found");
	}

	/* @author : Usha
	 * @return : Item 
	 * @description : This method gives the  list of Item by id from the repository 
	 */
	@Override
	public List<ItemDto> viewAllItems() {
		List<ItemDto> its = itemRepository.findAll();
		return its;
	}
	
	
	/* @author : Usha
	 * @return : List of Items 
	 * @description : This method return the list of Items by name from the repository 
	 */
	@Override
	public List<ItemDto> viewAllItemsByName(String name) throws ItemException {
	List<ItemDto> items = itemRepository.findAll();
		List<ItemDto> resItems = new ArrayList<>();
		for(ItemDto item : items) {
			if(item.getItemName().equals(name))
				resItems.add(item);
		}
	return resItems;
	}
	
	/* @author : Usha
	 * @return : List<Item> 
	 * @description : This method gives the  all items of restauarant by restaurant id from the repository
	 */
	@Override
	public List<ItemDto> viewAllItemsByRestaurant(String restId) throws ItemException{
		if(restaurantRepository.existsById(restId)) {
		RestaurantDto restaurant = restaurantRepository.findById(restId).get();
		return restaurant.getItem();
		}
	
		else 
			throw new ItemException("Restaurant Id not found");
	}
	/* @author : Usha
	 * @return : List<Item> 
	 * @description : This method gives the all Item by category from the repository  
	 */
	
	@Override
	public List<ItemDto> viewAllItemsByCategory(String catId){
	if(cartRepository.existsById(catId)) {
		List<ItemDto> items=itemRepository.findAll();
		List<ItemDto> itemsbycategory=new ArrayList<>();
		for(ItemDto item:items)
		{
			if(catId.equals(item.getCategory().getCatId()))
			{
				itemsbycategory.add(item);
			}
		}
		return itemsbycategory;
		}
		else
			throw new ItemException("Category Id not found");
	}
	

}
