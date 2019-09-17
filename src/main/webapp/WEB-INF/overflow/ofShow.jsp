<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Question ${question.getId()}</title>
		<style>
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
		<h1>${question.getQuestion()}</h1>
		<div style="display: inline;">
			<form method="post">
				<h3>Tags:</h3>
				<c:forEach items="${question.getTags()}" var="t">
					<button formaction="/overflow/tags/${t.getId()}">${t.getSubject()}</button>					
				</c:forEach>
			</form>
		</div>
		<div style="display: inline;">
			<div>
				<table>
					<thead>
						<tr>
							<th>Answers</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${question.getAnswers()}" var="a">
							<tr><td>${a.getAnswer()}</td></tr>
						</c:forEach>
					</tbody>
				</table>			
			</div>
			<div>
				<h2>Add your answer:</h2>
				<form id="aForm" method="post" action="/overflow/answerQuestion">
						<textarea rows="4" cols="50" name="answer" form="aForm"></textarea>
						<input type="hidden" name="q_id" value="${question.getId()}">
						<button>Answer</button>
				</form>
			</div>
		</div>
	</body>
</html>