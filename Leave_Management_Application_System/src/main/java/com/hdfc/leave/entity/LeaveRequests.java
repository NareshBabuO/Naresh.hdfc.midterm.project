package com.hdfc.leave.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private long leaveRequestId;

	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employees employee;

	@NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

	@NotEmpty
	private String leaveType;
	@NotNull
	@Column(name = "status")
	private String status;
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Column(name = "leave_request_id",nullable = false) private long
	 * leaverequestid;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "employee_id",nullable = false) private Employees
	 * employeeid;
	 * 
	 * @NotEmpty
	 * 
	 * @JsonFormat(pattern = "yyyy-MM-dd")
	 * 
	 * @Column(name = "start_date") private LocalDate startdate;
	 * 
	 * @Column(name = "end_date")
	 * 
	 * @NotEmpty
	 * 
	 * @JsonFormat(pattern = "yyyy-MM-dd") private LocalDate enddate;
	 * 
	 * @Column(name = "leave_type")
	 * 
	 * @NotEmpty private String leavetype;
	 * 
	 * @NotNull
	 * 
	 * @Column(name = "status") private String status;
	 */


}
