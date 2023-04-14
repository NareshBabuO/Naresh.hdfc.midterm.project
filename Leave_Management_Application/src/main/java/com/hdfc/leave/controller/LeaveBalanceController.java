package com.hdfc.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.service.LeaveBalanceService;

@RestController
@RequestMapping("/Project/leaveBalance")
public class LeaveBalanceController {

	@Autowired
	LeaveBalanceService service;


	/*
	 * @PostMapping("/addBalance") public LeaveBalance AddBalance(@RequestBody
	 * LeaveBalanceDTO lbDTO) { return service.AddBalance(lbDTO); }
	 */
	
	/*
	 * @DeleteMapping("/delete/{leaveBalanceId}") public ResponseEntity<String>
	 * deleteBalanceById(@PathVariable long leaveBalanceId) {
	 * service.deleteBalanceById(leaveBalanceId); return new
	 * ResponseEntity<String>("record Deleted"+leaveBalanceId, HttpStatus.GONE); }
	 */

	/*
	 * @PutMapping("/updateBalance/{leaveBalanceId}") public LeaveBalance
	 * UpdateBalanceById(@PathVariable LeaveBalanceDTO leaveBalanceId) { return
	 * service.UpdateBalanceById(leaveBalanceId); }
	 */

	@GetMapping("/getAll")
	public List<LeaveBalance> getAllBalace() {
		return service.getAllBalance();
	}

	@GetMapping("/GetByEmpId/{employee_id}")
	public List<LeaveBalance> getBalanceByEmpId(long employee_id) {
		return service.getBalanceByEmpId(employee_id);
	}
	
}
