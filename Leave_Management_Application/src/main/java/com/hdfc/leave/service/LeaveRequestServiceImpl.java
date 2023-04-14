package com.hdfc.leave.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.repository.LeaveRequestRepo;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	LeaveRequestRepo repo;

	/*
	 * @Override public LeaveRequests requestLeaves(LeaveRequestDTO lRequestDTO) {
	 * 
	 * LeaveRequests leave_Requests = new LeaveRequests();
	 * 
	 * Employees employees = new Employees();
	 * employees.setEmployee_id(lRequestDTO.getEmployee().getEmployee_id());
	 * 
	 * leave_Requests.setLeaveRequestId(lRequestDTO.getLeaveRequestId());
	 * leave_Requests.setEmployee(employees);
	 * leave_Requests.setStartDate(lRequestDTO.getStartDate());
	 * leave_Requests.setEndDate(lRequestDTO.getEndDate());
	 * leave_Requests.setLeaveType(lRequestDTO.getLeaveType());
	 * leave_Requests.setReason(lRequestDTO.getReason());
	 * leave_Requests.setStatus("Pending"); leave_Requests.setComment("Empty");
	 * 
	 * return repo.save(leave_Requests); }
	 */

	@Override
	public LeaveRequests requestLeave(long employeeId, String startDate, String endDate, LeaveType leaveType,
			String reason) {
		LeaveRequests leave_Requests = new LeaveRequests();
		// LeaveRequests leaveRequests1 = (LeaveRequests) getRequestByEmpId(employeeId);

		Employees employees = new Employees();
		employees.setEmployee_id(employeeId);

		// String dateString = "2023-04-14";
		// LocalDate localDate = LocalDate.parse();

		leave_Requests.setEmployee(employees);
		leave_Requests.setStartDate(LocalDate.parse(startDate));
		leave_Requests.setEndDate(LocalDate.parse(startDate));
		leave_Requests.setLeaveType(leaveType);
		leave_Requests.setReason(reason);
		leave_Requests.setStatus("Pending");
		leave_Requests.setComment("Empty");
		return repo.save(leave_Requests);

	}

	@Override
	@Transactional
	public List<LeaveRequests> getRequestByEmpId(long employeeId) {
		return repo.findByEmployeeId(employeeId);
	}

	@Override
	public LeaveRequests getRequestById(long leaveRequestId) {
		return repo.findById(leaveRequestId).orElse(null);
	}

	@Override
	public void deleteRequestById(long leaveRequestId) {
		repo.deleteById(leaveRequestId);
	}

	@Override
	public LeaveRequests updateRequest(LeaveRequestDTO lRequestDTO) {

		LeaveRequests leave_Requests = new LeaveRequests();

		Employees employees = new Employees();
		employees.setEmployee_id(lRequestDTO.getEmployee().getEmployee_id());

		leave_Requests.setLeaveRequestId(lRequestDTO.getLeaveRequestId());
		leave_Requests.setEmployee(employees);
		leave_Requests.setStartDate(lRequestDTO.getStartDate());
		leave_Requests.setEndDate(lRequestDTO.getEndDate());
		leave_Requests.setLeaveType(lRequestDTO.getLeaveType());
		leave_Requests.setReason(lRequestDTO.getReason());
		leave_Requests.setStatus("Pending");
		leave_Requests.setComment("Empty");

		return repo.save(leave_Requests);
	}

	@Override
	public List<LeaveRequests> getAllRequest() {
		return repo.findAll();
	}

	@Override
	public LeaveRequests responseForRequest(long leaveRequestId, String status, String comment) {
		LeaveRequests leaveRequests = getRequestById(leaveRequestId);
		leaveRequests.setStatus(status);
		leaveRequests.setComment(comment);

		return repo.save(leaveRequests);

	}

}
