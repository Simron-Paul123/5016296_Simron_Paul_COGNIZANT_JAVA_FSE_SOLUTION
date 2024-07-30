/*
 * Exercise 2: Implementing the Factory Method Pattern
Scenario: 
You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named FactoryMethodPatternExample.
2.	Define Document Classes:
o	Create interfaces or abstract classes for different document types such as WordDocument, PdfDocument, and ExcelDocument.
3.	Create Concrete Document Classes:
o	Implement concrete classes for each document type that implements or extends the above interfaces or abstract classes.
4.	Implement the Factory Method:
o	Create an abstract class DocumentFactory with a method createDocument().
o	Create concrete factory classes for each document type that extends DocumentFactory and implements the createDocument() method.
5.	Test the Factory Method Implementation:
o	Create a test class to demonstrate the creation of different document types using the factory method.

 * 
 */
import java.util.*;
public class test {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Scanner sc=new Scanner(System.in);
        System.out.println("There are 3 types of document\n1->WordDocument\n2->PdfDocument\n3->ExcelDocument");
        System.out.print("enter what type of document you want to open: ");
        String s=sc.nextLine();
        while(!s.equals("exit")){
            DocumentFactory doc=Factory.factory_method(s); //creating DocumentFactory (abstract class) type object
            document d=doc.createDocument(); // creating document(interface) type of object
            d.open_doc();
            System.out.println("enter exit to terminate");
            System.out.print("enter what type of document you want to open: ");
            s=sc.nextLine();
        }
        sc.close();
    }
}