<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
		function  add(){
			window.location.href="${pageContext.request.contextPath}/addCategoryUI";
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
<table align="center" border="1" cellspacing="0">
	<tr>
        <td>id</td>
        <td>name</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${cs }" var="c">
    	<tr>
        <td>${c.id }</td>
        <td>
        	<a href="listProduct?cid=${c.id}">${c.name }</a>
        </td>
        <td>
			<a href="editCategory?id=${c.id}">edit</a>
		</td>
        <td>
			<a href="deleteCategory?id=${c.id}">delete</a>
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
	<button onclick="add()">添加分类</button>
	<br>
	<form action="listCategory" method="post" id="form1">
		<input type="hidden" name="pageNum" value="${page.pageNum}" id="pageNum">
		<input type="text" name="name" value="${category.name}">
		<input type="submit" value="模糊查询">
	</form>
</div>
</body>
</html>