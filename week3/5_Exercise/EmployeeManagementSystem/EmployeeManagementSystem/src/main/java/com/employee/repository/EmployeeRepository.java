package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Department;
import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 List<Employee> findByName(String name);
	// Derived query method to find employees by department name
	    List<Employee> findByDepartmentName(String name);

	   
	    // Derived query method to find employees by email
	    Employee findByEmail(String email);

	    // Derived query method to find employees by department
	    List<Employee> findByDepartment(Department department);
	    
	    //custom query
	    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain")
	    List<Employee> findByEmailDomain(@Param("domain") String domain);
	    
	    
}
