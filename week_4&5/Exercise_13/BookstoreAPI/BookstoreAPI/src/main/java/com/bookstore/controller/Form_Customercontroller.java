package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import com.bookstore.entity.Customer_entity;
import com.bookstore.service.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class Form_Customercontroller {

    private static final Logger logger = LoggerFactory.getLogger(Form_Customercontroller.class);

    @Autowired
    private CustomerRepository customerRepository;
       @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer_entity());
        return "register"; 
    }
    
    @PostMapping("/customer")
    public ResponseEntity<Customer_entity> saveProduct(@RequestBody Customer_entity customer) {
        Customer_entity newCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(newCustomer);
    }
    

    @PostMapping("/do_register")
    public String register(@ModelAttribute("customer") Customer_entity customer) {
        try {
            logger.info("Registering customer: " + customer.toString());
            customerRepository.save(customer);
            logger.info("Customer registered successfully!");
        } catch (Exception e) {
            logger.error("Error during customer registration", e);
            return "error"; // Return an error page or handle appropriately
        }
        return "redirect:/register"; // Redirect to the home page after successful registration
    }
    
    /*---------------------------------------------------------------------------------------*/
    
   /*
    
    */
}
