package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoimpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {
    BookDao bookDao = new BookDaoimpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"天官赐福","陈豪",new BigDecimal(99999),1000,1555,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(6);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(17,"天官赐福","陈子�?",new BigDecimal(99999),1000,1555,null));
    }

    @Test
    public void queryBookOne() {
        System.out.println(bookDao.queryBookOne(17));
    }

    @Test
    public void queryBookList() {
        for (Book queryBook:bookDao.queryBookList()
             ) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void queryForItems() {
        List<Book> books = bookDao.queryForItems(0, 4);
        for (Book book:
             books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }
    @Test
    public void queryForItemsByPrice() {
        List<Book> books = bookDao.queryForItemsByPrice(0, 4,10,80);
        for (Book book:
                books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,80));
    }
}