package com.hdfc.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.enums.StatusType;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;
import com.hdfc.leave.exception.LeaveRequestNotFoundException;
import com.hdfc.leave.service.LeaveBalanceService;
import com.hdfc.leave.service.LeaveRequestService;

@RestController
@RequestMapping("/Admin/Approval")
public class AdminControler {

	@Autowired
	LeaveRequestService leaveRequestService;

	@Autowired
	LeaveBalanceService leaveBalanceService;

	@PutMapping("/ResponseRequest")
	public LeaveRequests responseForRequest(@RequestParam("leaveRequestId") long leaveRequestId,
			@RequestParam("status") StatusType status, @RequestParam("comment") String comment)
			throws LeaveRequestNotFoundException, LeaveBalanceNotFoundException {
		return leaveRequestService.responseForRequest(leaveRequestId, status, comment);

	}

	@GetMapping("/getAllRequest")
	public List<LeaveRequests> getAllRequest() throws LeaveRequestNotFoundException {
		return leaveRequestService.getAllRequest();
	}

	@GetMapping("/getAllBalance")
	public List<LeaveBalance> getAllBalance() {
		return leaveBalanceService.getAllBalance();
	}

	@GetMapping("/GetAllBalancePerEmployee/{employee_id}")
	public Integer getAllLeaveByEmpID(@Param("employee_id") long employee_id)
			throws EmployeeNotFoundException, LeaveBalanceNotFoundException {

		return leaveBalanceService.getAllLeaveByEmpID(employee_id);

	}

	@GetMapping("/GetBalByLeaveType/{employee_id}/{leaveType}")
	public LeaveBalance getLeaveByEmpAndLeaveType(@Param("employee_id") long employee_id,
			@Param("leaveType") LeaveType leaveType) {
		return leaveBalanceService.getLeaveByEmpAndLeaveType(employee_id, leaveType);

	}

	/*
	 * @PutMapping("/EmployeeAbsent/{employee_id}") public LeaveBalance
	 * updateBalanceIfEmployeeAbsent(@Param("employee_id") long employee_id) throws
	 * LeaveBalanceNotFoundException { return
	 * leaveBalanceService.updateBalanceIfEmployeeAbsent(employee_id); }
	 */

	@PutMapping("/EmployeeAbsent/{employee_id}")
	public LeaveBalance updateBalanceIfEmployeeAbsent(@PathVariable("employee_id") long employeeId) throws LeaveBalanceNotFoundException {
		//try {
		return	leaveBalanceService.updateBalanceIfEmployeeAbsent(employeeId);
		/*
		 * return ResponseEntity.ok("Leave balance updated for employee id " +
		 * employeeId); } catch (LeaveBalanceNotFoundException ex) { return
		 * ResponseEntity.status(HttpStatus.NOT_FOUND)
		 * .body("Leave balance not found for employee id: " + employeeId); }
		 */
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
