package com.Employee.entity.primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("deprecation")
@Entity
public class PrimaryEntity {
    @SuppressWarnings("deprecation")
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

   // @Type(type = "yes_no")
 //   private boolean active;
    @Formula("(select avg(s.salary) from Salary s where s.employee_id = id)")
    private Double averageSalary;

    // other fields, getters, setters
}