package com.hdfc.leave.DTO;

import java.time.LocalDate;

import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.enums.StatusType;

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
	private LeaveType leaveType;
	private String reason;
	private StatusType status;
	private String comment;

}
