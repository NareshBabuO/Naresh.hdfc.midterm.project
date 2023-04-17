package com.hdfc.leave.DTO;
/**
 *@author NareshBabu O
 *@created 9-April-2023
*
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
public class EmployeesDTO {

	private long employee_id;
	private String name;
	private String email;
	private String phone_number;
	private String department;
}
