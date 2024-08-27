package com.bookstore;

import com.bookstore.entity.Book_entity;
import com.bookstore.service.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Book_entity book;

    @BeforeEach
    void setUp() {
        // Clear the repository before each test to ensure clean state
        bookRepository.deleteAll();

        // Initialize a sample book
        book = new Book_entity();
        book.setTitle("Integration Test Book");
        book.setAuthor("Integration Test Author");
    }

    @Test
    void testGetAllBooks() throws Exception {
        // Save a book to the repository
    	Book_entity savedBook = bookRepository.save(book);

        // Perform GET request to retrieve all books
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedBook.getBookId()))
                .andExpect(jsonPath("$[0].title").value(savedBook.getTitle()))
                .andExpect(jsonPath("$[0].author").value(savedBook.getAuthor()));
    }

    @Test
    void testGetBookById() throws Exception {
        // Save a book to the repository
    	Book_entity savedBook = bookRepository.save(book);

        // Perform GET request to retrieve the book by its ID
        mockMvc.perform(get("/books/{id}", savedBook.getBookId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(savedBook.getBookId()))
                .andExpect(jsonPath("$.title").value(savedBook.getTitle()))
                .andExpect(jsonPath("$.author").value(savedBook.getAuthor()));
    }

    @Test
    void testAddBook() throws Exception {
        // Perform POST request to add a new book
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value(book.getTitle()))
                .andExpect(jsonPath("$.author").value(book.getAuthor()));

        // Verify the book is added to the repository
        assertThat(bookRepository.findAll()).hasSize(1);
    }

    @Test
    void testDeleteBook() throws Exception {
        // Save a book to the repository
    	Book_entity savedBook = bookRepository.save(book);

        // Perform DELETE request to remove the book by its ID
        mockMvc.perform(delete("/books/{id}", savedBook.getBookId()))
                .andExpect(status().isNoContent());

        // Verify the book is removed from the repository
        Optional<Book_entity> deletedBook = bookRepository.findById(savedBook.getBookId());
        assertThat(deletedBook).isEmpty();
    }
}
