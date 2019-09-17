<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Product</title>
	</head>
	<body>
		<h1>New Product</h1>
		<form:form modelAttribute="pfo" action="/prodcat/createProduct">
			<table><tbody>
				<tr>
					<td>Name:</td>
					<td><form:input type="text" path="name" required="true"></form:input></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:input type="text" path="description" required="true"></form:input></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input type="number" path="price" step="0.01" required="true"></form:input></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create"></td>
				</tr>
			</tbody></table>		
		</form:form>
	</body>
</html>