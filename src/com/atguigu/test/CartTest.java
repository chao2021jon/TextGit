package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(2,"Python基础",1,new BigDecimal(69.0),new BigDecimal(69.0)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(2,"Python基础",1,new BigDecimal(69.0),new BigDecimal(69.0)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(2,"Python基础",1,new BigDecimal(69.0),new BigDecimal(69.0)));

        cart.deleteItem(1);

        cart.updateCount(2,2);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(2,"Python基础",1,new BigDecimal(69.0),new BigDecimal(69.0)));

        cart.deleteItem(1);

        cart.updateCount(2,2);
        cart.clear();
        System.out.println(cart);
    }
}