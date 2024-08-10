package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Department;
import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 List<Employee> findByName(String name);

	    // Derived query method to find employees by email
	    Employee findByEmail(String email);

	    // Derived query method to find employees by department
	    List<Employee> findByDepartment(Department department);
}
