package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class BookService {
	@Autowired
	private BookRepository b;
	public void setBookRepository(BookRepository b) {
		this.b=b;
	}
	public void display() {
		b.display();
		System.out.println("this method is calling inside BookService Class");
	}
}
