package com.wh.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工作台的控制器
 *
 * @author 万浩
 * @data 2019/12/19 23:00
 * @description
 */
@RequestMapping("/desk")
@Controller
public class DeskController {
    /**
     * 跳转到工作台界面
     */
    @RequestMapping("/toDeskManager")
    public String toDeskManager(){
        return "system/background/deskManager";
    }
}
