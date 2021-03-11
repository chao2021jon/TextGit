package com.atguigu.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal total_Price;
    private String order_Id;

    public OrderItem() {
    }

    public OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal total_Price, String order_Id) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.total_Price = total_Price;
        this.order_Id = order_Id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(BigDecimal totaoPrice) {
        this.total_Price = totaoPrice;
    }

    public String getOrderId() {
        return order_Id;
    }

    public void setOrderId(String orderId) {
        this.order_Id = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", total_Price=" + total_Price +
                ", order_Id='" + order_Id + '\'' +
                '}';
    }
}
