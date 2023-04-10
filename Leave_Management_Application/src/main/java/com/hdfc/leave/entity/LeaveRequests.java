package com.hdfc.leave.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "Leave_Requests")
public class LeaveRequests {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leave_request_id", nullable = false)
	private long leaveRequestId;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employees employee;

	// @NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "startDate")
	private LocalDate startDate;

	@Column(name = "endDate")
	// @NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

	@Column(name = "leaveType")
	@NotEmpty
	private String leaveType;

	@NotBlank(message = "Please enter the reason")
	@NotNull(message = "Please enter the reason")
	private String reason;

	@NotNull
	@Column(name = "status")
	private String status;

}
