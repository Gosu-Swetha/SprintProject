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
import com.cg.ofda.dto.RestaurantDto;
import com.cg.ofda.exception.RestaurantException;
import com.cg.ofda.repository.IRestaurantRepository;
import com.cg.ofda.service.IRestaurantServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RestaurantTest {


	@Mock IRestaurantRepository restaurantRepositoryMock;

	@InjectMocks IRestaurantServiceImpl restaurantServiceMock;
	
	 RestaurantDto r1,r2;
	 
	 @BeforeAll
		static void setUpBeforeClass() throws Exception {

		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}
		
		
		@BeforeEach
		void setUp() throws Exception {
			r1 = new RestaurantDto("1", "Deluxe",new AddressDto("101", "Sai nagar","MG", "Ongole", "India", "523279","Maharashtra","416115"),"John","9796888");
			
			r2 = new RestaurantDto("2", " SuperDeluxe",new AddressDto("102", "Indra nagar","HG", "Delhi", "India North", "97327","Karnataka","471571"),"JHarry","725372");
		}
		
		@AfterEach
		void tearDown() throws Exception {
		}

		
		
		@Test
		public void addRestaurantTest() {
			when(restaurantRepositoryMock.save(r1)).thenReturn(r1);
			assertEquals("Deluxe",restaurantServiceMock.addRestaurant(r1).getRestaurantName());
		}
		
		
		@Test
		public void deleteRestaurantTest() {
			when(restaurantRepositoryMock.findById("1")).thenReturn(Optional.of(r1));
			assertEquals(r1, restaurantServiceMock.removeRestaurant("1"));
		}

		@Test
		public void updateRestaurantTest() {
			when(restaurantRepositoryMock.save(r1)).thenReturn(r1);
			assertEquals("Deluxe",restaurantServiceMock.addRestaurant(r1).getRestaurantName());
		}
	

			
			@Test
			public void viewRestaurantTest() {

				when(restaurantRepositoryMock.findById("2")).thenReturn(Optional.of(r2));
				assertEquals("2", restaurantServiceMock.viewRestaurant("2").getRestaurantId());

				Exception exception = assertThrows(RestaurantException.class, () -> restaurantServiceMock.viewRestaurant("12"));
				assertTrue(exception.getMessage().contains("There are no restaurant having id:12"));

			}

		}
		
		
			
		


