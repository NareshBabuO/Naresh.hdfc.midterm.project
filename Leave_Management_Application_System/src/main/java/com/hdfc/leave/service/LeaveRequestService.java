package com.hdfc.leave.service;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.LeaveRequests;

public interface LeaveRequestService {
	
	public LeaveRequests requestLeave(LeaveRequestDTO lRequestDTO);
	
	public void deleteRequestById(long leaverequestid);
	
	public LeaveRequests getRequestById(long leaverequestid);
	
	public LeaveRequests  updateLeave(LeaveRequestDTO lRequestDTO);


}
