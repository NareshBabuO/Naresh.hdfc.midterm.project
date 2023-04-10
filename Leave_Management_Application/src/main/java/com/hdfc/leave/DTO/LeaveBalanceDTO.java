package com.hdfc.leave.DTO;

import com.hdfc.leave.entity.Employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeaveBalanceDTO {
	
	private int leaveBalanceId;
	
	private Employees employee;
	
	private String leaveType;
	
	private int balance;
}
