package com.bookstore.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dto.Bookdto;
import com.bookstore.dto.Customerdto;
import com.bookstore.entity.Book_entity;
import com.bookstore.entity.Customer_entity;
@Service
public class Dtoservice {
	@Autowired
	private BookRepository repository;
	@Autowired
	private ModelMapper modelMapper;
	
	//Dto to entity
	
	public Book_entity Convert_to_bookEntity(Bookdto bookdto) {
		Book_entity book=this.modelMapper.map(bookdto,Book_entity.class);
		return book;
	}
	public Customer_entity Convert_to_CustomerEntity(Customerdto customerdto) {
		Customer_entity customer=this.modelMapper.map(customerdto,Customer_entity.class);
		return customer;
	}
	
	//entity to DTO
	
	public Bookdto Convert_to_bookDto(Book_entity bookEntity) {
		Bookdto book=this.modelMapper.map(bookEntity,Bookdto.class);
		return book;
	}
	public Customerdto Convert_to_CustomerDto(Customer_entity customerEntity) {
		Customerdto customer=this.modelMapper.map(customerEntity,Customerdto.class);
		return customer;
	}
	
	

}
