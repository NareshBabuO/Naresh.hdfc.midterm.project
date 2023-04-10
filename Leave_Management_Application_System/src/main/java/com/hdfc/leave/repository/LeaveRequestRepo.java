package com.hdfc.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.LeaveRequests;

@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequests,Long> {

	public LeaveRequests save(LeaveRequestDTO lRequestDTO);
	


}
