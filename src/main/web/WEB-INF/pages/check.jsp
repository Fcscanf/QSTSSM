<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2019-07-31/0031
  Time: 下午 22:54
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
    <title>访问次数</title>
</head>
<body>
<h3>session中记录的访问次数：${count}</h3>
</body>
</html>
