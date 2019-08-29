package com.order.detile.serviceimpl;

import com.order.detile.domain.Orders;
import com.order.detile.mapper.OrdersMapper;
import com.order.detile.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource(name="ordersMapper")
    OrdersMapper ordersMapper;
    @Override
    public int insertNewOrder(Orders orders) {
        return ordersMapper.insert(orders);
    }

    @Override
    public int updateOrderStatus(int status,int orderid) {
        return ordersMapper.updateOrderStatus(status,orderid);
    }
}
