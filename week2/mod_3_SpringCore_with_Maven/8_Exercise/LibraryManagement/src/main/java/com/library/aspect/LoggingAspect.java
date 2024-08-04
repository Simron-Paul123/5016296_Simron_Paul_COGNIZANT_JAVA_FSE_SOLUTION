package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	@Before("execution(* com.library.BookService.*(..))")
	public void print_before() {
		System.out.println("the method is started");
	}
	@After("execution(* com.library.BookService.*(..))")
	public void print_after() {
		System.out.println("method executed successfully");
	}
	
}
