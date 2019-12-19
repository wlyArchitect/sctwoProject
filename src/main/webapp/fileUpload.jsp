<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2019/12/14
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${whContextPath}/upload/upload01.action"
      method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="mf">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
