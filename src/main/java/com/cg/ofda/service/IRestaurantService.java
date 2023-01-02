package com.cg.ofda.service;

import java.util.List;


import com.cg.ofda.dto.RestaurantDto;
import com.cg.ofda.exception.RestaurantException;

public interface IRestaurantService {

	public RestaurantDto addRestaurant(RestaurantDto res) throws RestaurantException;
	public RestaurantDto updateRestaurant(RestaurantDto res);
	public RestaurantDto removeRestaurant(String restaurantId)throws RestaurantException;
	public RestaurantDto viewRestaurant(String restaurantId);
	public List<RestaurantDto> viewRestaurantNearBy(String location);
	public List<RestaurantDto> viewRestaurantByItemName(String name);
}
