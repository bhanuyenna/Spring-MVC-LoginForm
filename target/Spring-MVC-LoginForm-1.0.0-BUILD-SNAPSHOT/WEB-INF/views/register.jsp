<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
	<form:form action="/Spring-MVC-LoginForm/submitForm" method="POST" >

		<div align="center">
			<table>
			<tr>
					<td>email</td>
					<td><input type="email" name="email" /></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>Created Date</td>
					<td><input type="Date" name="createdDate" /></td>
				</tr>
				<tr>
					<td>Updated Date</td>
					<td><input type="Date" name="updatedDate" /></td>
				</tr>
				<tr>
					<td>Admin</td>
					<td><input type="radio" name="isAdmin" value="true" />True</td>
					<td><input type="radio" name="isAdmin" value="false" checked="checked">False</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
</body>
</html>