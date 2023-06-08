<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student Form</title>
</head>
<body>
	<h1>Insert Student</h1>
	<form:form action="insertStudent" method="post" modelAttribute="s">
		<table>
			<tr>
				<td>Student Id:</td>
				<td><form:input path="stuId"/></td>
			</tr>
			<tr>
				<td>Full Name:</td>
				<td><form:input path="fullName"/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<form:radiobutton path="gender" value="true" label="Male"/>
					<form:radiobutton path="gender" value="false" label="Female"/>
				</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><form:input type="date" path="birthday"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:textarea path="address"/> </td>
			</tr>
			<tr>
				<td>Class Name:</td>
				<td>
					<form:select path="className">
						<form:option value="">Choose</form:option>
						<form:option value="JW2010LM">JW2010LM</form:option>
						<form:option value="JW2011LM">JW2011LM</form:option>
						<form:option value="JW2012LM">JW2012LM</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Insert"/>
					<input type="reset" value="Clear"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>