package com.hdfc.leave.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;

public interface LeaveBalanceService {

	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO);

	public LeaveBalance UpdateBalanceById(LeaveBalanceDTO leaveBalanceId);

	public List<LeaveBalance> getBalanceByEmpId(long employee_id);


	public void deleteBalanceById(long leaveBalanceId);

	public List<LeaveBalance> getAllBalance();

	public LeaveBalance getBalanceById(long leaveBalanceId);
	
	  public LeaveBalance updateBalance(@RequestParam("leaveBalanceId") long
	  leaveRequestId,
	  
	  @RequestParam("balance") int balance, @RequestParam("leaveType") LeaveType
	  leaveType);
	 

}
