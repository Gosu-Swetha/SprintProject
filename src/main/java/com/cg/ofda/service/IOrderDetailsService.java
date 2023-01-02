package com.cg.ofda.service;


import java.util.List;

import com.cg.ofda.dto.OrderDetailsDto;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.exception.RestaurantException;

public interface IOrderDetailsService {
	
	public OrderDetailsDto addOrder(OrderDetailsDto orderdetails) throws Exception;
	public OrderDetailsDto updateOrder(OrderDetailsDto orderdetails);
	public OrderDetailsDto removeOrder(int ordId);
	public OrderDetailsDto viewOrder(int ordId);
	public List<OrderDetailsDto> viewAllOrdersByCustomer(String custId) throws CustomerException;
	public List<OrderDetailsDto> viewAllOrdersByRestaurant(String restId) throws RestaurantException;

	
	


}