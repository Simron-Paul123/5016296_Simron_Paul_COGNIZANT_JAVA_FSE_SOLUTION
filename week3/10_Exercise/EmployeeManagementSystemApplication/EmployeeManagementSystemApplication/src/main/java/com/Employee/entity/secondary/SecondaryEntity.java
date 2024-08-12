package com.Employee.entity.secondary;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
@Entity
public class SecondaryEntity {
	 @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;

	    //@Type(type = "yes_no")
	   // private boolean verified;

	    // other fields, getters, setters
	}