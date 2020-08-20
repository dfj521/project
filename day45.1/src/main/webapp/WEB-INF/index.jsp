<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/8/11
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/option" method="post">
    <input type="text" name="username" value="${option.username}" placeholder="请输入用户名"/>
    <input type="text" name="password" value="${option.password}" placeholder="请输入密码"/>
    <input type="email" name="email" value="${option.email}" placeholder="请输入邮箱"/>
    <input type="tel" name="telephone" value="${option.telephone}" placeholder="请输入电话"/>
    <input type="submit" value="查询"/>
    <a href="${pageContext.request.contextPath}/logout"><input type="button" value="登出"></a>
</form>

<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>username</th>
        <th>password</th>
        <th>email</th>
        <th>telephone</th>
        <th>option</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.telephone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/delInfo?id=${user.id}"><input type="button" value="删除"/></a>
                <a href="${pageContext.request.contextPath}/updInfo?id=${user.id}"><input type="button" value="编辑"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
