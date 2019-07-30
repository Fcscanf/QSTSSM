<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2019-07-22/0022
  Time: 下午 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <link href="<%=basePath%>/bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=basePath%>jquery-3.3.1/jquery-3.3.1.min.js"></script>
    <base href="<%=basePath%>">
    <title>用户注册</title>
</head>
<body background="img/DancingRibbon.jpg">
<div align="right">
    已有帐号？请点击<a href="<%=basePath%>jsp/userlogin.jsp">登录</a>进入系统
</div>
<div align="center" style="margin-top: 70px">
    <h2>用户注册</h2>
</div>
<div class="text-danger" align="center">
    <h5>${msg}</h5>
</div>
<div align="center" style="margin-top: 30px" class="container">
    <div style="align-self: center">
        <form action="<%=basePath%>reg.do" method="post">
            UserName:<input type="text" name="username"/></br>
            PassWord:&nbsp;<input type="password" name="password"/></br>
            <input type="reset" value="重置">
            <input type="submit" value="注册">

        </form>
    </div>
</div>
</body>
</html>
