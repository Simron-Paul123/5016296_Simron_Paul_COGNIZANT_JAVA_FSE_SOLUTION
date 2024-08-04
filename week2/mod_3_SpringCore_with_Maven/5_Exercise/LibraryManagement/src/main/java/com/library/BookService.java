package com.library;

public class BookService {
	private BookRepository b;
	public void setBookRepository(BookRepository b) {
		this.b=b;
	}
	public void display() {
		b.display();
		System.out.println("this method is calling inside BookService Class");
	}
}
