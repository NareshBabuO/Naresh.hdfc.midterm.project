package com.hdfc.leave.exception;
/**
 *@author NareshBabu O
 *@created 14-April-2023
*
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalExceptionHandler {

	@ExceptionHandler(value = { LeaveBalanceNotFoundException.class, LeaveRequestNotFoundException.class,
			EmployeeNotFoundException.class })
	public ResponseEntity<String> handleNotFoundException(Exception ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

}
