package com.hdfc.leave.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Leave_Balances")
public class Leave_Balances {

	// leave_balance_id, employee_id, leave_type, balance

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="leave_balance_id")
	private int leave_balance_id;
	
	
	private Employees employee_id;
	
	
	private Leave_Requests leave_type;
	
	
	private int balance;

}
