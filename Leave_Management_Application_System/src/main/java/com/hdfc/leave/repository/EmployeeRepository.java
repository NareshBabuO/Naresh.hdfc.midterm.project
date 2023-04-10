package com.hdfc.leave.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.leave.entity.Employees;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

	List<Employees> findByName(String name);

}