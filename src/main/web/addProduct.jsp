<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2019-07-31/0031
  Time: 下午 22:44
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
    <title>添加产品</title>
</head>
<body>
<form action="addProduct" method="post">
    产品名称：<input type="text" name="name" value=""><br>
    产品价格：<input type="text" name="price" value=""><br>
    <input type="submit" value="增加商品">
</form>
</body>
</html>
