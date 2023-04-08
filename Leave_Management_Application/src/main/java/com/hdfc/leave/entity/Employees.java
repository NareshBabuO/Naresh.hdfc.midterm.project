package com.hdfc.leave.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	private long employee_id;

	@NotBlank(message = "Please enter the name")
	// @UniqueElements
	@NotNull(message = "Please enter the name")
	@Pattern(regexp = "^[A-Z][a-z]*([ ][A-Z][a-z]*)*$", message = "New word in name should start with uppercase")
	private String name;

	@Email(message = "Must be a well-formed email address ")
	private String email;
	@NotNull
	@Pattern(regexp = "^\\+91[6-9][0-9]{9}$", message = "Invalid Number")
	private String phone_number;

	@NotNull(message = "Please enter the Department")
	private String department;
	
	
}