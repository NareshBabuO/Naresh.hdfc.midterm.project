package com.hdfc.leave.DTO;

import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.enums.LBalances;
import com.hdfc.leave.enums.LeaveType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LeaveBalanceDTO {

	private long leaveBalanceId;

	private Employees employee;

	private LeaveType leaveType;

	private int balance;
	
	
	
		
	

}
