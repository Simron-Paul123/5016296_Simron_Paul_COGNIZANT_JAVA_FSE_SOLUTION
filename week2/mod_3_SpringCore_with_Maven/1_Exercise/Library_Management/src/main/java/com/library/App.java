package com.library;
import com.library.service.BookService;
import com.library.repository.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        BookRepository bookRepository=(BookRepository) context.getBean("bookRepository");
        // Test the configuration
        bookService.displayService();
        bookRepository.displayRepository();
    }
}
