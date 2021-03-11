package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {
    /**
     * 添加图书信息
     * @param book 添加图书信息的类
     */
    public void addBook(Book book);

    /**
     * 根据id删除图书信息
     * @param id 要删除图书信息的id
     */
    public void deleteBookById(Integer id);

    /**
     * 根据Id修改图书的信�?
     * @param book 图书修改后的信息
     * @return
     */
    public void updateBook(Book book);
    /**
     * 根据id查询图书信息
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);
    /**
     * 查询�?有图书信�?
     * @return 返回查询结果的list集合
     */
    public List<Book> queryBookList();

    /**
     * 查询返回�?个book集合的类
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page page(int pageNo, int pageSize);

    Page pageByPrice(int pageNo, int pageSize, int min, int max);
}
