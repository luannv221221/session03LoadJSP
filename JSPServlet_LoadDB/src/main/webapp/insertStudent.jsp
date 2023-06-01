<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student Page!</title>
</head>
<body>
	<h1>INSERT STUDENT</h1>
	<h3 style="color:red">${err }</h3>
	
	<form action="InsertStudent" method="post">
		<table>
			<tr>
				<td>Student Id:</td>
				<td><input type="text" name="stuId"/></td>
			</tr>
			<tr>
				<td>Full Name:</td>
				<td><input type="text" name="fullName"/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<input type="radio" name="gender" value="true"/>Male
					<input type="radio" name="gender" value="false"/>Female
				</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="date" name="birthday"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea name="address"></textarea></td>
			</tr>
			<tr>
				<td>Class Name</td>
				<td><input type="text" name="className"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Insert"/>
				<input type="reset" value="Clear"/></td>
			</tr>
		</table>
	</form>
</body>
</html>