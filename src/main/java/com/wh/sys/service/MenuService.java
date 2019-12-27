package com.wh.sys.service;

import com.wh.sys.entity.Menu;
import com.wh.sys.utils.DataGridViewUtil;
import com.wh.sys.vo.MenuVo;

import java.util.List;

/**
 * @author 万浩
 * @data 2019/12/25 0:10
 * @description
 */
public interface MenuService {
    /**
     * 查询所有菜单返回(超级管理员最大的)
     * @return List<Menu>
     */
    public List<Menu> queryAllMenuForList(MenuVo menuVo);
    /**
     * 根据用户id查询用户的可用菜单(后续分权限)
     */
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo,Integer userId);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
    DataGridViewUtil queryAllMenu(MenuVo menuVo);


    /**
     * 添加菜单
     * @param menuVo
     */
   // public void addMenu(MenuVo menuVo);
}
