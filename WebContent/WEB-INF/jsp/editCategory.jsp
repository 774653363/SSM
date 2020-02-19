<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateCategory" method="post">
<input type="hidden" name="id" value="${category.id }"/><br>
分类名称:<input type="text" name="name" value="${category.name }" /><br>
<input type="submit" value="更新">
</form>
</body>
</html>