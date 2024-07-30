/*
 * Exercise 2: E-commerce Platform Search Function
Scenario: 
You are working on the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.
Steps:
1.	Understand Asymptotic Notation:
o	Explain Big O notation and how it helps in analyzing algorithms.
o	Describe the best, average, and worst-case scenarios for search operations.
2.	Setup:
o	Create a class Product with attributes for searching, such as productId, productName, and category.
3.	Implementation:
o	Implement linear search and binary search algorithms.
o	Store products in an array for linear search and a sorted array for binary search.
4.	Analysis:
o	Compare the time complexity of linear and binary search algorithms.
o	Discuss which algorithm is more suitable for your platform and why.

 * 
 */
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);

        // Input the number of products
        System.out.println("Enter the number of products:");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product[] products = new Product[numProducts];

        // Input the products
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            String productId = scanner.nextLine();
            System.out.print("Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            products[i] = new Product(productId, productName, category);
        }

        ECommerceSearch ecs = new ECommerceSearch();

        String continueSearch = "yes";
        while (continueSearch.equalsIgnoreCase("yes")) {
            System.out.println("Enter the product name to search:");
            String productName = scanner.nextLine();

            System.out.println("Select search method:");
            System.out.println("1 -> Linear Search");
            System.out.println("2 -> Binary Search");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Product result = null;
            switch (choice) {
                case 1:
                    result = ecs.linearSearch(products, productName);
                    break;
                case 2:
                    // Sort the products array by product name for binary search
                    Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
                    result = ecs.binarySearch(products, productName);
                    break;
                default:
                    System.out.println("Invalid option. Please select either 1 or 2.");
                    continue;
            }

            if (result != null) {
                System.out.println("Product found: " + result.productName + " in category " + result.category);
            } else {
                System.out.println("Product not found.");
            }

            System.out.print("Do you want to search for another product? (yes/no): ");
            continueSearch = scanner.nextLine();
        }
    }
}