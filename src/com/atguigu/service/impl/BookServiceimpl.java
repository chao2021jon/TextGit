package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoimpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceimpl implements BookService {
    BookDao bookDao = new BookDaoimpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookOne(id);
    }

    @Override
    public List<Book> queryBookList() {
        return bookDao.queryBookList();
    }

    @Override
    public Page page(int pageNo, int pageSize) {
        Page page = new Page();

        int bigen = (pageNo -1 ) * pageSize;
        List<Book> items = bookDao.queryForItems(bigen,pageSize);
        int pageTotalCount = bookDao.queryForPageTotalCount();
        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        page.setPageNo(pageNo);
        page.setPageTotal(pageTotal);
        page.setPageTotalCount(pageTotalCount);
        page.setPageSize(pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page page = new Page();

        int bigen = (pageNo -1 ) * pageSize;
        List<Book> items = bookDao.queryForItemsByPrice(bigen,pageSize,min,max);
        int pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        page.setPageNo(pageNo);
        page.setPageTotal(pageTotal);
        page.setPageTotalCount(pageTotalCount);
        page.setPageSize(pageSize);
        page.setItems(items);
        return page;
    }
}
