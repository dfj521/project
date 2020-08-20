<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>regist</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/registeredSuccessfully" method="post">
    用户名：<input type="text" name="username" required>
    <span>${message == null ? "" : message}</span><br>
    密码：<input type="password" name="password" required><br>
    邮箱：<input type="email" name="email" required><br>
    电话：<input type="tel" name="telephone" required><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
