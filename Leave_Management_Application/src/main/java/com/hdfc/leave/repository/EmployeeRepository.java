package com.hdfc.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.leave.entity.Employees;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

	//List<Employees> findByEmployeeName(String name);
	
	

}
