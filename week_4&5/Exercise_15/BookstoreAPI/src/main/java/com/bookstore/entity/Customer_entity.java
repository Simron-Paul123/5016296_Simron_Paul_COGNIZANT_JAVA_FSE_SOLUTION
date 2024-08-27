package com.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Customer_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Name is required")
    private String first_name;
    @NotNull(message = "Name is required")
    private String last_name;
    @NotNull(message = "Name is required")
    private String email;
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters")
    private String password; // Changed from `Password` to `password`
    @Version
    private Long version;
    // Default constructor
    public Customer_entity() {
    }

    // Parameterized constructor
    public Customer_entity(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "Customer_entity [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", password=" + password + "]";
	}
    
}
