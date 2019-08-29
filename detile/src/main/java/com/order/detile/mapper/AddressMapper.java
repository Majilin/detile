package com.order.detile.mapper;

import com.order.detile.domain.Address;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AddressMapper extends Mapper<Address> {
    List<Address> selectAddressByUid(int uid);
}