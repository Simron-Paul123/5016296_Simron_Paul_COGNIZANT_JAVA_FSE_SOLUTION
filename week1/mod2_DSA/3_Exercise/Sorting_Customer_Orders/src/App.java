/*
 * Exercise 3: Sorting Customer Orders
Scenario: 
You are tasked with sorting customer orders by their total price on an e-commerce platform. This helps in prioritizing high-value orders.
Steps:
1.	Understand Sorting Algorithms:
o	Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort).
2.	Setup:
o	Create a class Order with attributes like orderId, customerName, and totalPrice.
3.	Implementation:
o	Implement Bubble Sort to sort orders by totalPrice.
o	Implement Quick Sort to sort orders by totalPrice.
4.	Analysis:
o	Compare the performance (time complexity) of Bubble Sort and Quick Sort.
o	Discuss why Quick Sort is generally preferred over Bubble Sort.

 */
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);

        // Input the number of orders
        System.out.println("Enter the number of orders:");
        int numOrders = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Order[] orders = new Order[numOrders];

        // Input the orders
        for (int i = 0; i < numOrders; i++) {
            System.out.println("Enter details for order " + (i + 1) + ":");
            System.out.print("Order ID: ");
            String orderId = scanner.nextLine();
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Total_Price: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            orders[i] = new Order(orderId, customerName, amount);
        }

        // Example usage (displaying the orders)
        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId + ", Customer: " + order.customerName + ", Total_Price: Rs/-" + order.totalPrice);
        }
        OrderSorter sorter = new OrderSorter();
        sorter.bubbleSort(orders);
        for (Order order : orders) {
            System.out.print(order.totalPrice+" ");
        }
        System.out.println();

        sorter.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.print(order.totalPrice+" ");
        }
        System.out.println();
    }
}
