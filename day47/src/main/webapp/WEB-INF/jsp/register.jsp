<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/8/13
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registerCheck.do" method="post">
    用户名: <input type="text" name="username" placeholder="请输入用户名" required/>
    <span>${usernameError == null ? "" : usernameError}</span><br>
    密码: <input type="password" name="password" placeholder="请输入密码" required/><br>
    邮箱: <input type="email" name="email" placeholder="请输入邮箱" required/><br>
    电话: <input type="tel" name="telephone" placeholder="请输入手机号" required/><br>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
