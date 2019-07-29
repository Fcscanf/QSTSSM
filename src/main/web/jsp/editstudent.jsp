<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2019-07-23/0023
  Time: 上午 0:05
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
    <title>学生信息修改</title>
    <script>
        <%--为更新按钮添加点击事件--%>

        function btnUpdate() {
            var id = document.getElementById("id").value;
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var phone = document.getElementById("phone").value;
            var qq = document.getElementById("qq").value;
            $.post({
                url: "<%=basePath%>update.action",
                type: "post",
                data: {
                    "id": id,
                    "name": name,
                    "email": email,
                    "phone": phone,
                    "qq": qq
                },
                success: function (data) {
                    // TODO:完成修改后执行分页查询进入管理页面-查询是写死的
                    window.location.href = "<%=basePath%>pageQuery.action?size=5&option=0";
                }
            })
        };
    </script>
</head>
<body background="img/PureRhythm.jpg">
<div align="center">
    <h3>学生信息修改</h3>
</div>
<div>
    <table width="80px" border="1px" align="center" cellpadding="0"
           cellspacing="0" class="table table-secondary">
        <tr align="center">
            <td width="50%">学生ID</td>
            <td width="50%"><input value="${student.id}" name="id" id="id" disabled/></td>
        </tr>
        <tr align="center">
            <td width="50%">姓名</td>
            <td width="50%"><input value="${student.name}" name="name" id="name"/></td>
        </tr>
        <tr align="center">
            <td width="50%">邮箱</td>
            <td width="50%"><input value="${student.email}" name="email" id="email"/></td>
        </tr>
        <tr align="center">
            <td width="50%">手机</td>
            <td width="50%"><input value="${student.phone}" name="phone" id="phone"/></td>
        </tr>
        <tr align="center">
            <td width="50%">QQ</td>
            <td width="50%"><input value="${student.qq}" name="qq" id="qq"/></td>
        </tr>
        <tr align="center">
            <td width="50%"><input class="btn-danger" type="reset" value="重置"></td>
            <td width="50%"><input class="btn-info" onclick="btnUpdate()" type="button" value="修改" id="update"></td>
        </tr>
    </table>
</div>
</body>
</html>
