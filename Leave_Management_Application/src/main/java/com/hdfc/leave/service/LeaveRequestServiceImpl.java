package com.hdfc.leave.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.enums.StatusType;
import com.hdfc.leave.enums.insertType;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;
import com.hdfc.leave.exception.LeaveRequestNotFoundException;
import com.hdfc.leave.repository.EmployeeRepository;
import com.hdfc.leave.repository.LeaveRequestRepo;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	LeaveRequestRepo leaveRequestRepo;

	@Autowired
	LeaveBalanceService leaveBalanceService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public LeaveRequests requestLeave(long employeeId, String startDate, String endDate, LeaveType leaveType,
			String reason) throws EmployeeNotFoundException {

		LeaveRequests leave_Requests = new LeaveRequests();

		Employees employees = new Employees();
		employees.setEmployee_id(employeeId);

		leave_Requests.setEmployee(employees);
		leave_Requests.setStartDate(LocalDate.parse(startDate));
		leave_Requests.setEndDate(LocalDate.parse(endDate));
		leave_Requests.setLeaveType(leaveType);
		leave_Requests.setReason(reason);
		leave_Requests.setStatus(StatusType.PENDING);
		leave_Requests.setComment("Empty");

		return leaveRequestRepo.save(leave_Requests);

	}
	/*
	 * public LeaveRequests requestLeave(long employeeId, String startDate, String
	 * endDate, LeaveType leaveType, String reason) throws EmployeeNotFoundException
	 * { Employees employee = employeeRepository.findById(employeeId)
	 * .orElseThrow(() -> new
	 * EmployeeNotFoundException("Employee not found with ID: " + employeeId));
	 * 
	 * LeaveRequests leaveRequest = new LeaveRequests();
	 * leaveRequest.setEmployee(employee);
	 * leaveRequest.setStartDate(LocalDate.parse(startDate));
	 * leaveRequest.setEndDate(LocalDate.parse(endDate));
	 * leaveRequest.setLeaveType(leaveType); leaveRequest.setReason(reason);
	 * 
	 * return leaveRequestRepository.save(leaveRequest); } }
	 */

	/*
	 * @Override public LeaveRequests requestLeave(long employeeId, String
	 * startDate, String endDate, LeaveType leaveType, String reason) throws
	 * EmployeeNotFoundException { Employee employee =
	 * employeeRepository.findById(employeeId) .orElseThrow(() -> new
	 * EmployeeNotFoundException("Employee not found with ID: " + employeeId));
	 * 
	 * LeaveRequests leaveRequest = new LeaveRequests();
	 * leaveRequest.setEmployee(employee);
	 * leaveRequest.setStartDate(LocalDate.parse(startDate));
	 * leaveRequest.setEndDate(LocalDate.parse(endDate));
	 * leaveRequest.setLeaveType(leaveType); leaveRequest.setReason(reason);
	 * leaveRequest.setStatus(RequestStatus.PENDING);
	 * 
	 * return leaveRequestRepository.save(leaveRequest); }
	 */

	@Override
	public LeaveRequests updateRequest(long leaveRequestId, long employeeId, String startDate, String endDate,
			LeaveType leaveType, String reason) throws EmployeeNotFoundException, LeaveRequestNotFoundException {
		LeaveRequests leave_Requests = new LeaveRequests();

		Employees employees = new Employees();
		employees.setEmployee_id(employeeId);

		/*
		 * Employees employee = employeeRepository.findById(employeeId) .orElseThrow(()
		 * -> new EmployeeNotFoundException("Employee not found with ID: " +
		 * employeeId));
		 */

		LeaveRequests leaveRequest = leaveRequestRepo.findById(leaveRequestId).orElseThrow(
				() -> new LeaveRequestNotFoundException("Leave request not found with ID: " + leaveRequestId));

		leave_Requests.setLeaveRequestId(leaveRequestId);
		leave_Requests.setEmployee(employees);
		leave_Requests.setStartDate(LocalDate.parse(startDate));
		leave_Requests.setEndDate(LocalDate.parse(endDate));
		leave_Requests.setLeaveType(leaveType);
		leave_Requests.setReason(reason);
		leave_Requests.setStatus(StatusType.PENDING);
		leave_Requests.setComment("Empty");

		return leaveRequestRepo.save(leave_Requests);
	}

	/*
	 * public LeaveRequests updateRequest(long leaveRequestId, long employeeId,
	 * String startDate, String endDate, // LeaveType leaveType, String reason)
	 * throws EmployeeNotFoundException, LeaveRequestNotFoundException { Employee
	 * employee = employeeRepository.findById(employeeId) .orElseThrow(() -> new
	 * EmployeeNotFoundException("Employee not found with ID: " + employeeId));
	 * 
	 * LeaveRequests leaveRequest = leaveRequestRepository.findById(leaveRequestId)
	 * .orElseThrow(() -> new
	 * LeaveRequestNotFoundException("Leave request not found with ID: " +
	 * leaveRequestId));
	 * 
	 * leaveRequest.setEmployee(employee);
	 * leaveRequest.setStartDate(LocalDate.parse(startDate));
	 * leaveRequest.setEndDate(LocalDate.parse(endDate));
	 * leaveRequest.setLeaveType(leaveType); leaveRequest.setReason(reason);
	 * 
	 * return leaveRequestRepository.save(leaveRequest); }
	 */
	/*
	 * @Override
	 * 
	 * @Transactional public List<LeaveRequests> getRequestByEmpId(long employeeId)
	 * throws LeaveRequestNotFoundException {
	 * 
	 * if (!LeaveRequestRepo.existsById(employeeId)) { throw new
	 * LeaveRequestNotFoundException("Leave Request not Found with :" + employeeId);
	 * }
	 * 
	 * return LeaveRequestRepo.findByEmployeeId(employeeId); }
	 */

	@Override
	@Transactional
	public List<LeaveRequests> getRequestByEmpId(long employeeId) throws LeaveRequestNotFoundException {
		// employeeRepository.findById(employeeId)
		// .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID:
		// " + employeeId));

		List<LeaveRequests> leaveRequests = leaveRequestRepo.findByEmployeeId(employeeId);
		if (leaveRequests.isEmpty()) {
			throw new LeaveRequestNotFoundException("No leave requests found for employee with ID: " + employeeId);
		}

		return leaveRequests;
	}

	/*
	 * public LeaveRequests getRequestById(long leaveRequestId) throws
	 * LeaveRequestNotFoundException { if
	 * (!leaveRequestRepo.existsById(leaveRequestId)) { throw new
	 * LeaveRequestNotFoundException("Leave Request not Found with :" +
	 * leaveRequestId); } return
	 * leaveRequestRepo.findById(leaveRequestId).orElse(null); }
	 */

	/*
	 * @Override public void deleteRequestById(long leaveRequestId) throws
	 * LeaveRequestNotFoundException { if
	 * (!leaveRequestRepo.existsById(leaveRequestId)) { throw new
	 * LeaveRequestNotFoundException("Leave request not found with ID: " +
	 * leaveRequestId); } leaveRequestRepo.deleteById(leaveRequestId); }
	 */

	@Override
	public void deleteRequestById(long leaveRequestId) {
		leaveRequestRepo.deleteById(leaveRequestId);
	}

	// leave_Requests.setLeaveRequestId(lRequestDTO.getLeaveRequestId());

	@Override
	public List<LeaveRequests> getAllRequest() {
		return leaveRequestRepo.findAll();
	}

	@Override
	// @Transactional
	public LeaveRequests responseForRequest(long leaveRequestId, StatusType status, String comment)
			throws LeaveRequestNotFoundException, LeaveBalanceNotFoundException {
		LeaveRequests leaveRequests = getRequestById(leaveRequestId);
		leaveRequests.setStatus(status);
		leaveRequests.setComment(comment);

		LeaveRequests updateLR = leaveRequestRepo.save(leaveRequests);

		int duration = updateLR.getEndDate().getDayOfYear() - updateLR.getStartDate().getDayOfYear();
		insertType.info("Total Days of Leave" + duration);

		if (updateLR.getStatus().equals(StatusType.APROVEED)) {
			LeaveBalance leavebalance = leaveBalanceService
					.getLeaveByEmpAndLeaveType(updateLR.getEmployee().getEmployee_id(), updateLR.getLeaveType());

			int balance = leavebalance.getBalance() - duration;

			LeaveBalance updateLeaveBalance = leaveBalanceService.updateLeaveBalance(leavebalance.getLeaveBalanceId(),
					balance);
			insertType.info(updateLeaveBalance);

		}

		return updateLR;

	}

	@Override
	public LeaveRequests getRequestById(long leaveRequestId) throws LeaveRequestNotFoundException {

		return leaveRequestRepo.findById(leaveRequestId).orElseThrow(
				() -> new LeaveRequestNotFoundException("Leave request not found with ID: " + leaveRequestId));

		/*
		 * Optional<LeaveRequests> findById = leaveRequestRepo.findById(leaveRequestId);
		 * if(findById.isEmpty()) { throw new
		 * LeaveRequestNotFoundException("No leave requests found for employee with ID: "
		 * + leaveRequestId); }
		 */

	}

}
