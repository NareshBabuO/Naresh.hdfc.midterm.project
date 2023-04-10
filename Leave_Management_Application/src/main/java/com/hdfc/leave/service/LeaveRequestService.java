package com.hdfc.leave.service;

import java.util.List;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.LeaveRequests;

public interface LeaveRequestService {
	
	public LeaveRequests requestLeaves(LeaveRequestDTO lRequestDTO);
	
	public void deleteRequestById(long leaveRequestId);
	
	public LeaveRequests getRequestById(long leaveRequestId);
	
	public List<LeaveRequests> getAllRequest();
	
	public LeaveRequests  updateLeave(LeaveRequestDTO lRequestDTO);


}
