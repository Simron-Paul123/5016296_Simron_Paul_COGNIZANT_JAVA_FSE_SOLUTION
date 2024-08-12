package com.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.entity.primary.PrimaryEntity;
import com.Employee.entity.secondary.SecondaryEntity;
import com.Employee.service.PrimaryService;
import com.Employee.service.SecondaryService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final PrimaryService primaryService;
    private final SecondaryService secondaryService;

    @Autowired
    public EmployeeController(PrimaryService primaryService, SecondaryService secondaryService) {
        this.primaryService = primaryService;
        this.secondaryService = secondaryService;
    }

    // Primary Data Source Operations

    @GetMapping("/primary")
    public List<PrimaryEntity> getAllPrimaryEmployees() {
        return primaryService.findAll();
    }

    @GetMapping("/primary/{id}")
    public PrimaryEntity getPrimaryEmployeeById(@PathVariable Long id) {
        return primaryService.findById(id);
    }

    @PostMapping("/primary")
    public PrimaryEntity createPrimaryEmployee(@RequestBody PrimaryEntity primaryEntity) {
        return primaryService.save(primaryEntity);
    }

    @DeleteMapping("/primary/{id}")
    public void deletePrimaryEmployee(@PathVariable Long id) {
        primaryService.deleteById(id);
    }

    // Secondary Data Source Operations

    @GetMapping("/secondary")
    public List<SecondaryEntity> getAllSecondaryEmployees() {
        return secondaryService.findAll();
    }

    @GetMapping("/secondary/{id}")
    public SecondaryEntity getSecondaryEmployeeById(@PathVariable Long id) {
        return secondaryService.findById(id);
    }

    @PostMapping("/secondary")
    public SecondaryEntity createSecondaryEmployee(@RequestBody SecondaryEntity secondaryEntity) {
        return secondaryService.save(secondaryEntity);
    }

    @DeleteMapping("/secondary/{id}")
    public void deleteSecondaryEmployee(@PathVariable Long id) {
        secondaryService.deleteById(id);
    }
}