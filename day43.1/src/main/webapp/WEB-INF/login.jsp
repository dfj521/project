<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/index" method="post">
    用户名：<input type="text" name="username" required/>
    <span>${message == null ? "" : message}</span><br>
    密码：<input type="password" name="password" required/><br>
    <input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/user/regist"><input type="button" value="注册"/></a>
</form>
</body>
</html>
