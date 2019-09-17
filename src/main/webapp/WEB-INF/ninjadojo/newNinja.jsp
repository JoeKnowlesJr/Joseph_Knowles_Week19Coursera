<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Ninja</title>
	</head>
	<body>
		<h1>New Ninja</h1>
		<form:form method="post" action="/ninjadojo/createNinja" modelAttribute="nfo">
			<table><tbody>
				<tr>
					<td>Dojo:</td>
					<td>
						<form:select path="dojo_id">
							<c:forEach items="${dojos}" var="d">
								<form:option value="${d.getId()}">${d.getName()}</form:option>
							</c:forEach>
						</form:select>					
					</td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><form:input type="text" name="firstName" path="firstName"></form:input></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input type="text" name="lastName" path="lastName"></form:input></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input type="number" name="age" path="age"></form:input></td>
				</tr>							
				<tr>
					<td></td>
					<td><input type="submit" value="Create"></td>
				</tr>
			</tbody></table>		
		</form:form>
	</body>
</html>