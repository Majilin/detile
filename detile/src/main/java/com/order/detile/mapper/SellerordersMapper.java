package com.order.detile.mapper;

import com.order.detile.domain.Sellerorders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerordersMapper extends tk.mybatis.mapper.common.Mapper<Sellerorders> {
    int updateSellerOrderStatus(int status,int orderid);
}