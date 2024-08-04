package com.library;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	private BookRepository bookRepository;
	
	public BookService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
		System.out.println("object is created through constructor injection");
	}
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
		System.out.println("object is created through setter injection");
	}
	public void display() {
		bookRepository.display();
		System.out.println("this method is calling inside BookService Class");
	}
}
