package com.library;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	public void display() {
		System.out.println("BookRepository is working...");
	}
}
