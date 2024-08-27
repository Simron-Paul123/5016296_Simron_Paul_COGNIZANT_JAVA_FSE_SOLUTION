package com.bookstore.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customerdto {
	
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
}
