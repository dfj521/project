<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form表单</title>
</head>

<body>

    <form action="${pageContext.request.contextPath}/hello1.do" method="post">
        姓名：<input name="username"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>

</body>

</html>
