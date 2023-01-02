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

import com.cg.ofda.dto.OrderDetailsDto;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.exception.OrderDetailsException;
import com.cg.ofda.service.IOrderDetailsServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {

	@Autowired
	IOrderDetailsServiceImpl orderService;
	
	@PostMapping("/addorder")
	public OrderDetailsDto addOrder(@Valid @RequestBody OrderDetailsDto orderdetails) throws OrderDetailsException{
		return orderService.addOrder(orderdetails);
}
	@PutMapping("/updateorder")
	public OrderDetailsDto updateOrder(@Valid @RequestBody OrderDetailsDto orderdetails) {
		return orderService.updateOrder(orderdetails);
}
	@DeleteMapping("/removeorder/{id}")
	public  OrderDetailsDto removeOrder(@PathVariable("id")int id) {
		return orderService.removeOrder(id);
		
}
     @GetMapping("/vieworder/{id}")
		public OrderDetailsDto viewOrder(@PathVariable("id")int id){
			return orderService.viewOrder(id);
		}
     @GetMapping("/viewallorders")
     public List<OrderDetailsDto> viewAllOrders(){
    	return orderService.viewAllOrders();
     }
     
     @GetMapping("/viewallordersbycustomer/{custId}")
     public List<OrderDetailsDto> viewAllOrdersByCustomer(@PathVariable("custId") String custId) throws CustomerException {
    	 return orderService.viewAllOrdersByCustomer(custId);
     }
     @GetMapping("/viewallordersbyrestaurant/{restId}")
     public List<OrderDetailsDto> viewAllOrdersByRestaurant(@PathVariable("restId") String restId){
    	 return orderService.viewAllOrdersByRestaurant(restId);
     }
}	
	