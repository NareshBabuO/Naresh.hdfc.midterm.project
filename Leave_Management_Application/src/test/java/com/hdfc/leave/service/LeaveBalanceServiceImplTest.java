package com.hdfc.leave.service;
/**
 *@author NareshBabu O
 *@created 15-April-2023
*
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;

@SpringBootTest
class LeaveBalanceServiceImplTest {

	@Autowired
	LeaveBalanceService leaveBalanceService;

	@Test
	void testGetBalanceByEmpId() throws LeaveBalanceNotFoundException {
		Integer allLeaveByEmpID = leaveBalanceService.getAllLeaveByEmpID(102);
		assertNotNull(allLeaveByEmpID);
	}

	@Test
	void testGetLeaveByEmpAndLeaveType() {
		LeaveBalance leaveByEmpAndLeaveType = leaveBalanceService.getLeaveByEmpAndLeaveType(101,
				LeaveType.MATERNITYLEAVE);
		assertNotNull(leaveByEmpAndLeaveType);
	}

}
