<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/8/6
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="register.do" method="post">
    账号：<input type="text" name="username" required value="${sessionScope.user.username == null ? "" : sessionScope.user.username}">
    <span>${message == null ? "" : message}</span><br>
    密码：<input type="password" name="password" required value="${sessionScope.user.password == null ? "" : sessionScope.user.password}"><br>
    邮箱：<input type="email" name="email" required value="${sessionScope.user.email == null ? "" : sessionScope.user.email}"><br>
    手机号：<input type="tel" name="telephone" required value="${sessionScope.user.telephone == null ? "" : sessionScope.user.telephone}"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
