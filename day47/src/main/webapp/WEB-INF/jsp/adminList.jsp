<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员信息</title>
</head>
<body>
<h1>管理员信息</h1>
<a href="${pageContext.request.contextPath}/register.do"><input type="button" value="添加管理员"/></a>
<a href="${pageContext.request.contextPath}/logout.do"><input type="button" value="登出"/></a><br>
<form action="${pageContext.request.contextPath}/findByOption.do" method="post">
    <input type="number" name="id" value="${adminOption.id}" placeholder="请输入ID"/>
    <input type="text" name="username" value="${adminOption.username}" placeholder="请输入用户名"/>
    <input type="text" name="password" value="${adminOption.password}" placeholder="请输入密码"/>
    <input type="email" name="email" value="${adminOption.email}" placeholder="请输入邮箱"/>
    <input type="tel" name="telephone" value="${adminOption.telephone}" placeholder="请输入手机号"/>
    <input type="submit" value="查询"/>
</form>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th>手机号</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${adminList}" var="admin">
            <tr>
                <td>${admin.id}</td>
                <td>${admin.username}</td>
                <td>${admin.password}</td>
                <td>${admin.email}</td>
                <td>${admin.telephone}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/adminUpd.do?id=${admin.id}"><input type="button" value="编辑"/></a>
                    <a href="${pageContext.request.contextPath}/adminDel.do?id=${admin.id}"><input type="button" value="删除"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
