package com.hdfc.leave.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeesDTO {

	private long employeeId;

	private String name;

	private String email;
	private String phoneNumber;

	private String department;
}