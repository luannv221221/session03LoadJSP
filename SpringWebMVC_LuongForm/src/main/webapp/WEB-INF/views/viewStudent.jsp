<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student</title>
</head>
<body>
	<h1>View Student</h1>
		<table>
			<tr>
				<td>Student Id:</td>
				<td>${stu.stuId}</td>
			</tr>
			<tr>
				<td>Full Name:</td>
				<td>${stu.fullName}</td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					${stu.gender?"Male":"Female"}
				</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td>${stu.birthday}</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td>${stu.address}</td>
			</tr>
			<tr>
				<td>Class Name:</td>
				<td>
					${stu.className}
				</td>
			</tr>			
		</table>
		<a href="initInsertStudent">Back</a>
</body>
</html>