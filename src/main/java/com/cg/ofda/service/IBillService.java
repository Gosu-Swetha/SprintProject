package com.cg.ofda.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.ofda.dto.BillDto;
import com.cg.ofda.exception.BillException;
import com.cg.ofda.exception.CustomerException;

public interface IBillService {
	
	public BillDto addBill(BillDto bill) throws BillException;
	public BillDto updateBill(BillDto bill);
	public BillDto removeBill(String billId) throws BillException;
	public BillDto viewBill(String billId) throws BillException;
	public List<BillDto> viewBillsByCustomerId(String custId) throws CustomerException;
	public List<BillDto> viewBillsByDate(LocalDate startDate, LocalDate endDate);
	public double calculateTotalCost(String billId);

}
