package com.order.detile.service;

import com.order.detile.domain.User;

import java.util.List;

public interface UserService{


    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> selectAllUser();

}
