<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生基本信息</title>
</head>
<body>
<h1>学生基本信息</h1>
<a href="${pageContext.request.contextPath}/addStudent.do"><input type="button" value="添加学生信息"/></a>
<a href="${pageContext.request.contextPath}/logout.do"><input type="button" value="登出"/></a><br>
<form action="${pageContext.request.contextPath}/findByStudentOption.do" method="post">
    <input type="number" name="id" value="${studentOption.id}" placeholder="请输入学号"/>
    <input type="text" name="name" value="${studentOption.name}" placeholder="请输入姓名"/>
    <input type="number" name="age" value="${studentOption.age}" placeholder="请输入年龄"/>
    <input type="number" name="classNo" value="${studentOption.classNo}" placeholder="请输入班号"/>
    <input type="submit" value="查询"/>
</form>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>年级</th>
        <th>教室</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.classGrade.grade}</td>
            <td>${student.classGrade.classroom}</td>
            <td><a href="${pageContext.request.contextPath}/delStudent.do?id=${student.id}"><input type="button" value="删除"/></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
