package com.library.controller;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
public Book getBookById(@PathVariable Long id) {
    return bookRepository.findById(id).orElse(null);
}

@PostMapping
public Book createBook(@RequestBody Book book) {
    return bookRepository.save(book);
}

@PutMapping("/{id}")
public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
    return bookRepository.findById(id).map(book -> {
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
        return bookRepository.save(book);
    }).orElse(null);
}

@DeleteMapping("/{id}")
	    public void deleteBook(@PathVariable Long id) {
	        bookRepository.deleteById(id);
	    }
}
