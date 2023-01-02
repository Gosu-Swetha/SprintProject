package com.cg.ofda;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
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
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.repository.ICustomerRepository;
import com.cg.ofda.service.ICustomerServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CustomerTest {

	
	@Mock ICustomerRepository customerRepositoryMock;

	@InjectMocks ICustomerServiceImpl customerServiceMock;
	
	 CustomerDto cust1,cust2;
	 
	 @BeforeAll
		static void setUpBeforeClass() throws Exception {

		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}
		
		
		@BeforeEach
		void setUp() throws Exception {
			cust1 = new CustomerDto("1","Harshali","Pote",23,"F","8675901234","harsh@134.com",new AddressDto("102", "KanishkaApt","Street9", "ShalimarBagh", "NewDelhi", "Delhi","India","110088"));
			cust2 = new CustomerDto("2","Harsh","Gupta",23,"F","8675901234","harsh@134.com",new AddressDto("102", "KanishkaApt","Street9", "ShalimarBagh", "NewDelhi", "Delhi","India","110088"));

		}
		
		@AfterEach
		void tearDown() throws Exception {
		}

		
		
		@Test
		public void addCustomerTest() {
			when(customerRepositoryMock.save(cust1)).thenReturn(cust1);
			assertEquals("1",customerServiceMock.addCustomer(cust1).getCustomerId());
		}
		

		@Test
		public void updateCustomerTest() {
			when(customerRepositoryMock.save(cust1)).thenReturn(cust1);
			assertEquals("Harshali",customerServiceMock.updateCustomer(cust1).getFirstName());
		}
	

			
			@Test
			public void viewRestaurantTest() {

				when(customerRepositoryMock.findById("2")).thenReturn(Optional.of(cust2));
				assertEquals("2", customerServiceMock.viewCustomer("2").getCustomerId());

				Exception exception = assertThrows(CustomerException.class, () -> customerServiceMock.viewCustomer("12"));
				assertTrue(exception.getMessage().contains("There are no customer having id:12"));

			}
}
