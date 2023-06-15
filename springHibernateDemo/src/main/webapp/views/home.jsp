<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
		</tr>
		<c:forEach items="${listCate}" var="cate">
		
		<tr>
			<td>${cate.cateId}</td>
			<td>${cate.cateName}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>