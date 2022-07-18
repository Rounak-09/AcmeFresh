package com.acmefresh.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;





@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(UserException ie,WebRequest wr)  {
		System.out.println("UserException");
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(AdminException ie,WebRequest wr)  {
		System.out.println("AdminException");
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
	
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myExpHandlerMain(Exception ie,WebRequest wr)  {
		System.out.println("Exception");
		

		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
				
	
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);	
				
	}
}
