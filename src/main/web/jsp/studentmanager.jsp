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
    <link href="<%=basePath%>bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=basePath%>jquery-3.3.1/jquery-3.3.1.min.js"></script>
    <base href="<%=basePath%>">
    <title>学生管理</title>
    <script>
        <%--按条件检索--%>
        function query() {
            var select = $("select").val();
            var key = document.getElementById("key").value;
            window.location.href = "<%=basePath%>query.action?select="+select+"&value="+key;
        }

        <%--分页查询-下一页--%>
        function pageQueryNext() {
            var size = document.getElementById("size").value;
            window.location.href = "<%=basePath%>pageQuery.action?size="+size+"&option=next";
        }

        //分页查询-上一页
        function pageQueryPre() {
            var size = document.getElementById("size").value;
            window.location.href = "<%=basePath%>pageQuery.action?size="+size+"&option=pro";
        }

        //添加学生
        function addStu() {
            window.location.href = "<%=basePath%>jsp/addstu.jsp"
        }

        //删除学生
        function deleteStu(delId) {
            if (confirm("确认删除ID为【" + delId + "】的学生吗？")) {
                $.ajax({
                    url:"<%=basePath%>delete.action?id="+delId,
                    type:"post",
                    success:function (data) {
                        window.location.href = "<%=basePath%>pageQuery.action?size=5&option=0";
                    }
                })
            }
        }

        //修改学生信息
        function editStu(id) {
            if (confirm("确认修改学号【" + id + "】的学生吗？")) {
                window.location.href = "<%=basePath%>edit.action?id="+id;
            }

        }
    </script>
</head>
<body background="img/JadeFairyland.jpg">
<div align="center">
    <h3>学生信息管理</h3>
</div>

<%--检索功能检索框设计--%>
<div>
    <select>
        <option value="id" id="id">ID</option>
        <option value="name" id="name">Name</option>
        <option value="email" id="email">Email</option>
        <option value="phone" id="phone">Phone</option>
        <option value="qq" id="qq">QQ</option>
    </select>
    <input id="key" onfocus="javascript:if(this.value=='请输入查询的内容')this.value='';" value="请输入查询的内容">
    <button onclick="query()">Search</button>
</div>
<div align="right">
    <button class="btn-warning" onclick="addStu()">添加学生信息</button>
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
                <td><a onclick="editStu(${student.id})">编辑</a>
                    <a onclick="deleteStu(${student.id})">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--分页设计--%>
<div align="right">
    每页显示<input id="size" value="4" width="10px">条数据<button onclick="pageQueryPre()">上一页</button><button onclick="pageQueryNext()">下一页</button>
</div>
</body>
</html>
