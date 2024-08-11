package com.employee.projection;

public interface EmployeeProjection {
    Long getId();
    String getName();
    String getEmail();
    String getDepartmentName();  // Assuming you want to get the department name as well
}
