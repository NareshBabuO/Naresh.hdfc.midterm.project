package com.hdfc.leave.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hdfc.leave.enums.LeaveType;

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
	@Enumerated
	private LeaveType leaveType;

	@NotBlank(message = "Please enter the reason")
	@NotNull(message = "Please enter the reason")
	private String reason;

	@NotNull
	@Column(name = "status")
	private String status;
	
	@Column(name="Comments")
	private String comments;

}
