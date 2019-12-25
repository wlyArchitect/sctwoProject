package com.wh.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.wh.sys.constant.SysConstant;
import com.wh.sys.entity.User;
import com.wh.sys.service.UserService;
import com.wh.sys.utils.WebUtils;
import com.wh.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * 登录/注销用户
 *
 * @author 万浩
 * @data 2019/12/12 21:48
 * @description
 */
@RequestMapping("/log")
@Controller
public class LogController {
    @Autowired
    private UserService userService;

    /**
     * 注册界面
     * 对表单数据的(用户名是否重复)的处理
     */
    @RequestMapping("/toRegisterHanding")
    public void toRegisterHanding(String userName,HttpServletResponse response){
        boolean flag=false;
        User user = userService.getUserByUserName(userName);
        if (user!=null){
            flag=true;
        }
        try {
            response.getWriter().write(String.valueOf(flag));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 注册界面:
     * 进行注册操作
     */
    @RequestMapping("/toRegister")
    public String toRegister(UserVo userVo){
        //设置可用
        userVo.setAvailable(1);
        userVo.setType(2);
        //设置创建日期
        userVo.setUserCreateDate(new Date());
        System.err.println(userVo.getUserHeadPortrait());
        userService.insertUser(userVo);
        return "system/main/login";
    }

    /**
     * 跳转到注册界面
     * @return
     */
    @RequestMapping("/toRegisterPage")
    public String toRegister(){
        return "system/main/register";
    }

    /**
     * 退出登录时,清除session
     */
    @RequestMapping("/toDeleteSession")
    public void toDeleteSession() {
        System.err.println("清除session");
        //删除用户的session
        //WebUtils.getHttpSession().removeAttribute("user");
    }
    /**
     * 跳转到登陆页面
     */
    @RequestMapping("/toLoginPage")
    public String toIndex() {
        System.err.println("登陆界面...");
        //redirect: 重定向
        return "system/main/login";
    }

    /**
     * 登录到主页的处理
     *
     */
    @RequestMapping("/toIndexHanding")
    public String toLogin(UserVo userVo, Model model) {
        String code = (String) WebUtils.getHttpSession().getAttribute("code");
        if (!userVo.getCode().equals(code)){
            model.addAttribute("error", SysConstant.USER_LOGIN_CODE_ERROR );
            return "system/main/login";
        }
        System.err.println(userVo.getUserName()+"\t"+userVo.getUserPwd());
        User user = this.userService.login(userVo);
        if (null != user) {
            //放到session
            WebUtils.getHttpSession().setAttribute("user", user);
            //记录登陆日志 向sys_login_log里面插入数据
            return "system/main/index";
        } else {
            model.addAttribute("error", SysConstant.USER_LOGIN_ERROR);
            return "system/main/login";
        }
    }
    /**
     * 得到登录验证码
     */
    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //定义图形验证码的长和宽 4个字符 线条个数5条
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36,4,5);
        session.setAttribute("code",lineCaptcha.getCode());
        //拿到输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //输出页面
        ImageIO.write(lineCaptcha.getImage(), "JPEG", outputStream);
    }
}