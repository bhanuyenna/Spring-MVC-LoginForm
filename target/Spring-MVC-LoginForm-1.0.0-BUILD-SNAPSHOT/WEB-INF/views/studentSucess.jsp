<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Batch Successful</title>
<title>Person Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<script type="text/javascript">
	function registerUser() {

	}
</script>
<body>
	You have successfully save the batch in.
	<font color="green"><h1>Welcome to BatchController !</h1></font>



	<table class="tg">

		<c:if test="${!empty msg}">
			<tr>
				<th width="40">StudentId</th>
				<th width="40">BatchId</th>
				<th width="80">Student Name</th>
				<th width="80">Email</th>
				<th width="80">Contact No</th>
				<th width="40">Visa Status</th>
				<th width="40">Cost</th>
				<th width="40">Paid</th>
				<th width="40">Mode</th>
				<th width="120">Comments</th>
			</tr>
			<c:forEach items="${msg}" var="student">
				<tr>
					<td></td>
					<td>${student.id}</td>
					<td>${student.batchId}</td>
					<td>${student.studentName}</td>
					<td>${student.email}</td>
					<td>${student.contact}</td>
					<td>${student.visaStatus}</td>
					<td>${student.cost}</td>
					<td>${student.paid}</td>
					<td>${student.mode}</td>
					<td>${student.commentst}</td>
				</tr>
			</c:forEach>

		</c:if>
	</table>


</body>
</html>