<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
		function  add(){
			window.location.href="${pageContext.request.contextPath}/addProductUI?category.id=${category.id}";
			}
		function  page(pageNum){
			document.getElementById("pageNum").value=pageNum;
			document.getElementById("form1").submit();
		}
</script>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h3>
		<a href="${pageContext.request.contextPath}/listCategory">返回分类页面</a>
	</h3>
	<h3>当前分类:${category.name }</h3>
</div>
<table align="center" border="1" cellspacing="0">
	<tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${ps }" var="p">
    	<tr>
        <td>${p.id }</td>
        <td>
        	${p.name }
        </td>
        <td>${p.price }</td>
        <td>
			<a href="editProduct?id=${p.id}">edit</a>
		</td>
        <td>
			<a href="deleteProduct?id=${p.id}&category.id=${product.category.id}">delete</a>
		</td>
        </tr>
    </c:forEach>
</table>
<div align="center">
	<a href="#" onclick="page(1)">首页</a>
	<a href="#" onclick="page(${page.pageNum - 1 })">上一页</a>
	<a href="#"onclick="page(${page.pageNum + 1 })">下一页</a>
	<a href="#" onclick="page(${page.lastPage })">尾页</a>
</div>
<div align="center">
	<br>
	<button onclick="add()">添加商品</button>
	<br>
	<form action="listProductByCid" method="post" id="form1">
		<input type="hidden" name="category.id" value="${product.category.id}" id="id">
		<input type="hidden" name="pageNum" value="${page.pageNum}" id="pageNum">
		name:<input type="text" name="name" value="${product.name}"><br>
		price:<input type="text" name="price" value="${product.price}"><br>
		<input type="submit" value="模糊查询">
	</form>
</div>
</body>
</html>