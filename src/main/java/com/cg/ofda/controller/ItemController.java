package com.cg.ofda.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.exception.ItemException;
import com.cg.ofda.service.IItemServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	IItemServiceImpl itemService;
	
	@PostMapping("/additem")
	public ItemDto addItem(@Valid @RequestBody ItemDto item) throws ItemException {
		return itemService.addItem(item);
	}
	
	@PutMapping("/updateitem")
	public ItemDto updateItem(@Valid @RequestBody ItemDto item) {
		return itemService.updateItem(item);
	}
	
	@GetMapping("/viewitem/{id}")
	public ItemDto viewItem(@PathVariable("id") String id) throws ItemException {
		return itemService.viewItem(id);
	}
	
	@DeleteMapping("/removeitem/{id}")
	public ItemDto removeItem(@PathVariable("id") String id) throws ItemException {
		return itemService.removeItem(id);
	}
	
	
	@GetMapping("/viewallitems")
	public List<ItemDto> viewAllItems(){
		return itemService.viewAllItems();
	}
	
	@GetMapping("/viewallitemsbyrestaurantid/{id}")
	public List<ItemDto> viewAllItmesByRestaurant(@PathVariable("id") String restId) throws ItemException{
		return itemService.viewAllItemsByRestaurant(restId);
	}
	
	@GetMapping("/viewallitemsbyname/{name}")
		public List<ItemDto> viewAllItemsByName(@PathVariable("name") String name){
			return itemService.viewAllItemsByName(name);
		}
	
	@GetMapping("/viewallitemsbycategory/{catId}")
	public List<ItemDto> viewAllItemsByCategory(@PathVariable("catId") String catId) throws ItemException{
		return itemService.viewAllItemsByCategory(catId);
	}
	
	}

