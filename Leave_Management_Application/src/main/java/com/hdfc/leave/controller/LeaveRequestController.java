package com.hdfc.leave.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.exception.LeaveRequestNotFoundException;
import com.hdfc.leave.service.LeaveRequestService;

@RestController
@RequestMapping("/Project/leaveRequest")
public class LeaveRequestController {

	@Autowired
	LeaveRequestService leaveRequestService;

	@PostMapping("/addRequest")
	public LeaveRequests requestLeave(@RequestParam("employeeId") long employeeId,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("leaveType") LeaveType leaveType, @RequestParam("reason") String reason)
			throws EmployeeNotFoundException {
		return leaveRequestService.requestLeave(employeeId, startDate, endDate, leaveType, reason);
	}

	/*
	 * @PutMapping("/Update") public LeaveRequests
	 * updateRequest(@RequestParam("leaveRequestId") long leaveRequestId,
	 * 
	 * @RequestParam("employeeId") long employeeId, @RequestParam("startDate")
	 * String startDate,
	 * 
	 * @RequestParam("endDate") String endDate, @RequestParam("leaveType") LeaveType
	 * leaveType,
	 * 
	 * @RequestParam("reason") String reason) throws EmployeeNotFoundException,
	 * LeaveRequestNotFoundException { return service.updateRequest(leaveRequestId,
	 * employeeId, startDate, endDate, leaveType, reason);
	 * 
	 * }
	 */

	@PutMapping("/Update")
	public ResponseEntity<?> updateLeaveRequest(@RequestParam("leaveRequestId") long leaveRequestId,
			@RequestParam("employeeId") long employeeId, @RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("leaveType") LeaveType leaveType,
			@RequestParam("reason") String reason) {
		try {
			LeaveRequests leaveRequest = leaveRequestService.updateRequest(leaveRequestId, employeeId, startDate,
					endDate, leaveType, reason);
			return ResponseEntity.ok().body("Leave request updated successfully with ID: " + leaveRequestId);
		} catch (EmployeeNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (LeaveRequestNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/*
	 * public LeaveRequests getRequestById(@PathVariable long leaveRequestId) throws
	 * LeaveRequestNotFoundException { return
	 * leaveRequestService.getRequestById(leaveRequestId);
	 * 
	 * }
	 */
	@GetMapping("/getById/{leaveRequestId}")
	public ResponseEntity<LeaveRequests> getRequestById(
			@PathVariable(value = "leaveRequestId") long leaveRequestId) throws LeaveRequestNotFoundException {
		try {
			LeaveRequests request = leaveRequestService.getRequestById(leaveRequestId);
			return ResponseEntity.ok(request);
		} catch (LeaveRequestNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

//	@GetMapping("/GetByEmpId/{employee_id}")
	/*
	 * public List<LeaveRequests> getRequestByEmpId(long employee_id) throws
	 * LeaveRequestNotFoundException { return
	 * leaveRequestService.getRequestByEmpId(employee_id); }
	 */

	/*
	 * public ResponseEntity<List<LeaveRequests>> getRequestByEmpId(@PathVariable
	 * Long employeeId) throws EmployeeNotFoundException { try { List<LeaveRequests>
	 * leaveRequests = leaveRequestService.getRequestByEmpId(employeeId); return
	 * ResponseEntity.ok(leaveRequests); } catch (LeaveRequestNotFoundException e) {
	 * return ResponseEntity.notFound().build(); } }
	 */
	@GetMapping("/GetByEmpId/{employeeId}")
	public ResponseEntity<?> getRequestByEmpId(@PathVariable Long employeeId) throws EmployeeNotFoundException {
		try {
			List<LeaveRequests> leaveRequests = leaveRequestService.getRequestByEmpId(employeeId);
			return ResponseEntity.ok(leaveRequests);
		} catch (LeaveRequestNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No leave requests found for employee with ID: " + employeeId);
		}
	}

	@DeleteMapping("/delete/{leaveRequestId}")
	public ResponseEntity<String> deleteRequestById(@PathVariable long leaveRequestId)
			throws LeaveRequestNotFoundException {
		leaveRequestService.deleteRequestById(leaveRequestId);
		return new ResponseEntity<String>("record Deleted", HttpStatus.GONE);
	}

	/*
	 * @DeleteMapping("/delete/{leaveRequestId}") public ResponseEntity<?>
	 * deleteRequestById(@PathVariable(value = "leaveRequestId") long
	 * leaveRequestId) { try {
	 * leaveRequestService.deleteRequestById(leaveRequestId); return
	 * ResponseEntity.ok().build(); } catch (LeaveRequestNotFoundException e) {
	 * return ResponseEntity.notFound().build(); } }
	 */
	@GetMapping("/getAll")
	public List<LeaveRequests> getAllRequest() throws LeaveRequestNotFoundException {
		return leaveRequestService.getAllRequest();
	}

	/*
	 * @PutMapping("/Response") public LeaveRequests
	 * responseForRequest(@RequestParam("leaveRequestId") long leaveRequestId,
	 * 
	 * @RequestParam("status") String status, @RequestParam("comment") String
	 * comment) { return service.responseForRequest(leaveRequestId, status,
	 * comment);
	 * 
	 * }
	 */

}
