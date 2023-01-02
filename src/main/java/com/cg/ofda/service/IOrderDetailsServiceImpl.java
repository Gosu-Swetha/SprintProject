package com.cg.ofda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.ofda.repository.ICustomerRepository;
import com.cg.ofda.repository.IOrderRepository;
import com.cg.ofda.repository.IRestaurantRepository;
import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.dto.OrderDetailsDto;
import com.cg.ofda.dto.RestaurantDto;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.exception.OrderDetailsException;
import com.cg.ofda.exception.RestaurantException;

@Service
public class IOrderDetailsServiceImpl implements IOrderDetailsService {
	
		@Autowired
		IOrderRepository orderDetailsRepository;
		@Autowired
		ICustomerRepository customerRepository;
		@Autowired
		IRestaurantRepository restaurantRepository;
		
		/* @author : Satya 
	     * @return : orderdetails 
	     * @description : This method adds orderdetails in the repository and returns order details
	     */

		@Override
		public OrderDetailsDto addOrder(OrderDetailsDto orderdetails) throws OrderDetailsException {
			if(orderDetailsRepository.existsById(orderdetails.getOrderId())) {
				throw new OrderDetailsException("Order already exists");
			}
			return orderDetailsRepository.save(orderdetails);
		}
		
		/* @author : Satya 
	     * @return : orderdetails 
	     * @description : This method updates orderdetails in the repository and returns order details
	     */

		@Override
		public OrderDetailsDto updateOrder(OrderDetailsDto orderdetails) {
			  orderDetailsRepository.save(orderdetails);
				return orderdetails;
		}
		/* @author : Satya 
	     * @return : orderdetails 
	     * @description : This method removes orderdetails in the repository and returns order details
	     */
		@Override
		public OrderDetailsDto removeOrder(int ordId)  {
			OrderDetailsDto orderId = orderDetailsRepository.findById(ordId).get();
			orderDetailsRepository.deleteById(ordId);
			return orderId;
		}
		/* @author : Satya 
	     * @return : orderdetails 
	     * @description : This method shows orderdetails in the repository and returns order details if found.	     */

		@Override
		public OrderDetailsDto viewOrder(int ordId) {
			Optional<OrderDetailsDto> findById = orderDetailsRepository.findById(ordId);

			return findById.orElseThrow(() -> new OrderDetailsException("There are no orderdetails having id:" + ordId));
		}
		
		public List<OrderDetailsDto> viewAllOrders(){
			return orderDetailsRepository.findAll();
		}
		
		@Override
		public List<OrderDetailsDto> viewAllOrdersByCustomer(String custId) throws CustomerException {
			List<OrderDetailsDto> ord=orderDetailsRepository.findAll();
			List<OrderDetailsDto> customerorders=new ArrayList<>();
			if(customerRepository.existsById(custId)) {
			for(OrderDetailsDto o:ord)
			{
				String customerid =o.getCart().getCustomer().getCustomerId();
				
				if(customerid.equals(custId))
				{
					customerorders.add(o);
				}
			}
			return customerorders;
			
		}
			else 
				throw new CustomerException("Customer Id not found");
		}
		
		public List<OrderDetailsDto> viewAllOrdersByRestaurant(String restId) throws RestaurantException{
			// TODO Auto-generated method stub
			if(restaurantRepository.existsById(restId)) {
			List<OrderDetailsDto> ord=orderDetailsRepository.findAll();
			List<OrderDetailsDto> orders=new ArrayList<>();
			for(OrderDetailsDto o:ord)
			{
				List<ItemDto> items=o.getCart().getItemList();
				for(ItemDto item:items)
				{
					List<RestaurantDto> restaurants=item.getRestaurants();
					for(RestaurantDto restaurant:restaurants)
					{
						if(restId.equals(restaurant.getRestaurantId()))
								{
								orders.add(o);
								}
					}
				}
			}
			return orders;
			}
			else throw new RestaurantException("Restaurant Id not found");
		}
		
		
		

}

