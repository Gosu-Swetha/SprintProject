package com.cg.ofda;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.ofda.dto.AddressDto;
import com.cg.ofda.dto.CustomerDto;
import com.cg.ofda.dto.FoodCartDto;
import com.cg.ofda.repository.ICartRepository;
import com.cg.ofda.service.ICartServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CartTest {

	

	@Mock ICartRepository cartRepositoryMock;

	@InjectMocks ICartServiceImpl cartServiceMock;
	
	 FoodCartDto fc1,fc2;
	 
	 @BeforeAll
		static void setUpBeforeClass() throws Exception {

		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}
		
		
		@BeforeEach
		void setUp() throws Exception {
			fc1 = new FoodCartDto("201",new CustomerDto("1","Harshali","Pote",23,"F","8675901234","harsh@134.com",new AddressDto("102", "KanishkaApt","Street9", "ShalimarBagh", "NewDelhi", "Delhi","India","110088")));
			fc2 = new FoodCartDto("202",new CustomerDto("1","Harshali","Pote",23,"F","8675901234","harsh@134.com",new AddressDto("102", "KanishkaApt","Street9", "ShalimarBagh", "NewDelhi", "Delhi","India","110088")));

		}
		
		@AfterEach
		void tearDown() throws Exception {
		}

		@Test
		public void viewcartTest() {

			when(cartRepositoryMock.findById("201")).thenReturn(Optional.of(fc1));
			assertEquals("201", cartServiceMock.viewCartById("201").getCartId());


		}
		
		

			
			

		}
		
		
			
		


