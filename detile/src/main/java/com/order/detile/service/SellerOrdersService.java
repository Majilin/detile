package com.order.detile.service;

import com.order.detile.domain.Sellerorders;

public interface SellerOrdersService {
    int insertNewSellerOrders(Sellerorders sellerorders);
    int updateSellerOrderStatus(int status,int orderid);
}
