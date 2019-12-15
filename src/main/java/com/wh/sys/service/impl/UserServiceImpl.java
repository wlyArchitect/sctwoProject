package com.wh.sys.service.impl;

import com.wh.sys.entity.User;
import com.wh.sys.mapper.UserMapper;
import com.wh.sys.service.UserService;
import com.wh.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 万浩
 * @data 2019/12/12 21:49
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param userVo
     */
    @Override
    public void insertUser(UserVo userVo) {
        userMapper.insertSelective(userVo);
    }

    /**
     * 用户登陆
     * @param userVo
     * @return
     */
    @Override
    public User login(UserVo userVo) {
        return userMapper.login(userVo);
    }

    /**
     * 判断用户名是否存在
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

}
