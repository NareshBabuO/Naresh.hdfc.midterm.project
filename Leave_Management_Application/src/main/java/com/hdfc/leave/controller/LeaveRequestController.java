package com.hdfc.leave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.entity.Leave_Requests;
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
	public Leave_Requests requestLeave(@RequestBody Leave_Requests lRequest) {
		return service.requestLeave(lRequest);

	}

	@GetMapping("/getById/{employee_id}")
	public Leave_Requests findById(Long employee_id) {
		return service.findById(employee_id);

	}

}
