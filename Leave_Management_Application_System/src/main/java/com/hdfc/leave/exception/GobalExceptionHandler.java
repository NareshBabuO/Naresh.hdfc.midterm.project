package com.hdfc.leave.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleBookNotFoundException(Exception e) {
		return new ResponseEntity<String>(e + " Enter Valid Input", HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<String> handelExcption(Exception e) {
		int value = HttpStatus.INTERNAL_SERVER_ERROR.value();
		return new ResponseEntity<String>(e.toString() + " " + value + " ", HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
