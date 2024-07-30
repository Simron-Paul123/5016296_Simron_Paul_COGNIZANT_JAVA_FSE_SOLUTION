/*
 * Exercise 4: Employee Management System
Scenario: 
You are developing an employee management system for a company. Efficiently managing employee records is crucial.
Steps:
1.	Understand Array Representation:
o	Explain how arrays are represented in memory and their advantages.
2.	Setup:
o	Create a class Employee with attributes like employeeId, name, position, and salary.
3.	Implementation:
o	Use an array to store employee records.
o	Implement methods to add, search, traverse, and delete employees in the array.
4.	Analysis:
o	Analyze the time complexity of each operation (add, search, traverse, delete).
o	Discuss the limitations of arrays and when to use them.


 * 
 */
import java.util.*;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of employees: ");
        int capacity = scanner.nextInt();
        EmployeeManagementSystem ems = new EmployeeManagementSystem(capacity);
    
        boolean exit = false;
    
        while (!exit) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Traverse Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
    
            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    ems.addEmployee(new Employee(id, name, position, salary));
                    break;
                case 2:
                    // Search Employee
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = scanner.nextLine();
                    Employee employee = ems.searchEmployee(searchId);
                    if (employee != null) {
                        System.out.println("Employee found: " + employee.name);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    // Delete Employee
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ems.deleteEmployee(deleteId);
                    break;
                case 4:
                    // Traverse Employees
                    ems.traverseEmployees();
                    break;
                case 5:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    
        scanner.close();
    }
}