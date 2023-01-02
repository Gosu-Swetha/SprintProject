package com.cg.ofda;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
import com.cg.ofda.dto.BillDto;
import com.cg.ofda.dto.CustomerDto;
import com.cg.ofda.dto.FoodCartDto;
import com.cg.ofda.dto.OrderDetailsDto;
import com.cg.ofda.exception.BillException;
import com.cg.ofda.repository.IBillRepository;
import com.cg.ofda.service.IBillServiceImpl;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class BillTest {


	@Mock IBillRepository billRepositoryMock;

	@InjectMocks IBillServiceImpl billServiceMock;
	
	 BillDto b1,b2;
	 
	 @BeforeAll
		static void setUpBeforeClass() throws Exception {

		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}
		
		
		@BeforeEach
		void setUp() throws Exception {
			b1 = new BillDto("101",LocalDate.now(),new OrderDetailsDto(100,LocalDateTime.now(),new FoodCartDto("501",new CustomerDto("1","Harshali","Pote",23,"F","8675901234","harsh@134.com",new AddressDto("102", "KanishkaApt","Street9", "ShalimarBagh", "NewDelhi", "Delhi","India","110088"))),"Delivered"),3,5000);
			b2 = new BillDto("102",LocalDate.now(),new OrderDetailsDto(100,LocalDateTime.now(),new FoodCartDto("501",new CustomerDto("1","Harshali","Pote",23,"F","8675901234","harsh@134.com",new AddressDto("102", "KanishkaApt","Street9", "ShalimarBagh", "NewDelhi", "Delhi","India","110088"))),"Delivered"),3,5000);

		}
		
		//		public BillDto(String billid, LocalDate billDate, OrderDetailsDto order, int totalitem, double totalcost) {
		

		@AfterEach
		void tearDown() throws Exception {
		}

		
		
		@Test
		public void addBillTest() {
			when(billRepositoryMock.save(b1)).thenReturn(b1);
			assertEquals("101",billServiceMock.addBill(b1).getBillid());
		}
		

		@Test
		public void updateBillTest() {
			when(billRepositoryMock.save(b1)).thenReturn(b1);
			assertEquals("101",billServiceMock.updateBill(b1).getBillid());
		}
	

			
			@Test
			public void viewBillTest() {

				when(billRepositoryMock.findById("101")).thenReturn(Optional.of(b1));
				assertEquals("101", billServiceMock.viewBill("101").getBillid());

				Exception exception = assertThrows(BillException.class, () -> billServiceMock.viewBill("12"));
				assertTrue(exception.getMessage().contains("There are no bills having id:12"));

			}


}
