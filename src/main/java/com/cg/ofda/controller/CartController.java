package com.cg.ofda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofda.dto.FoodCartDto;
import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.exception.CartException;
import com.cg.ofda.service.ICartServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	ICartServiceImpl cartService;
	
	@PostMapping("/additemtocart/{cartId}")
	public FoodCartDto addItemToCart(@PathVariable("cartId") String cartId, @Valid @RequestBody ItemDto item) throws CartException {
		return cartService.addItemToCart(cartId, item);
	}
	
	@GetMapping("/viewcart/{cartId}")
	public FoodCartDto viewCartById(@PathVariable("cartId") String cartId) {
		return cartService.viewCartById(cartId);
	}
	
	@PutMapping("/increasequantity/{cartId}/{itemId}/{qty}")
	public FoodCartDto increaseQuantity(@PathVariable("cartId") String cartId,@PathVariable("itemId") String itemId, @PathVariable("qty") int quantity) throws CartException {
	return cartService.increaseQuantity(cartId, itemId, quantity);
	}
	
	@PutMapping("/reducequantity/{cartId}/{itemId}/{qty}")
	public FoodCartDto reduceQuantity(@PathVariable("cartId") String cartId,@PathVariable("itemId") String itemId, @PathVariable("qty") int quantity) throws CartException {
	return cartService.reduceQuantity(cartId, itemId, quantity);
	}
	
	@DeleteMapping("/clearcart/{cartId}")
	public FoodCartDto clearCart(String cartId) throws CartException{
		return cartService.clearCart(cartId);
	}
}
