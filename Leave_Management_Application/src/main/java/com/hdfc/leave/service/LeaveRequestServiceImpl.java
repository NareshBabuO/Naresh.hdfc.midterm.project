package com.hdfc.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.repository.LeaveRequestRepo;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	LeaveRequestRepo repo;

	@Override
	public LeaveRequests requestLeaves(LeaveRequestDTO lRequestDTO) {

		LeaveRequests leave_Requests = new LeaveRequests();

		leave_Requests.setLeaveRequestId(lRequestDTO.getLeaveRequestId());
		leave_Requests.setEmployee(lRequestDTO.getEmployee());
		leave_Requests.setStartDate(lRequestDTO.getStartDate());
		leave_Requests.setEndDate(lRequestDTO.getEndDate());
		leave_Requests.setLeaveType(lRequestDTO.getLeaveType());
		leave_Requests.setReason(lRequestDTO.getReason());
		leave_Requests.setStatus("Pending");

		return repo.save(leave_Requests);
	}

	@Override
	public LeaveRequests getRequestById(long leaveRequestId) {
		return repo.findById(leaveRequestId).orElse(null);
	}

	@Override
	public void deleteRequestById(long leaveRequestId) {
		repo.deleteById(leaveRequestId);
	}

	@Override
	public LeaveRequests updateLeave(LeaveRequestDTO lRequestDTO) {
		return repo.save(lRequestDTO);
	}

	@Override
	public List<LeaveRequests> getAllRequest() {
		return repo.findAll();
	}

}
