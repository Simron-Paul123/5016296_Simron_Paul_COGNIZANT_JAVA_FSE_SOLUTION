package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Customer_entity;
import com.bookstore.service.CustomerService;

@RestController
public class CustomerController {
	 @Autowired
	    private CustomerService customerservice;
	 @GetMapping("/get_All")
	    public List<Customer_entity> get_all(){
	    	return customerservice.get_allCustomers();
	    }
	    @GetMapping("/get_byID/{id}")
	    public Customer_entity get_byId(@PathVariable int id) {
	    	return customerservice.get_customerByID(id);
	    }
	    @PostMapping("/add_customer")
	    public Customer_entity add_customer(@RequestBody Customer_entity customer) {
	    	return customerservice.add_customer(customer);
	    }
	    @PutMapping("/update_customer/{id}")
	    public Customer_entity update_customer(@PathVariable int id,@RequestBody Customer_entity customer) {
	    	return customerservice.update_customer(id, customer);
	    }
	    @DeleteMapping("delete/{id}")
	    public void delete_customer(@PathVariable int id) {
	    	customerservice.delete_customer(id);
	    }
}
