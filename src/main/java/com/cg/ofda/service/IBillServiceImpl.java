package com.cg.ofda.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ofda.dto.BillDto;
import com.cg.ofda.exception.BillException;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.repository.IBillRepository;
import com.cg.ofda.repository.ICustomerRepository;

@Service
public class IBillServiceImpl implements IBillService{

	@Autowired
	IBillRepository billRepository;
	@Autowired
	ICustomerRepository customerRepository;
	
	
	/* @author : Eurekha *
	 * @return : BillDto *
	 * @description : This method adds the Bill in the repository and returns Bill */
	
	@Override
	public BillDto addBill(BillDto bill) throws BillException {
		if(billRepository.existsById(bill.getBillid())) {
			throw new BillException("Bill alredy exists");
		}
		else {
			 return billRepository.save(bill);	 
		}
			
	}
	
	
	
	/* @author : Eurekha *
	 * @return : BillDto *
	 * @description : This method updates the Bill in the repository and returns Bill */
	
	@Override
	public BillDto updateBill(BillDto bill) {
			return billRepository.save(bill);
	}

	
	
	/* @author : Eurekha *
	 * @return : BillDto *
	 * @description : This method deletes the Bill from the repository and returns Bill */
	
	@Override
	public BillDto removeBill(String billId) throws BillException {
		if(billRepository.existsById(billId)) {
		BillDto bill = billRepository.findById(billId).get();
		billRepository.delete(bill);
		return bill;
		}
		else
			throw new BillException("Bill Id not found");
	}
	
	
	
	/* @author : Eurekha *
	 * @return : List<BillDto> *
	 * @description : This method is to view all the Bills in the repository and returns the list of Bills */
		
	public List<BillDto> viewBills(){
		return billRepository.findAll();
		}
	
	
	
	/* @author : Eurekha*
	 * @return : double total cost *
	 * @description : This method calculates the total cost  and returns the total cost */


	@Override
	public double calculateTotalCost(String billId) throws BillException {
		if(billRepository.existsById(billId)) {
		BillDto bill = billRepository.findById(billId).get();
		return bill.getTotalitem()*bill.getTotalcost();
		}
		else
			throw new BillException("Bill does not exist");
	}
	
	/* @author : Eurekha *
	 * @return : BillDto *
	 * @description : This method displays the Bill as per the bill id from the repository and returns Bill */
	
	
	@Override
	public BillDto viewBill(String billId) {
		Optional<BillDto> findById = billRepository.findById(billId);

		return findById.orElseThrow(() -> new BillException("There are no bills having id:" + billId));
	}
	
	/* @author : Eurekha*
	 * @return : List<BillDto> *
	 * @description : This method displays the Bill as per the CutomerId  from the repository and returns the list of bills*/
	
	
	@Override
	public List<BillDto> viewBillsByCustomerId(String custId) throws CustomerException  {
		List<BillDto> bills=billRepository.findAll();
		List<BillDto> billsByCustomer=new ArrayList<>();
		if(customerRepository.existsById(custId)) {
		for(BillDto bill:bills)
		{
			String customerId=bill.getOrder().getCart().getCustomer().getCustomerId();
			
			if(customerId.equals(custId))
			{
				billsByCustomer.add(bill);
			}
		}
		return billsByCustomer;
		}
		else
			throw new CustomerException("Customer Id not found");
	}
	
	
	/* @author : Eurekha *
	 * @return : List<BillDto> *
	 *@description : This method displays the Bills between the date range from the repository and returns the list of bills*/

	@Override
	public List<BillDto> viewBillsByDate(LocalDate startDate, LocalDate endDate)  {
		
		return billRepository.viewBillsByDate(startDate, endDate);
	}
	

	

	

}
