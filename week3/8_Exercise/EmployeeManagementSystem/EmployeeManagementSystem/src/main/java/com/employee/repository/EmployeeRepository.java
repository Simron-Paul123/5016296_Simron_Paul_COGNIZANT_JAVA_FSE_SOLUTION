package com.employee.repository;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.projection.EmployeeProjection;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//interface base projection
	// Using @Value to fetch specific fields
    @Query("SELECT e FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllEmployeeProjections();
	
	//class based projection
    
    // Using constructor expression to fetch specific fields and map to EmployeeDTO
    @Query("SELECT new com.employee.dto.EmployeeDTO(e.id, e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeDTO> findAllEmployeeDTOs();
    
    
    
	
	// Method to fetch paginated employee list
    Page<Employee> findAll(Pageable pageable);
    
 // Method to fetch sorted employee list
    List<Employee> findAll(Sort sort);
    
    
    
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
