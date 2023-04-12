package com.hdfc.leave.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@JoinColumn(name = "employee_id", nullable = false)
	private Employees employee;
	
	
	@NotNull
	private String leaveType;

	@NotNull
	private int balance;

}
