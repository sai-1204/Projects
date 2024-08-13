package com.virtusa.obtbs.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.virtusa.obtbs.pojo.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NoElementException.class)
	public @ResponseBody ErrorInfo getexception(NoElementException e,HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	
	
	
}
