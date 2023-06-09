package com.hdfc.leave.repository;
/**
 *@author NareshBabu O
 *@created 11-April-2023
*
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;

@Repository
@EnableJpaRepositories
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {

	LeaveBalance save(LeaveBalanceDTO leaveBalanceId);
	
	@Query("select sum(bal.balance)from LeaveBalance bal where bal.employee.employee_id=:employee_id")
	public Integer getAllLeaveByEmpID(@Param("employee_id") long employee_id);

	@Query("select bal from LeaveBalance bal where bal.employee.employee_id=:employee_id")
	public List<LeaveBalance> findByEmployeeId(@Param("employee_id") long employee_id);

	@Query("select bal from LeaveBalance bal where bal.employee.employee_id=:employee_id and bal.leaveType=:leaveType")
	public LeaveBalance getLeaveByEmpAndLeaveType(@Param("employee_id") long employee_id,
			@Param("leaveType") LeaveType leaveType);

	
	

}
