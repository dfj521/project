<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addOneStudent.do" method="post">
    姓名：<input type="text" name="name" placeholder="请输入姓名" required/>
    年龄：<input type="number" name="age" placeholder="请输入年龄" required/>
    年级：<select name="classNo">
            <c:forEach items="${classGradeList}" var="classGrade">
                <option value="${classGrade.id}">${classGrade.grade}</option>
            </c:forEach>
         </select>
    <input type="submit" value="添加"/>
</form>
</body>
</html>
