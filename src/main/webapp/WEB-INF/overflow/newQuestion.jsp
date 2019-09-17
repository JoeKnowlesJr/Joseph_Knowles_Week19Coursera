<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Question</title>
	</head>
	<body>		
		<form method="post" action="/overflow"><button class="btn-top" type="submit">Dojo OverFlow Home</button></form>
		<h1>What is your question?</h1>
		<form id="qForm" method="post">
			<table><tbody>
				<tr>
					<td>Question:</td>
					<td><textarea rows="4" cols="50" name="question" form="qForm" required></textarea></td>
				</tr>
				<tr>
					<td>Tags:</td>
					<td><input id="tags" type="text" name="tags" style="text-transform:lowercase;" onkeyup="javascript:this.value=this.value.toLowerCase();">></td>
				</tr>
				<tr><td></td><td><button formaction="/overflow/createQuestion">Submit</button></td></tr>
			</tbody></table>
		</form>
	</body>
</html>