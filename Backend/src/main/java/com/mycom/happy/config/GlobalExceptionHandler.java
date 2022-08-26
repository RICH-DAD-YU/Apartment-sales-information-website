package com.mycom.happy.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.happy.dto.BoardResultDto;

//@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleErrorResponseEntity(Exception e) {
		System.out.println("Exception >>>>>>>>>>> ");
		e.printStackTrace();
		return new ResponseEntity<String>("ajax_global_exception", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}