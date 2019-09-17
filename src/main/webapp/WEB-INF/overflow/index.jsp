<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/homeindex.css">
		<script src="week19.js"></script>
		<title>Dojo OverFlow</title>
	</head>
	<body>
		<div class="content">
			<form:form method="get" action="/"><button class="btn-top" type="submit"><h1 id="title" onmouseover="changeText('HOME')" onmouseout="changeText('Dojo OverFlow')">Dojo OverFlow</h1></button></form:form>
			<form:form method="post">
				<div class="buttons">
					<button type="submit" formaction="overflow/dash">Questions Dashboard</button>
					<button type="submit" formaction="overflow/newQuestion">New Question</button>
				</div>
			</form:form>
		</div>
	</body>
</html>