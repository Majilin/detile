package com.order.detile.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.order.detile.mapper.OrdersdetailMapper;
import com.order.detile.domain.Ordersdetail;
import com.order.detile.service.OrdersdetailService;
@Service
public class OrdersdetailServiceImpl implements OrdersdetailService{

    @Resource(name = "ordersdetailMapper")
    OrdersdetailMapper ordersdetailMapper;
    @Override
    public int insertNewOrdersDetail(Ordersdetail ordersdetail) {
        return ordersdetailMapper.insert(ordersdetail);
    }
}
