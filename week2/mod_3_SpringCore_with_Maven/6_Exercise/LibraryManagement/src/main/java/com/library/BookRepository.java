package com.library;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class BookRepository {
	public void display() {
		System.out.println("BookRepository is working...");
	}
}
