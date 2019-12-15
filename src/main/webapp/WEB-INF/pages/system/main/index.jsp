<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2019/12/12
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试:主页</title>
    <link rel="stylesheet" href="${whContextPath}/resources/layui/css/layui.css">
    <script src="${whContextPath}/resources/layui/layui.js"></script>
    <style type="text/css">
        body {
            padding: 0;
            margin: 0 auto;
        }
        #footer {
            height: 75px;
            line-height: 25px;
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            background: #333;
            color: #fff;
            font-size: 12px;
            letter-spacing: 1px;
        }
    </style>
</head>
<body>
<!--
   导航条
     ul设置layui-nav-tree垂直
     li设置layui-this 当前
 -->
<ul class="layui-nav" lay-filter="navTop" >
    <li class="layui-nav-item" >
        <a href="javascript:;"><img src="${whContextPath}/upload/${user.userHeadPortrait}" class="layui-nav-img">${user.userName}</a>
        <dl class="layui-nav-child">
            <!-- 二级菜单 -->
            <dd><a href="javascript:;" id="logout">注销</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item layui-this" >
        <a href="javascript:;">考试</a>
        <dl class="layui-nav-child">
            <!-- 二级菜单 -->
            <dd><a href="javascript:;">开始考试</a></dd>
            <dd><a href="javascript:;">考试历史</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="javascript:;" id="lunTan">论坛</a></li>
    <li class="layui-nav-item"><a href="javascript:;">交友</a></li>
    <li class="layui-nav-item"><a href="javascript:;">学习</a></li>
    <li class="layui-nav-item"><a href="javascript:;" id="houTai">后台</a></li>
</ul>
<br>
<!-- 轮播图片 -->
<div class="layui-carousel" id="test1">
    <div carousel-item >
        <div>条目1</div>
        <div>条目2</div>
        <div>条目3</div>
        <div>条目4</div>
        <div>条目5</div>
    </div>
</div>
<!-- 底部 -->
<div id="footer">
    <span><b>组员:</b></span>
    <div>xxx xxx xxx</div>
    <span>Copyright © 2019 NewLife365
Powered by .NET Core 3.1.0 on Linux</span>
</div>
<script>
    //注意：导航 依赖 element 模块，否则无法进行二级菜单功能性操作
    layui.use(['layer','element','jquery'], function(){
        var $=layui.jquery;
        var layer = layui.layer;
        var element = layui.element;
        //一些事件监听
        // element.on('nav(navTop)', function(date){
        //     var text = date.text();
        //     layer.msg(text);
        //     if (text=="注销"){
        //         layer.confirm('你真的要退出吗?',{icon:3,title:'提示'},function (index) {
        //             layer.close(index);
        //         });
        //         return;
        //     }
        //     if (text=="后台"){
        //
        //         return;
        //     }
        //     if (text=="论坛"){
        //
        //         return;
        //     }
        // });
        //"注销"的监听
        $("#logout").click(function () {
            layer.confirm('你真的要退出吗?',{icon:3,title:'提示'},function (index) {
                //异步请求
                var xhr = $.ajax(
                    {
                        type: "post",
                        url: "${whContextPath}/log/toDeleteSession.action",
                        // data: "",
                        async: false,
                    });
                //请求完成后执行
                xhr.done(
                    window.location.href="${whContextPath}/log/toLoginPage.action"
                )
                //请求转发
                layer.close(index);
            })
        });
        $("#lunTan").click(function () {
            layer.msg("进入论坛中...");

        });
        $("#houTai").click(function () {
            layer.msg("进入后台中...");
            //刷新界面
            // location.reload();

        })
    });
    //轮播
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,height:'400px'
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
</script>
</body>
</html>