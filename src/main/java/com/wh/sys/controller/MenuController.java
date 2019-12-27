package com.wh.sys.controller;

import com.wh.sys.constant.SysConstant;
import com.wh.sys.entity.Menu;
import com.wh.sys.entity.User;
import com.wh.sys.service.MenuService;
import com.wh.sys.utils.DataGridViewUtil;
import com.wh.sys.utils.TreeNodeUtil;
import com.wh.sys.utils.WebUtils;
import com.wh.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 后台菜单管理控制器
 * (返回的都是json数据)
 *
 * @author 万浩
 * @data 2019/12/25 21:25
 * @description
 */
@RequestMapping("/menu")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    /**
     * 简单的json数据格式
     */
    @RequestMapping("/loadIndexLeftMenuJson")
    public List<TreeNodeUtil> loadIndexLeftMenuJson(MenuVo menuVo){
        //1.得到当前登陆的用户对象
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        //2.存储不同用户可用的菜单项
        List<Menu> list = null;
        //设置查询可用的菜单项
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);
        //获取所有的List<菜单项> list
        if (user.getType().equals(SysConstant.USER_TYPE_SUPER)) {
            //超级管理员(最大的)
            list = this.menuService.queryAllMenuForList(menuVo);
        } else {
            //普通用户
            list = this.menuService.queryMenuByUserIdForList(menuVo, user.getUserId());
        }
        //todo 3.1先定义一个集合,用于接收所有的数据,但是没有层级关系
        List<TreeNodeUtil> nodes = new ArrayList<>(10);
        //把list集合中的数据放到nodes
        for (Menu menu : list) {
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            //是否展开,前台的dtree接收true false所以需要转换
            Boolean spread = menu.getSpread().equals(SysConstant.SPREAD_TRUE) ? true : false;
            nodes.add(new TreeNodeUtil(id, pid, title, icon, href,spread));
        }
        //todo 3.2再定义一个集合,用于展示层级关系,通过TreeNodeUtil的属性children子节点
        List<TreeNodeUtil> treeNode = new ArrayList<>(10);
        for (TreeNodeUtil n1 : nodes) {
            //是否为根节点
            if (n1.getPid()==1){
                treeNode.add(n1);
            }
            //为根节点找它的子节点
            for (TreeNodeUtil n2:nodes){
              if (n2.getPid().equals(n1.getId())){
                  n1.getChildren().add(n2);
              }
            }
        }
        return treeNode;
    }
    /**
     * 加载菜单管理的左边的数据展示在前台tree,使用layui+list数据格式
     * 依靠parentId
     */
    @RequestMapping("/loadMenuManagerLeftTreeJson")
    public DataGridViewUtil loadMenuManagerLeftTreeJson(MenuVo menuVo){
        //只查询可用的
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Menu> list=this.menuService.queryAllMenuForList(menuVo);
        List<TreeNodeUtil> nodes= new ArrayList<>(10);
        //把list里面的数据放到nodes
        for (Menu menu : list) {
            Integer id=menu.getId();
            Integer pid=menu.getPid();
            String title=menu.getTitle();
            String icon=menu.getIcon();
            String href=menu.getHref();
            //是否展开,前台的dtree接收true false所以需要转换
            Boolean spread=menu.getSpread().equals(SysConstant.SPREAD_TRUE)?true:false;
            nodes.add(new TreeNodeUtil(id, pid, title, icon, href, spread));
        }
        //将list的数据变成Object
        return new DataGridViewUtil(nodes);
    }
    /**
     * 加载不同菜单项对应的不同的表格数据
     * 菜单列表返回DataGridView
     * MenuVo需要两个分页参数
     */
    @RequestMapping("/loadAllMenu")
    public DataGridViewUtil loadAllMenu(MenuVo menuVo) {
        System.out.println("id:"+menuVo.getId());
        return this.menuService.queryAllMenu(menuVo);
    }

}