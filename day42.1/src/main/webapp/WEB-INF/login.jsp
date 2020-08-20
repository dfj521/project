<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/8/6
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.do" method="post">
    账号：<input type="text" name="username" required value="${sessionScope.user.username == null ? "" : sessionScope.user.username}">
    <span>${message == null ? "" : message}</span><br>
    密码：<input type="password" name="password" required><br>
    <input type="submit" value="登录">
    <a href="${pageContext.request.contextPath}/toRegister.do"><input type="button" value="注册"></a>
</form>
</body>
</html>
