package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Customer_entity;
import com.bookstore.exception.Notfound_Exception;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	public CustomerService(CustomerRepository repository) {
		//super();
		this.repository = repository;
	}
	public List<Customer_entity> get_allCustomers(){
		return repository.findAll();
	}
	public Customer_entity get_customerByID(int id) {
		Optional<Customer_entity> optional=repository.findById(id);
		if(optional.isPresent()) {
			Customer_entity customer=optional.get();
			return customer;
		}
		else
			throw new Notfound_Exception("data not found");
	}
	public Customer_entity add_customer(Customer_entity customer) {
		return repository.save(customer);
	}
	
	public Customer_entity update_customer(int id , Customer_entity customer) {
		Customer_entity existing_customer=get_customerByID(id);
		if(existing_customer !=null) {
			existing_customer.setFirst_name(customer.getFirst_name());
			existing_customer.setLast_name(customer.getLast_name());
			existing_customer.setEmail(customer.getEmail());
			existing_customer.setPassword(customer.getPassword());
			return repository.save(existing_customer);
		}
		else
			throw new Notfound_Exception("data not found");
	}
	public void delete_customer(int id) {
		Customer_entity existing_customer=get_customerByID(id);
		if(existing_customer !=null) {
			repository.deleteById(id);
		}
		else
			throw new Notfound_Exception("data not found");
	}
	
	
}
