package com.wh.sys.vo;

import com.wh.sys.entity.User;

/**
 * @author 万浩
 * @data 2019/12/12 21:54
 * @description
 */
public class UserVo extends User {
    /**
     * 登录验证码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}