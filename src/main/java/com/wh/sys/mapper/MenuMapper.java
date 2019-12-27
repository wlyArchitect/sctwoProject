package com.wh.sys.mapper;

import com.wh.sys.entity.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    /**
     * 查询所有菜单
     * @param menu
     */
    List<Menu> queryAllMenu(Menu menu);

}