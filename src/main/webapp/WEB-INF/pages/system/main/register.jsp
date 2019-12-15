<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2019/12/13
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/wlyLogo.png">
    <link rel="stylesheet" href="${whContextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${whContextPath}/resources/css/public.css" media="all"/>
</head>
<body class="loginBody">

<form class="layui-form" id="registFrm" method="post" action="${whContextPath}/log/toRegister.action"
      style="height: 450px;">
    <div class="login_face">
        <input type="hidden" name="userHeadPortrait" id="userHeadPortrait" value="downloadFile.action?path=default/wlyLogo.png">
        <img src="${pageContext.request.contextPath}/resources/images/wlyLogo.png"
             class="layui-upload-img" id="demo1">
    </div>
    <div class="layui-form-item" style="text-align: center">
        <button type="button" class="layui-btn layui-btn-xs" id="test1">上传头像</button>
    </div>
    <div class="layui-form-item input-item">
        <label class="layui-form-label">用户名</label>
        <input type="text" placeholder="请输入用户名" autocomplete="off" name="userName" id="userName" class="layui-input"
               lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label class="layui-form-label">密码</label>
        <input type="password" placeholder="请输入密码" autocomplete="off" name="userPwd" class="layui-input"
               lay-verify="required">
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="userSex" value="1" title="男">
            <input type="radio" name="userSex" value="0" title="女" checked>
        </div>
    </div>
    <div class="layui-form-item input-item">
        <label class="layui-form-label" >电话</label>
        <input type="text" placeholder="请输入电话号码" name="userPhone" class="layui-input"
               lay-verify="required" oninput="value=value.replace(/[^\d]/g,'')">
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-block" lay-filter="regist" lay-submit>注册</button>
    </div>
    <div class="layui-form-item">
        <a class="layui-btn layui-block layui-btn-primary" href="${whContextPath}/log/toLoginPage.action">登录</a>
    </div>
    <div class="layui-form-item layui-row" style="text-align: center;color: red;" id="userNameLabel">
    </div>
</form>
<script type="text/javascript" src="${whContextPath}/resources/layui/layui.js"></script>
<script type="text/javascript" src="${whContextPath}/resources/js/cache.js"></script>
<script type="text/javascript">
    layui.use(['form', 'layer', 'jquery', 'upload'], function () {
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            upload = layui.upload;
        //打开添加图片页面
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            , url: '${whContextPath}/upload/upload03.action'
            ,accept:'images' //只支持图片
            ,acceptMime:'image/*' //只显示图片文件
            ,auto:true  //自动上传
            ,field:'mf' //设定文件域的字段名,与后台的MultipartFile的参数名对应
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res,index,upload) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                if (res.code==0) {
                    //上传成功
                    layer.msg("上传成功");
                    //
                    console.log(res.data.src);
                    $("#userHeadPortrait").val(res.data.src);
                    alert($("#userHeadPortrait").val());
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#userNameLabel');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }

        });

        //用户名是否重复处理
        $("#userName").blur(function () {
                //清除上次的文本数据
                $("#userNameLabel").html("<font></font>");
                var userName = $(this).val();
                var url = "${whContextPath}/log/toRegisterHanding.action";
                $.post(url, {userName: userName}, function (str) {
                    if (str == "true") {
                        $("#userNameLabel").html("<font>用户名已存在</font>");
                    }
                })
            }
        );
        //注册按钮
        form.on("submit(regist)", function (data) {
            $(this).text("注册中...").attr("disabled", "disabled").addClass("layui-disabled");
            setTimeout(function () {
                $("#registFrm").submit();
            }, 1500);
            return false;
        });

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

