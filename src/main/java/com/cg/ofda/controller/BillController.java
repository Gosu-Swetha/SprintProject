package com.cg.ofda.controller;

import java.time.LocalDate;
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
import com.cg.ofda.dto.BillDto;
import com.cg.ofda.exception.BillException;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.service.IBillServiceImpl;

import jakarta.validation.Valid;

@RestController
	@RequestMapping("/bills")
	public class BillController {
		@Autowired
		IBillServiceImpl ibillService;
		
		@PostMapping("/addbill")
		public BillDto addBill(@Valid @RequestBody BillDto bill) throws BillException {
			return ibillService.addBill(bill);
		}
		
		@PutMapping("/updatebill")
		public BillDto updateBill(@Valid @RequestBody BillDto bill) {
			return ibillService.updateBill(bill);
		}
		@DeleteMapping("/removebill/{billId}")
		public BillDto removeBill(@PathVariable("billId" )String billId) throws BillException {
			return ibillService.removeBill(billId);
		}
		
		@GetMapping("/viewbill/{billId}")
			public BillDto viewBill(@PathVariable("billId") String billId) {
				return ibillService.viewBill(billId);
			}
		
		@GetMapping("/viewallbills")
		public List<BillDto> viewBills(){
		return ibillService.viewBills();
		}
		
		@GetMapping("/calculatetotalcost/{billId}")
		public double calculateTotalCost(@PathVariable("billId") String billId) throws BillException {
			return ibillService.calculateTotalCost(billId);
		}
		
		@GetMapping("/viewbillsbycustomer/{custId}")
		public List<BillDto> viewBillsByCustomerId(@PathVariable("custId") String custId) throws CustomerException{
			return ibillService.viewBillsByCustomerId(custId);
		}
		
		@GetMapping("/viewbillsbydate/{startDate}/{endDate}")
		public List<BillDto> viewBillsByDate(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate){
			return ibillService.viewBillsByDate(startDate, endDate);
		}
}

