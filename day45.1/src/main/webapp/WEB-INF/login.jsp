<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/8/11
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/toIndex" method="post">
    用户名: <input type="text" name="username" required>
    <span>${message == null ? "" : message}</span><br>
    密码: <input type="password" name="password" required><br>
    <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/register"><input type="button" value="注册"></a>
</form>
</body>
</html>
