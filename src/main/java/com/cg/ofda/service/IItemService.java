package com.cg.ofda.service;

import java.util.List;

import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.exception.ItemException;

public interface IItemService {
	
	public ItemDto addItem(ItemDto item) throws ItemException;
	public ItemDto updateItem(ItemDto item);
	public ItemDto viewItem(String itemId) throws ItemException;
	public ItemDto removeItem(String itemId)throws ItemException;
	public List<ItemDto> viewAllItems();
	public List<ItemDto> viewAllItemsByCategory(String catId)throws ItemException;
	public List<ItemDto> viewAllItemsByRestaurant(String restId)throws ItemException;
	public List<ItemDto> viewAllItemsByName(String name);

}
