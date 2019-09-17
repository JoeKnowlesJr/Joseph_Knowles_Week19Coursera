<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Questions Dashboard</title>
		<style>
			button {
				background-color: white;
				border: none;
			}
			.btn-top {
				margin-bottom: 25px;
			}
			table, button {
				font-size: 25px;
			}
		</style>
	</head>
	<body>		
		<form method="post" action="/overflow"><input class="btn-top" type="submit" value='Dojo OverFlow Home'></form>
		<h4>Click on question to view</h4>
		<h1>Questions Dashboard</h1>
		<c:choose>
			<c:when test="${tagged == true}">
				<h3>Questions by tag: ${tag}</h3>
			</c:when>
			<c:otherwise>
				<h3>All Questions</h3>
			</c:otherwise>
		</c:choose>
		<div>
			<form method="post">
				<table>
					<thead>
						<tr>
							<th>Question</th>
							<th>Tags</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${questions}" var="q">
							<tr>
								<td><button formaction="/overflow/show/${q.getId()}">${q.getQuestion()}</button></td>
								<td>${q.getTagsDisplay()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
			<form method="post" action="/overflow/newQuestion"><input type="submit" value="New Question"></form>			
		</div>
	</body>
</html>