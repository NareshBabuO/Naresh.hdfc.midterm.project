package com.hdfc.leave.service;

import java.util.List;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.enums.LeaveType;

public interface LeaveRequestService {

	//public LeaveRequests requestLeaves(LeaveRequestDTO lRequestDTO);

	public LeaveRequests requestLeave(long employeeId,String startDate,
			String endDate,LeaveType leaveType,String reason);
	
	
	public List<LeaveRequests> getRequestByEmpId(long employeeId);
	
	public void deleteRequestById(long leaveRequestId);

	public LeaveRequests getRequestById(long leaveRequestId);

	public List<LeaveRequests> getAllRequest();

	public LeaveRequests updateRequest(LeaveRequestDTO lRequestDTO);

	public LeaveRequests responseForRequest(long leaveRequestId, String status, String comment);


}
