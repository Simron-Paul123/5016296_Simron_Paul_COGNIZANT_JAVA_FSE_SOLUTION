package com.library;
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
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    	BookService b=(BookService)context.getBean("bookService");
    	b.display();
    	
    }
}
