<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Employees</title>
</head>
<body>
	<h2>List of Employees</h2>

	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>salary</th>
			<th>address</th>
		</tr>
		<c:forEach items="${requestScope.employees}" var="employee" >
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.salary}</td>
			<td>${employee.address}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>