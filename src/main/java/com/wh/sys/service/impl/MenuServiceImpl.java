package com.wh.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wh.sys.entity.Menu;
import com.wh.sys.mapper.MenuMapper;
import com.wh.sys.service.MenuService;
import com.wh.sys.utils.DataGridViewUtil;
import com.wh.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 万浩
 * @data 2019/12/25 21:24
 * @description
 */
@Service
public class MenuServiceImpl implements MenuService  {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.queryAllMenu(menuVo);
    }

    /**
     * 后期权限管理完成后修改
     * @param menuVo
     * @param userId
     * @return
     */
    @Override
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
        return menuMapper.queryAllMenu(menuVo);
    }

    /**
     * 加载所有的菜单项,根据
     * @param menuVo
     * @return
     */
    @Override
    public DataGridViewUtil queryAllMenu(MenuVo menuVo) {
        //使用PageHelper分页插件
        System.err.println("menuVo"+menuVo.getPage()+"\t"+menuVo.getLimit());
        Page<Object> page = PageHelper.startPage(menuVo.getPage(),
                menuVo.getLimit());
        List<Menu> data = this.menuMapper.queryAllMenu(menuVo);
        return new DataGridViewUtil(page.getTotal(), data);
    }
}
