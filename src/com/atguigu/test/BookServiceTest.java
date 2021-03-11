package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceimpl;
import org.junit.Test;

import java.math.BigDecimal;

public class BookServiceTest {
        BookService bookService = new BookServiceimpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"葵花宝典","欧阳记海",new BigDecimal(9999),888,999,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(4);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(18,"葵花宝典","林平�?",new BigDecimal(9999),888,999,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(18));
    }

    @Test
    public void queryBookList() {
        for (Book queryBook:bookService.queryBookList()
             ) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void page() {
        System.out.println(bookService.page(1,4));
    }
    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,4,10,50));
    }
}