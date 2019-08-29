package com.order.detile.serviceimpl;

import com.order.detile.domain.Sellerorders;
import com.order.detile.mapper.SellerordersMapper;
import com.order.detile.service.SellerOrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SellerOrdersServiceImpl implements SellerOrdersService {
    @Resource(name = "sellerordersMapper")
    SellerordersMapper sellerordersMapper;
    @Override
    public int insertNewSellerOrders(Sellerorders sellerorders) {
        return sellerordersMapper.insert(sellerorders);
    }

    @Override
    public int updateSellerOrderStatus(int status, int orderid) {
        return sellerordersMapper.updateSellerOrderStatus(status,orderid);
    }
}
