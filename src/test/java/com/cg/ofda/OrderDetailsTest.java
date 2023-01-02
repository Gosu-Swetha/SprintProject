package com.cg.ofda;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofda.dto.AddressDto;
import com.cg.ofda.dto.CustomerDto;
import com.cg.ofda.dto.FoodCartDto;
import com.cg.ofda.dto.OrderDetailsDto;
import com.cg.ofda.exception.OrderDetailsException;
import com.cg.ofda.repository.IOrderRepository;
import com.cg.ofda.service.IOrderDetailsServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class OrderDetailsTest {

			@Mock
			IOrderRepository orderRepositoryMock;

			@InjectMocks
			IOrderDetailsServiceImpl orderServiceMock;
			
			 OrderDetailsDto o1,o2;
			 
			 @BeforeAll
				static void setUpBeforeClass() throws Exception {

				}

				@AfterAll
				static void tearDownAfterClass() throws Exception {
				}
				
				
				@BeforeEach
				void setUp() throws Exception {
					o1 = new OrderDetailsDto(100,LocalDateTime.now(),new FoodCartDto("501",new CustomerDto("1","Harshali","Pote",23,"F","8675901234","harsh@134.com",new AddressDto("102", "KanishkaApt","Street9", "ShalimarBagh", "NewDelhi", "Delhi","India","110088"))),"Delivered");
					o2 = new OrderDetailsDto(101,LocalDateTime.now(),new FoodCartDto("502",new CustomerDto("2","Sneha","Taneja",23,"F","8675905678","sat@123.com",new AddressDto("101", "Skyhall","101Street", "Bandra", "Mumbai", "Maharashtra","India","110001"))),"Delivered");
				}
		
				@AfterEach
				void tearDown() throws Exception {

			}
				
				@Test
				public void addOrderTest() {
					when(orderRepositoryMock.save(o1)).thenReturn(o1);
					assertEquals(100,orderServiceMock.addOrder(o1).getOrderId());
				}
				
			
				@Test
				public void deleteOrderTest() {
					when(orderRepositoryMock.findById(100)).thenReturn(Optional.of(o1));
					assertEquals(o1, orderServiceMock.removeOrder(100));
				}

				@Test
				public void updateOrderDetailsTest() {
					when(orderRepositoryMock.save(o1)).thenReturn(o1);
					assertEquals(100,orderServiceMock.updateOrder(o1).getOrderId());
				}
				
				@Test
				public void viewOrderByIdTest() {

					when(orderRepositoryMock.findById(100)).thenReturn(Optional.of(o1));
					assertEquals(100,orderServiceMock.viewOrder(100).getOrderId());

				
					Exception exception = assertThrows(OrderDetailsException.class, () -> orderServiceMock.viewOrder(111));
					assertTrue(exception.getMessage().contains("There are no orderdetails having id:" + 111));

					

				}
	}