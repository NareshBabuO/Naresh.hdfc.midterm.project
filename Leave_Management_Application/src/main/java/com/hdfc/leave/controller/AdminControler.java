package com.hdfc.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.enums.StatusType;
import com.hdfc.leave.service.LeaveBalanceService;
import com.hdfc.leave.service.LeaveRequestService;

@RestController
@RequestMapping("/Admin/Approval")
public class AdminControler {

	@Autowired
	LeaveRequestService lrservice;

	@Autowired
	LeaveBalanceService lbservice;

	@PutMapping("/ResponseRequest")
	public LeaveRequests responseForRequest(@RequestParam("leaveRequestId") long leaveRequestId,
			@RequestParam("status") StatusType status, @RequestParam("comment") String comment) {
		return lrservice.responseForRequest(leaveRequestId, status, comment);

	}

	@GetMapping("/getAllRequest")
	public List<LeaveRequests> getAllRequest() {
		return lrservice.getAllRequest();
	}

	@GetMapping("/getAllBalance")
	public List<LeaveBalance> getAllBalance() {
		return lbservice.getAllBalance();
	}
	/*
	 * @PutMapping("/UpdateBalance") public LeaveBalance
	 * updateBalance(@RequestParam("leaveBalanceId") long leaveBalanceId,
	 * 
	 * @RequestParam("balance") int balance, @RequestParam("leaveType") LeaveType
	 * leaveType) { return lbservice.updateBalance(leaveRequestId, balance,
	 * leaveType);
	 * 
	 * }
	 */

}
