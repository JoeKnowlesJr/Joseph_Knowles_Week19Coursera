<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/dashboard.css">
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
			</thead>
			<tbody>
				<c:forEach items="${ninjas}" var="n">
					<tr>
						<td>${n.getFirstName()}</td>
						<td>${n.getLastName()}</td>
						<td>${n.getAge()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>