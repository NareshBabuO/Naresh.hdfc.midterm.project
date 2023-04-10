package com.hdfc.leave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.LeaveRequests;
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
		return service.requestLeave(lRequestDTO);
	}

	@GetMapping("/get/{leaverequestid}")
	public LeaveRequests getRequestById(long leaverequestid) {
		return service.getRequestById(leaverequestid);

	}

	@DeleteMapping("/delete/{leaverequestid}")
	public ResponseEntity<String> deleteRequestById(long leaverequestid) {
		service.deleteRequestById(leaverequestid);
		return new ResponseEntity<String>("record Deleted", HttpStatus.GONE);
	}

}
