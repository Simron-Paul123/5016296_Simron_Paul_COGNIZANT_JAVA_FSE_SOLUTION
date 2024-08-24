package com.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class Book_entity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int bookId;
	@JsonProperty("book_title")
	private String title;
	
	private int price;
	 @JsonProperty("book_author")
	private String author;
	private String isbn;
	
	
	public Book_entity() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Book_entity(String title, int price, String author, String isbn) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.isbn = isbn;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	@Override
	public String toString() {
		return "Book_entity [bookId=" + bookId + ", title=" + title + ", price=" + price + ", author=" + author
				+ ", isbn=" + isbn + "]";
	}
	
}
