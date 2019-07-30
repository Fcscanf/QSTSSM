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
    <script src="<%=basePath%>bootstrap-4.1.3-dist/js/bootstrap.js" rel="stylesheet"></script>
    <base href="<%=basePath%>">
    <title>学生管理</title>
    <script>
        <%--按条件检索--%>

        function query() {
            var select = $("select").val();
            var key = document.getElementById("key").value;
            window.location.href = "<%=basePath%>query.action?select=" + select + "&value=" + key;
        }

        <%--分页查询-下一页--%>

        function pageQueryNext() {
            var size = document.getElementById("size").value;
            window.location.href = "<%=basePath%>pageQuery.action?size=" + size + "&option=next";
        }

        //分页查询-上一页
        function pageQueryPre() {
            var size = document.getElementById("size").value;
            window.location.href = "<%=basePath%>pageQuery.action?size=" + size + "&option=pro";
        }

        //添加学生
        function addStu() {
            window.location.href = "<%=basePath%>jsp/addstu.jsp"
        }

        //删除学生
        function deleteStu(delId) {
            if (confirm("确认删除ID为【" + delId + "】的学生吗？")) {
                $.ajax({
                    url: "<%=basePath%>delete.action?id=" + delId,
                    type: "post",
                    success: function (data) {
                        window.location.href = "<%=basePath%>pageQuery.action?size=5&option=0";
                    }
                })
            }
        }

        //修改学生信息
        function editStu(id) {
            if (confirm("确认修改学号【" + id + "】的学生吗？")) {
                window.location.href = "<%=basePath%>edit.action?id=" + id;
            }

        }

        // 复选框的全选和全不选
        $(function() {
            $("#check_all").click(function() {
                $(":checkbox[name='check_item']").prop("checked", this.checked); // this指代的你当前选择的这个元素的JS对象
            });
        });

        //单选选满自动选择全选
        $(document).on("click",".check_item",function () {
            //判断当前选择的是否满足当前页元素个数
            var flag = $(".check_item:checked").length==$(".check_item").length;
            $("#check_all").prop("checked",flag);
        })

        //批量删除按钮添加事件
        function delBatchStu() {
            var stuNames = "";
            var del_ids = "";
            var size = document.getElementById("size").value;
            $('table input:checkbox:gt(0)').each(function(){
                if(this.checked==true){
                    stuNames += this.value + ',';
                    del_ids += this.id + '-';
                }
            });
            /* */
            // $.each($(".check_item:checked"), function () {
            //     stuNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
            //     //组装id
            //     del_ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
            // });
            //去除empNames多余的”,“
            stuNames = stuNames.substring(0, stuNames.length - 1);
            //去除员工id组装多余的”-“
            del_ids = del_ids.substring(0, del_ids.length - 1);
            if (confirm("确认删除【 " + stuNames + " 】吗？")) {
                //发送ajax请求进行删除
                $.ajax({
                    url: "<%=basePath%>delStuBatch.action?ids="+del_ids,
                    type: "post",
                    success: function (result) {
                        alert("你已成功删除【 " + stuNames + " 】的信息！");
                        //回到当前页
                        window.location.href = "<%=basePath%>pageQuery.action?option=0&size="+size;
                    }
                });
            }
        };
    </script>

    <style>
        a {
            color: black;
        }

        a:hover {
            color: red;
        }
    </style>

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
    <button class="btn-success" onclick="delBatchStu()">批量删除学生信息</button>
    <button class="btn-warning" onclick="addStu()">添加学生信息</button>
</div>

<%--主体信息设计--%>
<div align="center">
    <table width="80%" border="1px" align="center" cellpadding="0"
           cellspacing="0" class="table table-secondary">
        <thead>

        <tr align="center">
            <th width="5%"><input type="checkbox" id="check_all"/></th>
            <th width="5%" scope="col">编号</th>
            <th width="15%" scope="col">姓名</th>
            <th width="20%" scope="col">邮箱</th>
            <th width="15%" scope="col">手机</th>
            <th width="15%" scope="col">QQ</th>
            <th width="15%" scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr align="center">
                <td><input type='checkbox' name='check_item' id="${student.id}" value="${student.name}"/></td>
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
    每页显示<input id="size" value="4" width="10px">条数据
    <button onclick="pageQueryPre()">上一页</button>
    <button onclick="pageQueryNext()">下一页</button>
</div>
</body>
</html>
