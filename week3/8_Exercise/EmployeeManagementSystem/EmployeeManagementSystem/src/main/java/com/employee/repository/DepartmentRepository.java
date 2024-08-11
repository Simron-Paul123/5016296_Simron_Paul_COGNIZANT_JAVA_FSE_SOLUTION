package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	Department findByName(String name);

    // Derived query method to find departments with a given name
    List<Department> findByNameContaining(String partialName);
}
