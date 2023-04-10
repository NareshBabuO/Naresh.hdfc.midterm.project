package com.hdfc.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.exception.leaveRequestNotFoundException;
import com.hdfc.leave.repository.LeaveRequestRepo;
import com.hdfc.leave.service.LeaveRequestService;

@RestController
@RequestMapping("/project/leaveRequest")
public class LeaveRequestController {

	@Autowired
	LeaveRequestRepo repo;

	@Autowired
	LeaveRequestService service;

	@PostMapping("/addRequest")
	public LeaveRequests requestLeave(@RequestBody LeaveRequestDTO lRequestDTO) {
		return service.requestLeaves(lRequestDTO);
	}

	@GetMapping("/getById/{leaveRequestId}")
	public LeaveRequests getRequestById(@PathVariable long leaveRequestId) throws leaveRequestNotFoundException {

		LeaveRequests requestById = service.getRequestById(leaveRequestId);

		if (!requestById.equals(requestById)) {
			throw new leaveRequestNotFoundException(" Leave Request Not found" + leaveRequestId);
		}
		return requestById;
	}

	@DeleteMapping("/delete/{leaveRequestId}")
	public ResponseEntity<String> deleteRequestById(@PathVariable long leaveRequestId) {
		service.deleteRequestById(leaveRequestId);
		return new ResponseEntity<String>("record Deleted", HttpStatus.GONE);
	}

	@GetMapping("/getAll")
	public List<LeaveRequests> getAllRequest() {
		return service.getAllRequest();
	}

}
