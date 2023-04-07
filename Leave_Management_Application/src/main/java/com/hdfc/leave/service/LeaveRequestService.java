package com.hdfc.leave.service;

import java.util.List;

import com.hdfc.leave.entity.Leave_Requests;

public interface LeaveRequestService {
	
	public Leave_Requests requestLeave(Leave_Requests lRequest);
	
	public Leave_Requests findById(Long employee_id);

}
