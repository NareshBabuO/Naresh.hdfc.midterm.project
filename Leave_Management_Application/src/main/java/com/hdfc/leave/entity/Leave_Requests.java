package com.hdfc.leave.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "leave_Requests")
public class Leave_Requests {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int leave_request_id;
		
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

