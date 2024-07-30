/*
 * 
 * Exercise 5: Implementing the Decorator Pattern
Scenario: 
You are developing a notification system where notifications can be sent via multiple channels (e.g., Email, SMS). Use the Decorator Pattern to add functionalities dynamically.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named DecoratorPatternExample.
2.	Define Component Interface:
o	Create an interface Notifier with a method send().
3.	Implement Concrete Component:
o	Create a class EmailNotifier that implements Notifier.
4.	Implement Decorator Classes:
o	Create abstract decorator class NotifierDecorator that implements Notifier and holds a reference to a Notifier object.
o	Create concrete decorator classes like SMSNotifierDecorator, SlackNotifierDecorator that extend NotifierDecorator.
5.	Test the Decorator Implementation:
o	Create a test class to demonstrate sending notifications via multiple channels using decorators.



 */

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Notifier notification_1 = new SMSNotifierDecorator(new EmailNotifier());
        String s1=notification_1.send();
        System.out.println(s1);
        Notifier notification_2 = new SlackNotifierDecorator(new EmailNotifier());
        String s2=notification_2.send();
        System.out.println(s2);
    }
}
