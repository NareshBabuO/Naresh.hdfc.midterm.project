package com.hdfc.leave.DTO;

import org.springframework.stereotype.Service;

import com.hdfc.leave.entity.Employees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Service
public class LeaveBalanceDTO {

	private int leaveBalanceId;

	private Employees employee;

	private String leaveType;

	private int balance;
}
