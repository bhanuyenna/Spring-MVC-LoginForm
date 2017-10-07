<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Batch Successful</title>
<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<script type="text/javascript">
function registerUser(){
	
}


</script>
<body>
	You have successfully save the batch in.
	<font color="green"><h1>Welcome to BatchController !</h1></font>


	
		<table class="tg">
			
	 	<c:if test="${!empty msg}">
	 	<tr>
				<th width="40">BatchId</th>
				<th width="80">Program</th>
				<th width="80">Trainer Name</th>
				<th width="80">Course</th>
				<th width="40">Student Count</th>
				<th width="120">Created Date</th>
				<th width="120">Updated Date</th>
			</tr>
			<c:forEach items="${msg}" var="batch">
			<tr><td>
			<a href ="/Spring-MVC-LoginForm/student/${batch.batchId}">${batch.batchId}</a></td>
			<td>${batch.program}</td>
			<td>${batch.trainerName}</td>
			<td>${batch.course}</td>
			<td>${batch.studentCount}</td>
			<td>${batch.createdDate}</td>
			<td>${batch.updatedDate}</td>
			</tr>
			</c:forEach>	
			<c:if test="${batch.isAdmin.equals(true)}">
			<a href ="/Spring-MVC-LoginForm/register">Register User</a></td>
			<a href ="/Spring-MVC-LoginForm/batch">Register Batch</a></td>		
			</c:if>			
			</c:if>
		</table>
	


</body>
</html>