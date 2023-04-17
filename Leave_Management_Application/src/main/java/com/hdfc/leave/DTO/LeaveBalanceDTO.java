package com.hdfc.leave.DTO;
/**
 *@author NareshBabu O
 *@created 11-April-2023
*
 */
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.enums.LeaveType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LeaveBalanceDTO {

	private long leaveBalanceId;
	private Employees employee;
	private LeaveType leaveType;
	private int balance;
	
	
	public static  int CASUALLEAVE;
	public static int SICKLEAVE ;
	public static int MATERNITYLEAVE;
	public static int PATERNITYLEAVE ;
	public static int PRIVILEGELEAVE;
		
	

}
