package com.hdfc.leave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.repository.LeaveBalanceRepository;
import com.hdfc.leave.service.LeaveBalanceService;

@RestController
@RequestMapping("/api/leaveBalance")
public class LeaveBalanceController {
	
	@Autowired
	LeaveBalanceService service;
	
	@Autowired
	LeaveBalanceRepository repo;
	
	@PostMapping("/addBalance")
	public LeaveBalance AddBalance(@RequestBody LeaveBalanceDTO lbDTO) {
		return service.AddBalance(lbDTO);
	}

	@PutMapping("/updateBalance{lbDTO}")
	public LeaveBalance UpdateBalance(LeaveBalanceDTO lbDTO) {
		return service.UpdateBalance(lbDTO);
	}
}
