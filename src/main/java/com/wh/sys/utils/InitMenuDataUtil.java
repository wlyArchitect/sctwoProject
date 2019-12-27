package com.wh.sys.utils;

import com.wh.sys.entity.Menu;
import com.wh.sys.mapper.MenuMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 初始化菜单项数据(初始化一次即可)
 * @author 万浩
 * @data 2019/12/22 21:29
 * @description
 */
public class InitMenuDataUtil {
    @Test
    public void initData(){
        //初始化容器,默认路径classpath
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //2.动态获取
        MenuMapper menuMapper  = context.getBean(MenuMapper.class);
        menuMapper.insert(new Menu(1, 0,null, "考试系统", 1, "&#xe68e;", 1));
        menuMapper.insert(new Menu(2, 1,null, "论坛模块", 1, "&#xe653;", 1));
        menuMapper.insert(new Menu(3, 1, null,"考试模块", 0, "&#xe663;", 1));
        menuMapper.insert(new Menu(4, 1, null, "系统管理", 0, "&#xe716;", 1));
        menuMapper.insert(new Menu(5, 1,null, "统计分析", 0, "&#xe629;", 1));

        menuMapper.insert(new Menu(6, 2,null, "回帖管理", 0, "&#xe770;", 1));
        menuMapper.insert(new Menu(7, 2, null,"举报回帖", 0, "&#xe657;", 1));
        menuMapper.insert(new Menu(8, 2,null, "举报发帖", 0, "&#xe657;", 1));

        menuMapper.insert(new Menu(9, 3,null, "题库管理", 0, "&#xe65b;", 1));
        menuMapper.insert(new Menu(10, 3, null,"考卷管理", 0, "&#xe6b2;", 1));
        menuMapper.insert(new Menu(11, 3,null, "考生考卷", 0, "&#xe65a;", 1));

        menuMapper.insert(new Menu(12, 4,null, "菜单管理", 0, "&#xe60f;", 1));
        menuMapper.insert(new Menu(13, 4,null, "角色管理", 0, "&#xe66f;", 1));
        menuMapper.insert(new Menu(14, 4,null, "用户管理", 0, "&#xe770;", 1));
        menuMapper.insert(new Menu(15, 4, null,"日志管理", 0, "&#xe655;", 1));
        menuMapper.insert(new Menu(16, 4,null, "公告管理", 0, "&#xe645;", 1));
        menuMapper.insert(new Menu(17, 4,null, "数据源监控", 0, "&#xe857;", 1));

        menuMapper.insert(new Menu(18, 5, null,"月份考卷统计", 0, "&#xe62c;", 1));

        System.out.println("初始化完成");
    }
}
