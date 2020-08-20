<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/8/11
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registerSuccess" method="post">
    用户名: <input type="text" name="username"/>
    <span>${message == null ? "" : message}</span><br>
    密码: <input type="password" name="password"/><br>
    邮箱: <input type="email" name="email"/><br>
    电话: <input type="tel" name="telephone"/><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
