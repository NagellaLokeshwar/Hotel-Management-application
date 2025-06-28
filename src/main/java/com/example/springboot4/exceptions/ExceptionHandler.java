package com.example.springboot4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springboot4.exceptions.payload.ApiResponse;

@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
		ApiResponse res=new ApiResponse(ex.getMessage(),false,HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(res, HttpStatus.NOT_FOUND);
		
	}

}
