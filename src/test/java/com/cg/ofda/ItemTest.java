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
import com.cg.ofda.dto.CategoryDto;
import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.exception.ItemException;
import com.cg.ofda.repository.IItemRepository;
import com.cg.ofda.service.IItemServiceImpl;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ItemTest {

	@Mock IItemRepository itemRepositoryMock;

	@InjectMocks IItemServiceImpl itemServiceMock;
	
	 ItemDto i1,i2;
	 
	 @BeforeAll
		static void setUpBeforeClass() throws Exception {

		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}
		
		
		@BeforeEach
		void setUp() throws Exception {
			i1 = new ItemDto("501","Manchurian",new CategoryDto("401","Category1"),30,800);
					

		}
		
		@AfterEach
		void tearDown() throws Exception {
		}

		
		
		@Test
		public void addItemTest() {
			when(itemRepositoryMock.save(i1)).thenReturn(i1);
			assertEquals("Manchurian",itemServiceMock.addItem(i1).getItemName());
		}

		@Test
		public void updateitemTest() {
			when(itemRepositoryMock.save(i1)).thenReturn(i1);
			assertEquals("501",itemServiceMock.updateItem(i1).getItemId());
		}
	

			
			@Test
			public void viewRestaurantTest() {

				when(itemRepositoryMock.findById("501")).thenReturn(Optional.of(i1));
				assertEquals("501", itemServiceMock.viewItem("501").getItemId());

				Exception exception = assertThrows(ItemException.class, () -> itemServiceMock.viewItem("12"));
				assertTrue(exception.getMessage().contains("There are no item having id:12"));

			}
}
