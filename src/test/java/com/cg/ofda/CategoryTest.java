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
import com.cg.ofda.exception.CategoryException;
import com.cg.ofda.repository.ICategoryRepository;
import com.cg.ofda.service.ICategoryServiceImpl;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CategoryTest {

	@Mock ICategoryRepository categoryRepositoryMock;

	@InjectMocks ICategoryServiceImpl categoryServiceMock;
	
	 CategoryDto c1,c2;
	 
	 @BeforeAll
		static void setUpBeforeClass() throws Exception {

		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}
		
		
		@BeforeEach
		void setUp() throws Exception {
			c1 =  new CategoryDto("401","Category1");
			c2 =  new CategoryDto("402","Category2");

			
		}
		
		@AfterEach
		void tearDown() throws Exception {
		}

		
		
		@Test
		public void addcategoryTest() {
			when(categoryRepositoryMock.save(c1)).thenReturn(c1);
			assertEquals("401",categoryServiceMock.addCategory(c1).getCatId());
		}
		
	

		@Test
		public void updatecategoryTest() {
			when(categoryRepositoryMock.save(c1)).thenReturn(c1);
			assertEquals("Category1",categoryServiceMock.updateCategory(c1).getCategoryName());
		}
	

			
			@Test
			public void viewcategoryTest() {

				when(categoryRepositoryMock.findById("402")).thenReturn(Optional.of(c2));
				assertEquals("402", categoryServiceMock.viewCategory("402").getCatId());

				Exception exception = assertThrows(CategoryException.class, () -> categoryServiceMock.viewCategory("244"));
				assertTrue(exception.getMessage().contains("There are no category having id:244"));

			}

}
