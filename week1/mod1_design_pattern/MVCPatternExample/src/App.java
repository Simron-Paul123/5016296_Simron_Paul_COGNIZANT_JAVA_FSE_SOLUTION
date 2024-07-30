/*
 * 
 * Exercise 10: Implementing the MVC Pattern
Scenario: 
You are developing a simple web application for managing student records using the MVC pattern.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named MVCPatternExample.
2.	Define Model Class:
o	Create a class Student with attributes like name, id, and grade.
3.	Define View Class:
o	Create a class StudentView with a method displayStudentDetails().
4.	Define Controller Class:
o	Create a class StudentController that handles the communication between the model and the view.
5.	Test the MVC Implementation:
o	Create a main class to demonstrate creating a Student, updating its details using StudentController, and displaying them using StudentView.





 */
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        // Fetch student record from the database
        Student model = retrieveStudentFromDatabase();

        // Create a view to write student details on console
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(model, view);

        // Display the initial details
        controller.updateView();

        // Update the model data
        controller.setStudentName("John Doe");
        controller.setStudentGrade("A");

        // Display the updated details
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setId("10");
        student.setGrade("B");
        return student;
    }
}
