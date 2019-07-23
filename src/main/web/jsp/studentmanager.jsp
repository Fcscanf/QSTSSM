<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2019-07-22/0022
  Time: 上午 11:50
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
    <title>学生管理</title>
</head>
<body background="img/JadeFairyland.jpg">
<div align="center">
    <h3>学生信息管理</h3>
</div>

<%--检索功能检索框设计--%>
<div>
    <select>
        <option value="" name="name">Name</option>
        <option value="" name="email">Email</option>
        <option value="" name="phone">Phone</option>
        <option value="" name="qq">QQ</option>
    </select>
    <input onfocus="javascript:if(this.value=='请输入查询的内容')this.value='';" value="请输入查询的内容">
    <button>Search</button>
</div>

<%--主体信息设计--%>
<div align="center">
    <table width="80%" border="1px" align="center" cellpadding="0"
           cellspacing="0" class="table table-secondary">
        <thead>
        <tr align="center">
            <th width="10%" scope="col">编号</th>
            <th width="15%" scope="col">姓名</th>
            <th width="20%" scope="col">邮箱</th>
            <th width="15%" scope="col">手机</th>
            <th width="15%" scope="col">QQ</th>
            <th width="20%" scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr align="center">
                <td scope="row">${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.phone}</td>
                <td>${student.qq}</td>
                <td><a href="edit.action?param=0&id=${student.id}">编辑</a> <a
                        href="delete.action?id=${student.id}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--分页设计--%>
<div align="right">
    每页显示<input width="10px">条数据
</div>
</body>
</html>
