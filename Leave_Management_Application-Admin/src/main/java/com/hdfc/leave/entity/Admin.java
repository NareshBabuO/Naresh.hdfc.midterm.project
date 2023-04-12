package com.hdfc.leave.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin {

	private long leaveRequestId;

	private Employees employee;

	private LocalDate startDate;

	private LocalDate endDate;

	private String leaveType;

	private String reason;

	private String status;

	private String comments;

}
