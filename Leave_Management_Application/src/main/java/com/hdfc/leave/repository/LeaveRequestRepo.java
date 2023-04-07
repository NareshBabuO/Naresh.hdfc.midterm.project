package com.hdfc.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.leave.entity.Leave_Requests;

@Repository
public interface LeaveRequestRepo extends JpaRepository<Leave_Requests,Long> {

}
