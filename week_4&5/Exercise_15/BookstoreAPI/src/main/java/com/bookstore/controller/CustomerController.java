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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Customer Controller", description = "API for managing customers")
public class CustomerController {

    @Autowired
    private CustomerService customerservice;

    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers")
    @GetMapping("/get_All")
    public List<Customer_entity> get_all() {
        return customerservice.get_allCustomers();
    }

    @Operation(summary = "Get customer by ID", description = "Retrieve a customer by its ID")
    @GetMapping("/get_byID/{id}")
    public Customer_entity get_byId(@PathVariable int id) {
        return customerservice.get_customerByID(id);
    }

    @Operation(summary = "Add a new customer", description = "Add a new customer to the system")
    @PostMapping("/add_customer")
    public Customer_entity add_customer(@RequestBody Customer_entity customer) {
        return customerservice.add_customer(customer);
    }

    @Operation(summary = "Update an existing customer", description = "Update customer details by ID")
    @PutMapping("/update_customer/{id}")
    public Customer_entity update_customer(@PathVariable int id, @RequestBody Customer_entity customer) {
        return customerservice.update_customer(id, customer);
    }

    @Operation(summary = "Delete a customer", description = "Delete a customer by ID")
    @DeleteMapping("/delete/{id}")
    public void delete_customer(@PathVariable int id) {
        customerservice.delete_customer(id);
    }
}