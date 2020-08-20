<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
</head>
<body>
    <h1>欢迎您${sessionScope.user.username}进入主界面</h1>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <th>用户id</th>
            <th>用户账号</th>
            <th>用户密码</th>
            <th>用户邮箱</th>
            <th>用户电话</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.telephone}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/exit.do"><input type="button" value="登出"></a>
</body>
</html>
