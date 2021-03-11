package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    /**
     * 添加图书信息
     * @param book 添加的图书信�?
     * @return 返回发生改变的行数，返回null表示添加失败
     */
    public int addBook(Book book);

    /**
     * 根据id删除图书信息
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 根据Id修改图书的信�?
     * @param book 图书修改后的信息
     * @return
     */
    public int updateBook(Book book);

    /**
     * 根据id查询图书信息
     * @param id
     * @return
     */
    public Book queryBookOne(Integer id);

    /**
     * 查询�?有图书信�?
     * @return 返回查询结果的list集合
     */
    public List<Book> queryBookList();

    /**
     * 查询返回�?个page集合的类
     * @return
     */
    public List<Book> queryForItems(int bigen,int pageSize);

    /**
     * 查询返回总记录数
     * @return
     */
    public Integer queryForPageTotalCount();

    List<Book> queryForItemsByPrice(int bigen, int pageSize, int min, int max);

    int queryForPageTotalCountByPrice(int min, int max);
}
