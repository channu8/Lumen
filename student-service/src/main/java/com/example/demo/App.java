package com.example.demo;

import com.example.demo.entity.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Book book = new Book();
        book.setBookNumber(101);
        book.setBookName("Java");
        
        System.out.println(book);
        
    }
}
