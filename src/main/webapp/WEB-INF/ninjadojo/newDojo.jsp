<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Dojo</title>
	</head>
	<body>
		<h1>New Dojo</h1>
		<form action="/ninjadojo/createDojo">
			<table><tbody>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create"></td>
				</tr>
			</tbody></table>		
		</form>
		<c:if test="${error == true}">
			<h2>Error!  Msg: ${msg}</h2>
		</c:if>
	</body>
</html>