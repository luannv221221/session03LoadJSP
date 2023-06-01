<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student Page!</title>
</head>
<body>
	<h1>UPDATE STUDENT</h1>
	<h3 style="color:red">${err }</h3>
	
	<form action="UpdateStudent" method="post">
		<table>
			<tr>
				<td>Student Id:</td>
				<td><input type="text" name="stuId" value="${s.stuId}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Full Name:</td>
				<td><input type="text" name="fullName" value="${s.fullName }"/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<c:if test="${s.gender}">
						<input type="radio" name="gender" value="true" checked="checked"/>Male
						<input type="radio" name="gender" value="false"/>Female
					</c:if>
					<c:if test="${!s.gender}">
						<input type="radio" name="gender" value="true"/>Male
						<input type="radio" name="gender" value="false" checked="checked"/>Female
					</c:if>
				</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="date" name="birthday" value="${s.birthday}"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea name="address">${s.address}</textarea></td>
			</tr>
			<tr>
				<td>Class Name</td>
				<td><input type="text" name="className" value="${s.className}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"/>
				<input type="reset" value="Clear"/></td>
			</tr>
		</table>
	</form>
</body>
</html>