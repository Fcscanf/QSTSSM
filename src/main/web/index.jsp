<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2019-07-31/0031
  Time: 下午 19:59
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
    <title>Welcome</title>
</head>
<body>
<h1>${message}</h1>
</body>
</html>
