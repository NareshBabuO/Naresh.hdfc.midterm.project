package com.hdfc.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;

@Repository
@EnableJpaRepositories
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {

	LeaveBalance save(LeaveBalanceDTO leaveBalanceId);

	@Query("select bal from LeaveBalance bal where bal.employee.employee_id=:employee_id")
	public List<LeaveBalance> findById(@Param("employee_id") long employee_id);

}
