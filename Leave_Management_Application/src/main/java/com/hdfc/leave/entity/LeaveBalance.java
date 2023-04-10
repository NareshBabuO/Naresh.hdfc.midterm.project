package com.hdfc.leave.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "leave_Balance")
public class LeaveBalance {

	@Id
	@Column(name = "leave_Balance_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaveBalanceId;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employees employee;

	@NotEmpty
	private String leaveType;

	@NotNull
	private int balance;

}
