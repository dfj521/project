<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/8/11
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update">
    <input type="hidden" name="id" value="${user.id}"/>
    用户名: <input type="text" name="username" value="${user.username}" required/>
    密码: <input type="password" name="password" value="${user.password}" required/>
    邮箱: <input type="email" name="email" value="${user.email}" required/>
    电话: <input type="tel" name="telephone" value="${user.telephone}" required/>
    <input type="submit" value="确认"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/list"><input type="button" value="取消"/></a>
</form>
</body>
</html>
