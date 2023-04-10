package com.hdfc.leave.DTO;

import java.time.LocalDate;

import com.hdfc.leave.entity.Employees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LeaveRequestDTO {
	
	
	private long leaveRequestId;

	private Employees employee;

	private LocalDate startDate;

	private LocalDate endDate;

	private String leaveType;
	
	private String reason;
	
	private String status;

}
