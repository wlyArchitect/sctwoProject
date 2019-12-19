<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2019/12/19
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>交友模块</title>
    <link rel="stylesheet" href="${whContextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${whContextPath}/resources/css/public.css">
    <script src="${whContextPath}/resources/layui/layui.js"></script>
    <style>
        *{
            padding: 0;
            margin: 0 auto!important;
        }
        #head{
            width:350px;
            height: 100px;
            border:1px solid red;
            background:linear-gradient(to right, #00E27D, #00ADF1);
            z-index: 1;
        }
        #imgD>img{
            width:60px;
            height: 50px;
            position: relative;
            top:20px;
        }
        #imgD>span{
            position: relative;
            top:25px;
        }
    </style>
</head>
<body>
<!-- 头部部分 -->
<div id="head">
    <div id="imgD">
        <img src="${whContextPath}/upload/${user.userHeadPortrait}" class="layui-nav-img">
        <span>${user.userName}</span>
    </div>
</div>
<!-- 主要内容 -->
<div class="layui-tab layui-tab-card" style="width: 350px;height:600px; background-color: #ecfafb">
    <ul class="layui-tab-title">
        <li class="layui-this">我的好友</li>
        <li >聊天信息</li>
        <li>好友动态</li>
    </ul>
    <div class="layui-tab-content" style="width:100%;position: relative;left:-10px;top:-10px;">
        <div class="layui-tab-item layui-show" >
            <!-- lay-accordion 属性只显示一个面板 -->
            <div class="layui-collapse" style="width: 100%;">
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">我的好友</h2>
                    <!-- 可以通过lay-show显示 -->
                    <div class="layui-colla-content">内容区域1</div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">个人资料</h2>
                    <div class="layui-colla-content">内容区域2</div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">黑名单</h2>
                    <div class="layui-colla-content">内容区域3</div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">可能认识的人</h2>
                    <div class="layui-colla-content">内容区域4</div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">新的朋友</h2>
                    <div class="layui-colla-content">内容区域5</div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">消息中心</h2>
                    <div class="layui-colla-content">内容区域6</div>
                </div>
            </div>
        </div>
        <div class="layui-tab-item">内容2</div>
        <div class="layui-tab-item">内容3</div>
    </div>
</div>
</body>
<script>
    //注意：选项卡,折叠面板 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        //…

    });
</script>
</html>
