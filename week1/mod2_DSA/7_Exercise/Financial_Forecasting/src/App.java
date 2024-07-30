/*
 * 
 * Exercise 7: Financial Forecasting
Scenario: 
You are developing a financial forecasting tool that predicts future values based on past data.
Steps:
1.	Understand Recursive Algorithms:
o	Explain the concept of recursion and how it can simplify certain problems.
2.	Setup:
o	Create a method to calculate the future value using a recursive approach.
3.	Implementation:
o	Implement a recursive algorithm to predict future values based on past growth rates.
4.	Analysis:
o	Discuss the time complexity of your recursive algorithm.
o	Explain how to optimize the recursive solution to avoid excessive computation.


 */
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        FinancialForecasting ff = new FinancialForecasting();
        System.out.print("enter current value: ");
        double c=sc.nextDouble();
        System.out.print("enter growth rate: ");
        double r=sc.nextDouble();
        System.out.print("enter years: ");
        int y=sc.nextInt();
        double futureValue = ff.calculateFutureValue(c,r,y);
        System.out.println("Future Value: " + futureValue);
    }
}
