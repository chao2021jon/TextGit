package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer user_Id;
    private Date create_Time;
    private BigDecimal price;
    private Integer status = 0;
    private String order_Id;

    public Order() {
    }

    public Order(Integer user_Id, Date create_Time, BigDecimal price, Integer status, String order_Id) {
        this.user_Id = user_Id;
        this.create_Time = create_Time;
        this.price = price;
        this.status = status;
        this.order_Id = order_Id;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public Date getCreate_Time() {
        return create_Time;
    }

    public void setCreate_Time(Date create_Time) {
        this.create_Time = create_Time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user_Id=" + user_Id +
                ", create_Time=" + create_Time +
                ", price=" + price +
                ", status=" + status +
                ", order_Id='" + order_Id + '\'' +
                '}';
    }
}