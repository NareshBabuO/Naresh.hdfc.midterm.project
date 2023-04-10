package com.hdfc.leave.service;

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
	public LeaveRequests requestLeave(LeaveRequestDTO lRequestDTO) {

		LeaveRequests leave_Requests = new LeaveRequests();

		leave_Requests.setLeaveRequestId(lRequestDTO.getLeaveRequestId());
		leave_Requests.setEmployee(lRequestDTO.getEmployee());
		leave_Requests.setStartDate(lRequestDTO.getStartDate());
		leave_Requests.setEndDate(lRequestDTO.getEndDate());
		leave_Requests.setLeaveType(lRequestDTO.getLeaveType());
		leave_Requests.setStatus("Pending");

		 return repo.save(leave_Requests);
	}

	@Override
	public LeaveRequests getRequestById(long leaverequestid) {
		return repo.findById(leaverequestid).orElse(null);
	}

	@Override
	public void deleteRequestById(long leaverequestid) {
		repo.deleteById(leaverequestid);
	}

	@Override
	public LeaveRequests updateLeave(LeaveRequestDTO lRequestDTO) {
		return repo.save(lRequestDTO);
	}

}
