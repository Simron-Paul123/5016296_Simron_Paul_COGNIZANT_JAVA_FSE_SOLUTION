package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book_entity;
import com.bookstore.exception.Notfound_Exception;

import io.micrometer.core.instrument.MeterRegistry;
@Service
public class BookService  {
	private BookRepository bookRepository;
	private final MeterRegistry meterRegistry;
	public BookService(BookRepository bookRepository, MeterRegistry meterRegistry) {
		//super();
		this.bookRepository = bookRepository;
		this.meterRegistry=meterRegistry;
	}
	public List<Book_entity>getbooks(){
		meterRegistry.counter("books.fetch.count").increment();
		return bookRepository.findAll();
		
	}
	public Book_entity getbooks_byID(int id){
		Optional<Book_entity> book= bookRepository.findById(id);
		if(book.isPresent())
			return book.get();
		else
			throw new Notfound_Exception("No such data present");
	}
		public List<Book_entity> getBooksByTitleAndAuthor(String title, String author) {
		List<Book_entity> allBooks = bookRepository.findAll();

	    // Retrieve the list of books from the repository
	   
	    List<Book_entity> filteredBooks = new ArrayList<>();

	    // Filter books based on title and author
	    for (Book_entity book : allBooks) {
	        boolean titleMatches = (title == null || book.getTitle().equalsIgnoreCase(title));
	        boolean authorMatches = (author == null || book.getAuthor().equalsIgnoreCase(author));

	        if (titleMatches && authorMatches) {
	            filteredBooks.add(book);
	        }
	        else
	        	throw new Notfound_Exception("data not found");
	    }

	    return filteredBooks;
	}

	
	public Book_entity add_books(Book_entity book) {
		
		
		 try {
	            return bookRepository.save(book);
	        } catch (OptimisticLockingFailureException e) {
	            // Handle the exception, possibly reload the entity and retry the operation
	            throw new RuntimeException("Concurrent update conflict occurred", e);
	        }
		
	}
	public Book_entity update(int id,Book_entity updated_book) {
		Optional<Book_entity> book = bookRepository.findById(id);
		if(book.isPresent()) {
			Book_entity newBook=book.get();
			newBook.setAuthor(updated_book.getAuthor());
			
			newBook.setPrice(updated_book.getPrice());
			
			
			newBook.setTitle(updated_book.getTitle());
			bookRepository.save(newBook);
			return newBook;
		}
		else
			throw new Notfound_Exception("data not found");
		
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
