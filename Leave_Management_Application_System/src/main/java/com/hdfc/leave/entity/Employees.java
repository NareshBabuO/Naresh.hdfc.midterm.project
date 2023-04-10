package com.hdfc.leave.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Employees")
public class Employees {

	@Id
	private long employeeId;

	@NotBlank(message = "Please enter the name")
	@NotNull(message = "Please enter the name")
	@Pattern(regexp = "^[A-Z][a-z]*([ ][A-Z][a-z]*)*$", message = "New word in name should start with uppercase")
	private String name;

	@Email(message = "Must be a well-formed email address ")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^\\+91[6-9][0-9]{9}$", message = "Invalid Number")
	private String phoneNumber;

	@NotNull(message = "Please enter the Department")
	private String department;

}
