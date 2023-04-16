package com.hdfc.leave.service;

import java.util.List;
import java.util.Optional;

import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.enums.StatusType;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;
import com.hdfc.leave.exception.LeaveRequestNotFoundException;

public interface LeaveRequestService {

	public LeaveRequests requestLeave(long employeeId, String startDate, String endDate, LeaveType leaveType,
			String reason) throws EmployeeNotFoundException;

	public List<LeaveRequests> getRequestByEmpId(long employeeId) throws LeaveRequestNotFoundException;

	public void deleteRequestById(long leaveRequestId) throws LeaveRequestNotFoundException;

	public LeaveRequests getRequestById(long leaveRequestId) throws LeaveRequestNotFoundException;

	public List<LeaveRequests> getAllRequest() throws LeaveRequestNotFoundException;

	public LeaveRequests updateRequest(long leaveRequestId, long employeeId, String startDate, String endDate,
			LeaveType leaveType, String reason) throws EmployeeNotFoundException, LeaveRequestNotFoundException;

	public LeaveRequests responseForRequest(long leaveRequestId, StatusType status, String comment)
			throws LeaveRequestNotFoundException, LeaveBalanceNotFoundException;


}
