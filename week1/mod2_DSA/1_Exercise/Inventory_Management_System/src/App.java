/*
 * 
 * Exercise 1: Inventory Management System
Scenario: 
You are developing an inventory management system for a warehouse. Efficient data storage and retrieval are crucial.
Steps:
1.	Understand the Problem:
o	Explain why data structures and algorithms are essential in handling large inventories.
o	Discuss the types of data structures suitable for this problem.
2.	Setup:
o	Create a new project for the inventory management system.
3.	Implementation:
o	Define a class Product with attributes like productId, productName, quantity, and price.
o	Choose an appropriate data structure to store the products (e.g., ArrayList, HashMap).
o	Implement methods to add, update, and delete products from the inventory.
4.	Analysis:
o	Analyze the time complexity of each operation (add, update, delete) in your chosen data structure.
o	Discuss how you can optimize these operations.

 */
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        String s = "yes";

        while (!s.equalsIgnoreCase("no")) {
            System.out.println("Enter 1 -> Add items\nEnter 2 -> Delete items\n3 -> Update price/item\n4 -> Display the database");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter product price: ");
                    int price = sc.nextInt();
                    Product product = new Product(id, name, quantity, price);
                    inventory.addProduct(product);
                    break;
                }
                case 2: {
                    System.out.print("Enter product ID to delete: ");
                    int id = sc.nextInt();
                    inventory.deleteProduct(id);
                    break;
                }
                case 3: {
                    System.out.print("Enter product ID to update price: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new price: ");
                    int newPrice = sc.nextInt();
                    inventory.updateProduct(id, newPrice);
                    break;
                }
                case 4: {
                    inventory.displayInventory();
                    break;
                }
                default: {
                    System.out.println("Invalid option");
                }
            }
            System.out.print("Do you want to continue? (yes/no): ");
            s = sc.next();
        }

        sc.close();
    }
}
