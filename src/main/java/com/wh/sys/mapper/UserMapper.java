package com.wh.sys.mapper;

import com.wh.sys.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登陆
     */
    User login(User user);

    /**
     *查询用户根据用户名
     * @param userName
     * @return
     */
    User selectByUserName(String userName);
}