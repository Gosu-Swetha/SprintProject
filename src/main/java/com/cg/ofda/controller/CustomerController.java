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

import com.cg.ofda.dto.CustomerDto;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.service.ICustomerServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerServiceImpl customerService;
	
	@PostMapping("/addcustomer")
	public CustomerDto addCustomer(@Valid @RequestBody CustomerDto customer) throws CustomerException {
		return customerService.addCustomer(customer);
	}
	
	@PutMapping("/updatecustomer")
	public CustomerDto updateCustomer(@Valid @RequestBody CustomerDto customer) {
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/viewcustomer/{id}")
	public CustomerDto viewCustomer(@PathVariable("id") String id) throws CustomerException {
		return customerService.viewCustomer(id);
	}
	@DeleteMapping("/removecustomer/{id}")
	public CustomerDto removeCustomer(@PathVariable("id") String custId) throws CustomerException {
		return customerService.removeCustomer(custId);
	}
	
	@GetMapping("/viewallcustomers")
	public List<CustomerDto> viewAllCustomers(){
		return customerService.viewAllCustomers();
	}
}
