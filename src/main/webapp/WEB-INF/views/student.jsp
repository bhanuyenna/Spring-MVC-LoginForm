<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/Spring-MVC-LoginForm/student/{id}/studentSave" method="POST" >

		<div align="center">
			<table>
			<tr>
					<td>Batch ID</td>
					<td><input type="text" name="batchId" /></td>
				</tr>
				<tr>
					<td>Student Name</td>
					<td><input type="text" name="studentName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" /></td>
				</tr>
				<tr>
					<td>ContactNo</td>
					<td><input type="text" name="contact" /></td>
				</tr>
				<tr>
					<td>Visa Status</td>
					<td><input type="text" name="visaStatus" /></td>
				</tr>
				<tr>
					<td>Cost</td>
					<td><input type="text" name="cost" /></td>
				</tr>
				<tr>
					<td>Paid</td>
					<td><input type="radio" name="paid"  value="yes"/>Yes</td>
					<td><input type="radio" name="paid"  value="no"/>No</td>
					<td><input type="radio" name="paid"  value="partially"/>Partially</td>
				</tr>
				<tr>
					<td>Mode</td>
					<td><input type="radio" name="mode"  value="cash"/>Cash</td>
					<td><input type="radio" name="mode"  value="card"/>Card</td>
					<td><input type="radio" name="mode"  value="check"/>Check</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" name="comments" /></td>
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