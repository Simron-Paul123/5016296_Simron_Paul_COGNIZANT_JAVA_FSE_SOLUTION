package com.bookstore.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.entity.Book_entity;

public interface BookRepository extends JpaRepository<Book_entity,Integer> {
	
}
