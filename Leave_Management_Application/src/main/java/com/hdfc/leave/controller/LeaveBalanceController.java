package com.hdfc.leave.controller;
/**
 *@author NareshBabu O
 *@created 12-April-2023
*
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;
import com.hdfc.leave.service.LeaveBalanceService;

@RestController
@RequestMapping("/Project/leaveBalance")
public class LeaveBalanceController {

	@Autowired
	LeaveBalanceService leaveBalanceService;

	@GetMapping("/getAll")
	public List<LeaveBalance> getAllBalace() {
		return leaveBalanceService.getAllBalance();
	}

	/*
	 * public List<LeaveBalance> getBalanceByEmpId(long employee_id) throws
	 * LeaveBalanceNotFoundException{ return service.getBalanceByEmpId(employee_id);
	 * }
	 */

	@GetMapping("/GetByEmpId/{employee_id}")
	public ResponseEntity<?> getLeaveBalanceByEmpId(@PathVariable("employee_id") long employeeId) {
		try {
			List<LeaveBalance> leaveBalances = leaveBalanceService.getBalanceByEmpId(employeeId);
			return ResponseEntity.ok().body(leaveBalances);
		} catch (LeaveBalanceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Leave balance not found for employee with ID: " + employeeId);
		}
	}

	// @GetMapping("/GetAllBalancePerEmployee/{employee_id}")
	// public Integer getAllLeaveByEmpID(@Param("employee_id") long employee_id)
	// throws LeaveBalanceNotFoundException {
	// return leaveBalanceService.getAllLeaveByEmpID(employee_id);

//	}

	@GetMapping("/GetAllBalancePerEmployee/{employee_id}")
	public ResponseEntity<?> getAllLeaveByEmpID(@PathVariable("employee_id") long employeeId) {
		try {
			Integer leaveCount = leaveBalanceService.getAllLeaveByEmpID(employeeId);
			return ResponseEntity.ok().body(leaveCount);
		} catch (LeaveBalanceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No leave found for employee with ID: " + employeeId);
		}
	}
	
	

	@GetMapping("/GetBalByLeaveType/{employee_id}/{leaveType}")
	public LeaveBalance getLeaveByEmpAndLeaveType(@Param("employee_id") long employee_id,
			@Param("leaveType") LeaveType leaveType) {
		return leaveBalanceService.getLeaveByEmpAndLeaveType(employee_id, leaveType);

	}

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

}
