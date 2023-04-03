package com.hdfc.leave.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employees")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employee_id;

	@NotEmpty(message = "Please provide name!")
	@Length(min = 5, message = "Choose atleast three characters for name !")
	@Column(name = "name")
	private String name;

	@NotEmpty(message = "E-mail cannot be empty!")
	@Email(message = "Please provide a valid email!")
	@Column(name = "email")
	private String email;

	@NotNull
	@Pattern(regexp = "^\\+91[6-9][0-9]{9}$", message = "Invalid Number")
	@Column(name = "phone_number")
	private long phone_number;

	@NotEmpty(message = "Please provide a department!")
	@Column(name = "department")
	private String department;

}
