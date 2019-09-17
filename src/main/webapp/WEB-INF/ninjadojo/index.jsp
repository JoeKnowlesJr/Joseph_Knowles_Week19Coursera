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
		<title>Ninjas &amp; Dojos</title>
	</head>
	<body>
		<div class="content">
			<form:form method="get" action="/"><button class="btn-top" type="submit"><h1 id="title" onmouseover="changeText('HOME')" onmouseout="changeText('Ninjas &amp; Dojos')">Ninjas &amp; Dojos</h1></button></form:form>
			<form:form method="post">
				<div class="buttons">
					<button type="submit" formaction="ninjadojo/newNinja">New Ninja</button>
					<button type="submit" formaction="ninjadojo/newDojo">New Dojo</button>
					<button type="submit" formaction="ninjadojo/show">Show Dojos</button>
				</div>
			</form:form>
		</div>

	</body>
</html>