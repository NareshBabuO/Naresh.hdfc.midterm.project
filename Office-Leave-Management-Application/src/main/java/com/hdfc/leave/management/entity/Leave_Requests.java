package com.hdfc.leave.management.entity;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Leave_Requests")
public class Leave_Requests {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "employee_id")
	private Employees employee_id;
	
	@Column(name = "start_date")
	private LocalDate start_date;
	
	@Column(name = "end_date")
	private LocalDate end_date;
	
	@Column(name = "leave_type")
	private String leave_type;
	
	@Column(name = "status")
	private String status;

}
