package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<Integer,CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        //判断是否有这个商品，如果没有，就添加，如果有，�?�记录数+1，�?�价格更�?
        CartItem item = items.get(cartItem.getId());

        if( item == null ) {
            //如果没有这个商品，添�?
            items.put(cartItem.getId(),cartItem);
        } else {
            //如果有，总记录数+1，�?�价格更�?
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }


    /**
     * 删除商品
     * @param
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 修改商品数量
     * @param
     */
    public void updateCount(Integer id, Integer count) {
        CartItem item = items.get(id);
        if( item != null ) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 清空购物�?
     * @param
     */
    public void clear() {
        items.clear();
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;

            for(Map.Entry<Integer, CartItem> item: items.entrySet()) {
                totalCount += item.getValue().getCount();
            }

        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for(Map.Entry<Integer, CartItem> item: items.entrySet()) {
            totalPrice = totalPrice.add(item.getValue().getTotalPrice());
        }


        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
