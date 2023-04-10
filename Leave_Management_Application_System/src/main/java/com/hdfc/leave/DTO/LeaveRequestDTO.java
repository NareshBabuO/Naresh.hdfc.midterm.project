package com.hdfc.leave.DTO;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	private String status;

}
