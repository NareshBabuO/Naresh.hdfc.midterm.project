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
import org.springframework.transaction.annotation.Transactional;

import com.hdfc.leave.entity.LeaveRequests;

@EnableJpaRepositories
@Repository
@Transactional
public interface LeaveRequestRepo extends JpaRepository<LeaveRequests,Long> {


	
	@Query("select req from LeaveRequests req where req.employee.employee_id=:employee_id")
	public List<LeaveRequests> findByEmployeeId(@Param("employee_id") long employee_id);

}
