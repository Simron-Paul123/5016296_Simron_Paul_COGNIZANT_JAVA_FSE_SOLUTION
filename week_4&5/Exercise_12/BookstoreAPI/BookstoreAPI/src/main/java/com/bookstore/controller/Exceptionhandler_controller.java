package com.bookstore.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.exception.Api_error;
import com.bookstore.exception.Notfound_Exception;

@RestController
@ControllerAdvice
public class Exceptionhandler_controller {
	@ExceptionHandler(value=Notfound_Exception.class)
	public ResponseEntity<Api_error> handleNotFound_Exception(){
		Api_error error=new Api_error(404,"Data Not Found",new Date());
		return new ResponseEntity<Api_error>(error,HttpStatus.BAD_REQUEST);
	}
}
