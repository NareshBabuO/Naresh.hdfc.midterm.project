package com.hdfc.leave.repository;
/**
 *@author NareshBabu O
 *@created 9-April-2023
*
 */
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.leave.entity.Employees;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employees, Long> {

	public List<Employees> findByName(String name);

	public List<Employees> findById(long employee_id);

}
