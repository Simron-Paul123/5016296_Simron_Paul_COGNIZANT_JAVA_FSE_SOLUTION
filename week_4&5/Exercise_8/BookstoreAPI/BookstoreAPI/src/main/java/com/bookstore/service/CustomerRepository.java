package com.bookstore.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.entity.Customer_entity;

public interface CustomerRepository extends JpaRepository<Customer_entity, Integer> {
}
