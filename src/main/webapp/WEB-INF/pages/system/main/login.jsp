<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2019/11/15
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录-考试系统</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/wlyLogo.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
</head>
<body class="loginBody" >
<form class="layui-form" id="loginFrm" method="post" action="${pageContext.request.contextPath}/log/toIndexHanding.action" style="height: 370px;">
    <div class="login_face"><img src="${pageContext.request.contextPath}/resources/images/wlyLogo.png"
                                 class="userAvatar"></div>
    <div class="layui-form-item input-item">
        <label class="layui-form-label">用户名</label>
        <input type="text" placeholder="请输入用户名" autocomplete="off" name="userName" class="layui-input"
               lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label class="layui-form-label">密码</label>
        <input type="password" placeholder="请输入密码" autocomplete="off" name="userPwd" class="layui-input"
               lay-verify="required">
    </div>
    <div class="layui-form-item input-item" id="imgCode">
        <label for="code">验证码</label>
        <input type="text" placeholder="请输入验证码" value="123" autocomplete="off" id="code" class="layui-input"
               name="code">
        <!-- 之前图片使用的是静态图片 resources/images/code.jpg-->
        <!-- 重新请求图片资源 -->
        <img src="${pageContext.request.contextPath}/log/getCode.action" onclick="this.src=this.src+'?'">
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-block" lay-filter="login" lay-submit>登录</button>
    </div>
    <div class="layui-form-item">
        <a class="layui-btn layui-block layui-btn-primary" href="${whContextPath}/log/toRegisterPage.action">注册</a>
    </div>
    <div class="layui-form-item layui-row" style="text-align: center;color: red;">
        ${error}
    </div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cache.js"></script>
<script type="text/javascript">
    layui.use(['form', 'layer', 'jquery'], function () {
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;
        //登录按钮
        form.on("submit(login)", function (data) {
            $(this).text("登录中...").attr("disabled", "disabled").addClass("layui-disabled");
            setTimeout(function () {
                $("#loginFrm").submit();
            }, 1000);
            return false;
        });
        //

        //表单输入效果
        $(".loginBody .input-item").click(function (e) {
            e.stopPropagation();
            $(this).addClass("layui-input-focus").find(".layui-input").focus();
        });
        $(".loginBody .layui-form-item .layui-input").focus(function () {
            $(this).parent().addClass("layui-input-focus");
        });
        $(".loginBody .layui-form-item .layui-input").blur(function () {
            $(this).parent().removeClass("layui-input-focus");
            if ($(this).val() != '') {
                $(this).parent().addClass("layui-input-active");
            } else {
                $(this).parent().removeClass("layui-input-active");
            }
        })

    })
</script>
</body>
</html>
