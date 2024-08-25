package com.bookstore.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dto.Bookdto;
import com.bookstore.entity.Book_entity;
import com.bookstore.service.BookService;
import com.bookstore.service.Dtoservice;
 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Book_entity>getallbooks(){
		return bookService.getbooks();
	}
	@GetMapping("/search")
	public ResponseEntity<List<Book_entity>> getBooksByTitleAndAuthor(
	        @RequestParam(required = false) String title,
	        @RequestParam(required = false) String author) {
	    List<Book_entity> books = bookService.getBooksByTitleAndAuthor(title, author);
	    HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "BookRetrieved");
	    return new ResponseEntity<>(books,headers,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book_entity> getbooks_byID(@PathVariable int id){
		Book_entity book= bookService.getbooks_byID(id);
		book.add(linkTo(methodOn(BookController.class).getbooks_byID(book.getBookId())).withSelfRel());
		book.add(linkTo(methodOn(BookController.class).getallbooks()).withRel("Collection"));
		return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
	}
	@PostMapping("/add_book")
	public ResponseEntity<Book_entity>add_books(@RequestBody Book_entity book){
		
		/*Scanner sc = new Scanner(System.in);
		System.out.print("enter author name: ");
		String author=sc.next();
		book.setAuthor(author);
		
		System.out.print("enter price: ");
		int price=sc.nextInt();
		book.setPrice(price);
		
		System.out.print("enter book title: ");
		String title=sc.next();
		book.setTitle(title);*/
		Book_entity book1=bookService.add_books(book);
	//	sc.close();
		 HttpHeaders headers = new HttpHeaders();
	        headers.add("X-Custom-Header", "BookCreatedSuccessfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(book1);
	}
	 @PutMapping("/update/{id}")
	    public ResponseEntity<Book_entity> updateBook(@PathVariable int id , @RequestBody Book_entity updated_book) {
	        Book_entity updatedBook = bookService.update(id,updated_book);
	       // return ResponseEntity.ok(updatedBook);
	        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
	    }
    @DeleteMapping("/{id}")
    	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        	boolean isDeleted=bookService.delete(id);
        	return isDeleted ? ResponseEntity.noContent().build():ResponseEntity.notFound().build();
			
    	}
}
