package com.hdfc.leave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.repository.LeaveRequestRepo;
import com.hdfc.leave.service.LeaveRequestService;

@RestController
@RequestMapping("/Project/Admin")
public class AdminController {
	@Autowired
	LeaveRequestService service;

	@Autowired
	LeaveRequestRepo repo;

	@PutMapping("/Response")
	public LeaveRequests responseForRequest(@RequestParam("leaveRequestId") long leaveRequestId,
			@RequestParam("status") String status, @RequestParam("comment") String comment) {
		return service.responseForRequest(leaveRequestId, status, comment);

	}

}
