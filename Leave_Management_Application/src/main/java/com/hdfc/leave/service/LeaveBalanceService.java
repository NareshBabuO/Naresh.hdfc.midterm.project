package com.hdfc.leave.service;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;

public interface LeaveBalanceService {

	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO);

	public LeaveBalance UpdateBalance(LeaveBalanceDTO lbDTO);

}
