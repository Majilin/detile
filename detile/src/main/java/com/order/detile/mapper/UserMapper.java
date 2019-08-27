package com.order.detile.mapper;

import com.order.detile.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import javax.jws.soap.SOAPBinding;

@Mapper
public interface UserMapper  extends BaseMapper<User> {

}