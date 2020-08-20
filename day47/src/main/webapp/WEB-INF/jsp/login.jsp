<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/8/13
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginCheck.do" method="post">
    账号: <input type="text" name="account" placeholder="用户名/邮箱/手机号" required/>
    <span>${usernameError == null ? "" : usernameError}</span><br>
    密码: <input type="password" name="password" placeholder="请输入您的密码" required/>
    ${passwordError == null ? "" : passwordError}<br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
