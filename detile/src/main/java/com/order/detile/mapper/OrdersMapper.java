package com.order.detile.mapper;

import com.order.detile.domain.Orders;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface OrdersMapper extends Mapper<Orders> {
    int updateOrderStatus(int status,int orderid);
}