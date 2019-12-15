package com.wh.sys.service;

import com.wh.sys.entity.User;
import com.wh.sys.vo.UserVo;

/**
 * @author 万浩
 * @data 2019/12/12 21:48
 * @description
 */
public interface UserService {
    /**
     * 用户注册
     */
    void insertUser(UserVo userVo);
    /**
     * 用户登录
     * @param userVo
     * @return
     */
    User login(UserVo userVo);
    /**
     * 根据用户获取用户
     */
    User getUserByUserName(String userName);
}
