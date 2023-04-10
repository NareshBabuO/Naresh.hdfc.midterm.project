package com.hdfc.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.leave.entity.LeaveBalance;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer>{

}
