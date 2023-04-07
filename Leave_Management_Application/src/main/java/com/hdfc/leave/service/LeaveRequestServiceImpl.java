package com.hdfc.leave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.entity.Leave_Requests;
import com.hdfc.leave.repository.LeaveRequestRepo;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	LeaveRequestRepo repo;

	@Override
	public Leave_Requests requestLeave(Leave_Requests lRequest) {
		return repo.save(lRequest);
	}

	@Override
	public Leave_Requests findById(Long employee_id) {
		return repo.findById(employee_id).orElse(null);
	}

}
