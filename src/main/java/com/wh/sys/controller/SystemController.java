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
}
