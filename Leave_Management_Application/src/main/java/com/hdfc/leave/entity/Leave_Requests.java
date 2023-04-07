package com.hdfc.leave.entity;

import java.time.LocalDate;

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
		private long leave_request_id;
		
		@ManyToOne
		@JoinColumn(name = "employee_id")
		private Employees employee_id;
		
		@NotEmpty
		@Column(name = "start_date")
		private LocalDate start_date;
		
		@Column(name = "end_date")
		@NotEmpty
		private LocalDate end_date;
		
		@Column(name = "leave_type")
		@NotEmpty
		private String leave_type;
		@NotNull
		@Column(name = "status")
		private String status;

	}

