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
import com.cg.ofda.dto.RestaurantDto;
import com.cg.ofda.exception.RestaurantException;
import com.cg.ofda.service.IRestaurantServiceImpl;

import jakarta.validation.Valid;

@RestController
	@RequestMapping("/restaurant")
	public class RestaurantController {
		
		@Autowired
		IRestaurantServiceImpl restaurantService;
		
		
		@PostMapping("/addrestaurant")
		public RestaurantDto addRestaurant(@Valid @RequestBody RestaurantDto res) throws RestaurantException {
			return restaurantService.addRestaurant(res);
		}
		
		
		@PutMapping("/updaterestaurant")
		public RestaurantDto updateRestaurant( @Valid @RequestBody RestaurantDto res) {
			return restaurantService.updateRestaurant(res);
		}
		
		/* @author : Harshali
	     * @return : Restaurant
	     * @description : This method is to delete restaurant in the repository and returns restaurant
	     */
		@DeleteMapping("/deleterestaurant/{id}")
		public RestaurantDto removeRestaurant(@PathVariable("id")String restaurantId) {
			return restaurantService.removeRestaurant(restaurantId);
		}
		

		/* @author : Harshali
	     * @return : Restaurant
	     * @description : This method is to view restaurant in the repository and returns restaurant
	     */
		@GetMapping("/viewrestaurant/{id}")
		public RestaurantDto viewRestaurant( @PathVariable("id") String restaurantId) {
			return restaurantService.viewRestaurant(restaurantId);
		}
		
		/* @author : Harshali
	     * @return : Restaurant
	     * @description : This method is to return list of  restaurant in the repository given by location.
	     */
		@GetMapping("/viewrestaurantnearby/{location}")
		public List<RestaurantDto> viewRestaurantNearBy(@PathVariable("location")String location){
			return restaurantService.viewRestaurantNearBy(location);
		}
		
		
		/* @author : Harshali
	     * @return : Restaurant
	     * @description : This method is to return list of  restaurant in the repository given by name.
	     */
		@GetMapping("/viewrestaurantbyitemname/{name}")
		public List<RestaurantDto> viewRestaurantByItemName(@PathVariable String name){
			return restaurantService.viewRestaurantByItemName(name);
		}


}
