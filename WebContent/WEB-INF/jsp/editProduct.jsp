<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateProduct" method="post">
<input type="hidden" name="category.id" value="${product.category.id }">
<input type="hidden" name="id" value="${product.id }"/><br>
商品名称:<input type="text" name="name" value="${product.name }" /><br>
商品价格:<input type="text" name="price" value="${product.price }" /><br>
<input type="submit" value="更新">
</form>
</body>
</html>