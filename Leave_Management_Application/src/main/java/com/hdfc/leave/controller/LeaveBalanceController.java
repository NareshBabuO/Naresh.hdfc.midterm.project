package com.hdfc.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/Project/leaveBalance")
public class LeaveBalanceController {

	@Autowired
	LeaveBalanceService service;

	@Autowired
	LeaveBalanceRepository repo;

	@PostMapping("/addBalance")
	public LeaveBalance AddBalance(@RequestBody LeaveBalanceDTO lbDTO) {
		return service.AddBalance(lbDTO);
	}

	@PutMapping("/updateBalance/{leaveBalanceId}")
	public LeaveBalance UpdateBalanceById(@PathVariable LeaveBalanceDTO leaveBalanceId) {
		return service.UpdateBalanceById(leaveBalanceId);
	}

	@GetMapping("/getAll")
	public List<LeaveBalance> getAllRequest() {
		return service.getAllBalance();
	}
}
