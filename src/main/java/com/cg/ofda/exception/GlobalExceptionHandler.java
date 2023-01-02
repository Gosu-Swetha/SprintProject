package com.cg.ofda.exception;

import java.time.LocalDateTime;



import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorInfo LoginException(UserNotFoundException e,HttpServletRequest req) {
	  
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	@ExceptionHandler(CustomerException.class)
	public ErrorInfo CustomerException(CustomerException e,HttpServletRequest req) {
	  
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	@ExceptionHandler(CategoryException.class)
	public  ErrorInfo CategoryException(CategoryException e,HttpServletRequest req) {
	  
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	 @ExceptionHandler(OrderDetailsException.class)
     public ErrorInfo OrdertException(OrderDetailsException e,HttpServletRequest req) {

         String msg=e.getMessage();
         String uri= req.getRequestURI();
         return new ErrorInfo(msg,uri,LocalDateTime.now());
	 }
      @ExceptionHandler(RestaurantException.class)
      public ErrorInfo RestaurantException(RestaurantException e,HttpServletRequest req) {

             String msg=e.getMessage();
             String uri= req.getRequestURI();
             return new ErrorInfo(msg,uri,LocalDateTime.now());
         
      }
      @ExceptionHandler(CartException.class)
      public ErrorInfo CartException(CartException e,HttpServletRequest req) {

             String msg=e.getMessage();
             String uri= req.getRequestURI();
             return new ErrorInfo(msg,uri,LocalDateTime.now());
      }
      
      @ExceptionHandler(BillException.class)
      public ErrorInfo BillException(BillException e,HttpServletRequest req) {

             String msg=e.getMessage();
             String uri= req.getRequestURI();
             return new ErrorInfo(msg,uri,LocalDateTime.now());
      }
      
      @ExceptionHandler(ItemException.class)
      public  ErrorInfo ItemException(ItemException e,HttpServletRequest req) {

             String msg=e.getMessage();
             String uri= req.getRequestURI();
             return new ErrorInfo(msg,uri,LocalDateTime.now());
      }
}

