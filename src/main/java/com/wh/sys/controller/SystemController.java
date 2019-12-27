package com.wh.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面跳转控制器:作用 路由
 * @author 万浩
 * @data 2019/12/12 21:47
 * @description
 */
@RequestMapping("/sys")
@Controller
public class SystemController {
    /**
     * 跳转到 选择考试主界面
     */
    @RequestMapping("/toChoiceExamPage")
    public String toChoiceExamPage(){
        return "system/exam/choiceExam";
    }
    /**
     * 跳转到 考试历史界面
     */
    @RequestMapping("/toExamHistoryPage")
    public String toExamHistory(){
        return "system/exam/examHistory";
    }
    /**
     * 跳转到 论坛主界面
     * @return
     */
    @RequestMapping("/toForumPage")
    public String toForumPage(){
         return "system/forum/forum";
    }
    /**
     * 跳转到交友界面
     */
    @RequestMapping("/toMakeFriendsPage")
    public String toMakeFriendsPage(){
        return "system/makeFriends/makeFriends";
    }
    /**
     * 跳转到后台界面
     */
    @RequestMapping("/toHouTaiPage")
    public String toHouTaiPage(){
        return "system/background/index";
    }

    /**
     * 跳转菜单管理
     */
    @RequestMapping("/toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }
    /**
     * 跳转菜单管理左边的的菜单树页面
     */
    @RequestMapping("/toMenuLeft")
    public String toMenuLeft() {
        return "system/menu/menuLeft";
    }
    /**
     * 跳转菜单管理右边的菜单列表
     */
    @RequestMapping("/toMenuRight")
    public String toMenuRight() {
        return "system/menu/menuRight";
    }

}
