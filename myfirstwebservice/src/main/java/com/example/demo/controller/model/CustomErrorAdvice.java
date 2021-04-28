package com.example.demo.controller.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.exception.CustomException;

@ControllerAdvice
public class CustomErrorAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CustomError> handleException(CustomException ex) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		System.out.println("ERROR MESSAGE -> " + ex.getMessage());
		
		if(MessageType.RECORD_NOT_FOUND.getCode().equals(ex.getMessage())) {
			System.out.println("I have caught that exception.....");
			status = HttpStatus.NOT_FOUND;
		}
		
		CustomError error = new CustomError(ex.getMessage(), status);
		return new ResponseEntity<CustomError>(error ,status);	
	}
}