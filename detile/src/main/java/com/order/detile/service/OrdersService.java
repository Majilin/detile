package com.order.detile.service;

import com.order.detile.domain.Orders;

public interface OrdersService{
    int insertNewOrder(Orders orders);
    int updateOrderStatus(int status,int orderid);
}
