package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<list> {

    //使用DbUtils操作数据�?
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行: Inset\Update\Delete语句
     * @return 如果返回-1,说明执行失败<br/>返回其他表示影响的行�?
     */
    public int update(String sql, Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
           return queryRunner.update(conn,sql,args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回�?个JavaBean的sql语句
     * @param type 返回的对象类�?
     * @param sql   执行的sql语句
     * @param args  sql语句的参�?
     * @param <T>   返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个JavaBean的sql语句
     * @param type 返回对象的类�?
     * @param sql   执行的sql语句
     * @param args  sql语句的参�?
     * @param <T>   返回类型的泛�?
     * @return
     */
    public <T> List<T> queryForlist(Class<T> type, String sql, Object... args) {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回�?行一列的sql语句
     * @param sql   执行的sql语句
     * @param args  sql语句的参�?
     * @return
     */
    public Object queryForSingleValue(String sql, Object ... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
