<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2019/12/12
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户登录</title>
    <link rel="stylesheet" href="${whContextPath}/resources2/css2/ele-index.css">
</head>
<style>
    html,
    body {
        height: 100%;
        text-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
        background: aliceblue;

    }
    #app {
        height: inherit;
        margin: 0 auto;
    }
    #ele-form {
        box-shadow: 0 5px 8px rgba(0, 0, 25, .1);
        background-color: #ffffff;
        border-radius: 5px;
    }
</style>
<body>
<div id="app">
    <el-container>
        <el-header></el-header>
        <el-main height="600px">
            <!-- Main content -->
            <el-form ref="form" :model="form" label-width="80px" :rules="rules">
                <el-row>
                    <el-col :span="6" :offset="9" id="ele-form">
                        <div style="margin-top: 20px;padding:0 20px;">
                            <el-form-item label="账号" prop="name">
                                <el-input v-model="form.name" prefix-icon="el-icon-user" placeholder="姓名" clearable>
                                </el-input>
                            </el-form-item>
                            <%--<el-form-item label="邮箱" prop="email">
                                <el-input v-model="form.email" prefix-icon="el-icon-message" placeholder="邮箱" clearable>
                                </el-input>
                            </el-form-item>--%>
                            <el-form-item label="密码" prop="pwd">
                                <el-input v-model="form.pwd" prefix-icon="el-icon-lock" placeholder="密码" clearable>
                                </el-input>
                            </el-form-item>
                            <el-form-item label="验证码" prop="code">
                                <el-col :span="16">
                                    <el-input v-model="form.code" prefix-icon="el-icon-key" placeholder="验证码">
                                    </el-input>
                                </el-col>
                                <el-col :span=" 4" :offset="4">
                                    <span class="checkCode" @click="createCode">{{ checkCode}}</span>
                                </el-col>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('form')">登录</el-button>
                                <el-button>取消</el-button>
                            </el-form-item>
                        </div>
                    </el-col>
                </el-row>

                </el-row>
            </el-form>
        </el-main>
        <el-footer>
            <div id="my-footer">
            </div>
        </el-footer>
    </el-container>
</div>
</body>
<!-- import Vue before Element -->
<script src="${whContextPath}/resources2/js2/vue.js"></script>
<!-- import JavaScript -->
<script src="${whContextPath}/resources2/js2/lib/index.js"></script>
<script>
    new Vue({
        el: '#app',
        data: function () {
            return {
                form: {
                    name: '',
                    email: '',
                    pwd: '',
                    code: '',
                },
                checkCode: '',
                rules: {
                    name: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    /* email: [
                         { required: true, type: 'email', message: '请输入正确的邮箱', trigger: 'blur' },
                     ],*/
                    pwd: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    code: [
                        {required: true, message: '请输入验证码', trigger: 'blur'},
                    ]
                },
            }
        },
        mounted() {
            this.createCode();
        },
        methods: {
            createCode() {
                let code = '';
                const codeLength = 4;
                const random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
                for (let i = 0; i < codeLength; i++) {
                    let index = Math.floor(Math.random() * 36);
                    code += random[index];
                }
                this.checkCode = code;
            },
            submitForm(formName) {
                if (this.form.code != this.checkCode) {
                    this.$message({
                        message: "验证码错误，注意大写字母",
                        type: "warning"
                    });
                    this.createCode();
                    return false;
                }
                //ajax异步请求
                //异步请求
                var xhr = $.ajax(
                    {
                        type: "post",
                        url: "${whContextPath}/log/toIndex.action",
                        data: "uname",
                        async: false,
                    }).responseText;

                //请求完成后执行
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$message({
                            message: "欢迎登录",
                            type: "success"
                        });
                        //设置定时器等待1秒,再跳转
                        setTimeout(function () {
                            //跳转
                            window.location.href = "${whContextPath}/log/toIndex.action";
                            return true;
                        }, 900);
                    } else {
                        this.$message({
                            message: "登录失败",
                            type: "error"
                        });
                        return false;
                    }
                });
            },
        },
    })
</script>
</html>