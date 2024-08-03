package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayService() {
        System.out.println("BookService is working...");
        System.out.println("Repository class is injected in bookservice class\ndisplayRepository() is called from bookservice class");
        bookRepository.displayRepository();
    }
}
