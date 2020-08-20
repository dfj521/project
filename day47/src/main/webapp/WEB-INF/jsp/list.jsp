<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统</title>
</head>
<body>
    <table>
        <tr>
            <th>学生管理系统&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/logout.do">登出</a></th>
        </tr>
        <tr>
            <td><a href="${pageContext.request.contextPath}/studentList.do">学生基本信息</a></td>
        </tr>
        <tr>
            <td><a href="${pageContext.request.contextPath}/adminList.do">管理员信息</a></td>
        </tr>
    </table>
</body>
</html>
