<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2019-07-31/0031
  Time: 下午 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>文件上传</title>
</head>
<body>
<form action="uploadImage" method="post" enctype="multipart/form-data">
    选择图片：<input type="file" name="image" accept="image/*" /><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
