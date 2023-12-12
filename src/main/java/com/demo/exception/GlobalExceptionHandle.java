package com.demo.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.payload.ApiResponse;


@ControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public  ResponseEntity<Object> handleResourceNotFoundException( ResourceNotFoundException ex,WebRequest req){
		ApiResponse apiError = new ApiResponse(ex.getMessage());
		return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
	
	
	
}
