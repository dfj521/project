<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<a href="${ pageContext.request.contextPath }/book/1/abc">查询一本图书</a>
<a href="${ pageContext.request.contextPath }/book">查询全部图书</a>
<form action="${ pageContext.request.contextPath }/book" method="post">
    <input type="submit" value="post添加图书"/>
</form>

<form action="${ pageContext.request.contextPath }/book/1" method="post">
    <!-- 表示这是put请求 -->
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="put修改图书"/>
</form>

<form action="${ pageContext.request.contextPath }/book/1" method="post">
    <!-- 表示这是DELETE请求 -->
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="DELETE 删除图书"/>
</form>
</body>
</html>
