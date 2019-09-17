<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/homeindex.css">
		<title>Week 19</title>
	</head>
	<body>
		<div class="content">
			<h1>Week 19</h1>
			<div class="buttons">
				<form:form method="post">
					<button type="submit" formaction="/ninjadojo">Ninjas &amp; Dojos</button>
					<button type="submit" formaction="/prodcat">Products &amp; Categories</button>
					<button type="submit" formaction="/overflow">Dojo OverFlow</button>
				</form:form>
			</div>
		</div>
	</body>
</html>