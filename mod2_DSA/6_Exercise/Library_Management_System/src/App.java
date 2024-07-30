/*
 * 
 * Exercise 6: Library Management System
Scenario: 
You are developing a library management system where users can search for books by title or author.
Steps:
1.	Understand Search Algorithms:
o	Explain linear search and binary search algorithms.
2.	Setup:
o	Create a class Book with attributes like bookId, title, and author.
3.	Implementation:
o	Implement linear search to find books by title.
o	Implement binary search to find books by title (assuming the list is sorted).
4.	Analysis:
o	Compare the time complexity of linear and binary search.
o	Discuss when to use each algorithm based on the data set size and order.


 */
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        System.out.println("no of books you want: ");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Book[]books= new Book[n];
        for(int i=0;i<n;i++){
            System.out.print("enter BookId: ");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.print("enter title: ");
            String title=sc.nextLine();
            System.out.print("enter author name: ");
            String author=sc.nextLine();
            books[i]=new Book(id,title,author);
        }

        System.out.print("enter book title you want to search: ");
        String title=sc.nextLine();
        Find_Books find = new Find_Books(books);
        Book b1=find.linear_search(title);
        if(b1!=null){
            System.out.println("book is found");
            System.out.println("ID\tTitle\tauthor");
            System.out.println(b1.getBookId()+"\t"+b1.getTitle()+"\t"+b1.getAuthor());
            System.out.println("this book is searched by Linear Search Method");
        }
        else{
            System.out.println("book is not found");
        }
        System.out.print("enter another book title you want to search: ");
        String another_title=sc.nextLine();
        Book b2=find.Binary_search(another_title);
        if(b2!=null){
            System.out.println("book is found");
            System.out.println("ID\tTitle\tauthor");
            System.out.println(b2.getBookId()+"\t"+b2.getTitle()+"\t"+b2.getAuthor());
            System.out.println("This book is searched by Binary Search Method");
        }
        else{
            System.out.println("book is not found");
        }

    }
}
