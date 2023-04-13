package com.hdfc.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hdfc.leave.DTO.LeaveRequestDTO;
import com.hdfc.leave.entity.LeaveRequests;

@EnableJpaRepositories
@Repository
@Transactional
public interface LeaveRequestRepo extends JpaRepository<LeaveRequests,Long> {

	public LeaveRequests save(LeaveRequestDTO lRequestDTO);

	public LeaveRequests save(long leaveRequestId, String status, String comment);
	


}
