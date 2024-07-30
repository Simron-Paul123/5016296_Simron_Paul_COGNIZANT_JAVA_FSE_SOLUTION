/*
 * 
 * Exercise 6: Implementing the Proxy Pattern
Scenario: 
You are developing an image viewer application that loads images from a remote server. Use the Proxy Pattern to add lazy initialization and caching.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named ProxyPatternExample.
2.	Define Subject Interface:
o	Create an interface Image with a method display().
3.	Implement Real Subject Class:
o	Create a class RealImage that implements Image and loads an image from a remote server. // loader function is private which is invoked inside the constructor
4.	Implement Proxy Class:
o	Create a class ProxyImage that implements Image and holds a reference to RealImage.
o	Implement lazy initialization and caching in ProxyImage.
5.	Test the Proxy Implementation:
o	Create a test class to demonstrate the use of ProxyImage to load and display images.

 */
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Scanner sc=new Scanner(System.in);
        System.out.print("enter image file name: ");
        String s=sc.nextLine();
        ProxyImage p=new ProxyImage(new RealImage(s),s);
        p.display();
    }
}
