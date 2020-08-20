<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改管理员信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/adminUpdCheck.do" method="post">
    <input type="hidden" name="id" value="${admin.id}"/>
    用户名: <input type="text" name="username" value="${admin.username}" placeholder="请输入用户名" required/>
    <span>${usernameError == null ? "" : usernameError}</span><br>
    密码: <input type="password" name="password" value="${admin.password}" placeholder="请输入密码" required/><br>
    邮箱: <input type="email" name="email" value="${admin.email}" placeholder="请输入邮箱" required/><br>
    电话: <input type="tel" name="telephone" value="${admin.telephone}" placeholder="请输入手机号" required/><br>
    <input type="submit" value="确定"/>
</form>
</body>
</html>
