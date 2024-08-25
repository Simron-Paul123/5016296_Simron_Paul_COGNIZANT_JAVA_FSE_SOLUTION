package com.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bookdto {
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
	@Override
	public String toString() {
		return "Bookdto [bookId=" + bookId + ", title=" + title + ", price=" + price + ", author=" + author + ", isbn="
				+ isbn + "]";
	}
	
}
