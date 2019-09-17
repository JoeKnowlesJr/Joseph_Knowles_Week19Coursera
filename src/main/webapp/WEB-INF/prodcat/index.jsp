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
		<title>Prod/Cat</title>
	</head>
	<body>
		<div class="content">
			<form method="get" action="/"><button class="btn-top" type="submit"><h1 id="title" onmouseover="changeText('HOME')" onmouseout="changeText('Products &amp; Categories')">Products &amp; Categories</h1></button></form>
			<div class="buttons">
				<form method="post"><button type="submit" formaction="prodcat/newProduct">New Product</button></form>
				<form method="post"><button type="submit" formaction="prodcat/newCategory">New Category</button></form>
				<form:form method="get"><button type="submit" formaction="prodcat/showProducts">Show Products</button></form:form>
				<form method="get"><button type="submit" formaction="prodcat/showCategories">Show Categories</button></form>
			</div>
		</div>
	</body>
</html>