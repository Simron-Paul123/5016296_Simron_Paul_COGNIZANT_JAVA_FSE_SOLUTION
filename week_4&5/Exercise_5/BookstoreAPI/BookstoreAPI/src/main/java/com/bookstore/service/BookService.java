package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.bookstore.entity.Book_entity;
@Service
public class BookService  {
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		//super();
		this.bookRepository = bookRepository;
	}
	public List<Book_entity>getbooks(){
		return bookRepository.findAll();
	}
	public Book_entity getbooks_byID(int id){
		Book_entity book= bookRepository.findById(id).get();
		return book;
	}
	
	public List<Book_entity> getBooksByTitleAndAuthor(String title, String author) {
	    // Retrieve the list of books from the repository
	    List<Book_entity> allBooks = bookRepository.findAll();
	    List<Book_entity> filteredBooks = new ArrayList<>();

	    // Filter books based on title and author
	    for (Book_entity book : allBooks) {
	        boolean titleMatches = (title == null || book.getTitle().equalsIgnoreCase(title));
	        boolean authorMatches = (author == null || book.getAuthor().equalsIgnoreCase(author));

	        if (titleMatches && authorMatches) {
	            filteredBooks.add(book);
	        }
	    }

	    return filteredBooks;
	}

	
	public Book_entity add_books(Book_entity book) {
		
		
		Book_entity book1=bookRepository.save(book);
		
		//sc.close();
		return book1;
		
	}
	public Book_entity update(int id) {
		Book_entity book = bookRepository.findById(id).get();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter author name: ");
		String author=sc.next();
		book.setAuthor(author);
		
		System.out.print("enter price: ");
		int price=sc.nextInt();
		book.setPrice(price);
		
		System.out.print("enter book title: ");
		String title=sc.next();
		book.setTitle(title);
		
		bookRepository.save(book);
		sc.close();
		return book;
	}
	public boolean delete(int id) {
	    Optional<Book_entity> book = bookRepository.findById(id);
	    
	    if (book.isPresent()) {
	        bookRepository.delete(book.get());
	        System.out.println("Book deleted successfully");
	        return true;
	    } else {
	        System.out.println("Book not found");
	        return false;
	    }
	}

}