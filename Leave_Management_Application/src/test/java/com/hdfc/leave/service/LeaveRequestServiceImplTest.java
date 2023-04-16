package com.hdfc.leave.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.leave.entity.LeaveRequests;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.exception.LeaveRequestNotFoundException;

@SpringBootTest
class LeaveRequestServiceImplTest {

	@Autowired
	LeaveRequestService leaveRequestService;

	@Test
	void testRequestLeave() throws EmployeeNotFoundException {

//(long employeeId, String startDate, String endDate, LeaveType leaveType, String reason) 
		LeaveRequests requestLeave = leaveRequestService.requestLeave(1002, "2023-04-17", "2023-04-17",
				LeaveType.MATERNITYLEAVE, "6 Month Pregnecy");

		assertNotNull(requestLeave);
	}

	@Test
	void testGetRequestByEmpId() throws LeaveRequestNotFoundException {

		List<LeaveRequests> requestByEmpId = leaveRequestService.getRequestByEmpId(101);
		assertNotNull(requestByEmpId);
	}

	@Test
	void testGetRequestById() throws LeaveRequestNotFoundException {

		LeaveRequests requestById = leaveRequestService.getRequestById(26);

		assertNotNull(requestById);
	}

}
