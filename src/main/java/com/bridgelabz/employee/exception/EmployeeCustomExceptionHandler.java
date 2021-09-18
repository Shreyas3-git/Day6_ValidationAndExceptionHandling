package com.bridgelabz.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employee.dto.ResponseDTO;

public class EmployeeCustomExceptionHandler 
{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> globalException(Exception exception)
	{
		return new ResponseEntity<> (new ResponseDTO(exception.getMessage(),
				HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseDTO> customException(Exception exception)
	{
		return new ResponseEntity<> (new ResponseDTO(exception.getMessage(),
				HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
	}
}
