package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book_entity;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping
	public List<Book_entity>getallbooks(){
		return bookService.getbooks();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Book_entity> getbooks_byID(@PathVariable int id){
		Book_entity book= bookService.getbooks_byID(id);
		return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
	}
	@PostMapping
	public ResponseEntity<Book_entity>add_books(){
		Book_entity book=bookService.add_books();
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}
	 @PutMapping("/{id}")
	    public ResponseEntity<Book_entity> updateBook(@PathVariable int id) {
	        Book_entity updatedBook = bookService.update(id);
	        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
	    }
    @DeleteMapping("/{id}")
    	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        	boolean isDeleted=bookService.delete(id);
        	return isDeleted ? ResponseEntity.noContent().build():ResponseEntity.notFound().build();
			
    	}
}
