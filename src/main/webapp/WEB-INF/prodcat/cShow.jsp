<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="css/cat.css">
		<script src="jquery-1.12.4.min.js"></script>
		<script src="week19.js"></script>
		<meta charset="ISO-8859-1">
		<title>Categories</title>
		<style>
			* {
				margin: 0px;
				padding: 0px;
				color: blue;
			}
			
			#top-div {
				display: table-row;
			}
			
			#detail-view {
				display: table-cell;
			}
			
			#category-list {
				display: table-cell;
			}
			
			#product-list {
				display: inline-block;
			}
			
			.alert {
				color: red;
			}
			
			.container {
				width: 500px;
				height: 400px;
			}		
		</style>
	</head>
	<body>
		<form method="post" action="/prodcat"><button class="btn-top" type="submit"><h1 >Products &amp; Categories Home</h1></button></form>
		<c:if test="${error == true}">
			<h3 class="alert">${msg}</h3>
		</c:if>
		<div id="top-div">
			<div id="detail-view" class="container">
				<h1>${category.getName()}</h1>
				<table>
					<thead>
						<tr>
							<th>Name</th>
							<th>Products</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${category.getName()}</td>
							<td><select>
								<c:forEach items="${category.getProducts()}" var="p">
									<option value="">${p.getDisplayName()}</option>
								</c:forEach>
							</select></td>
					</tbody>
				</table>
			</div>
			<div id="product-list">
				<c:choose>
					<c:when test="${noProd == true}">
						<h3 class="alert">No Products!</h3>
					</c:when>
					<c:otherwise>
						<form method="get">
							<select name="product">
								<c:forEach items="${products}" var="p">
									<option value="${p.getId()}">${p.getName()}</option>
								</c:forEach>
							</select>
							<input type="hidden" name="category" value="${category.getId()}">
							<button type="submit" formaction="/prodcat/addProdToCat">Add</button>
						</form>
					</c:otherwise>			
				</c:choose>
			</div>
		</div>
		<div>
			<div id="category-list">
				<c:choose>
					<c:when test="${noCat == true}">
						<h3 class="alert">No Categories!</h3>
					</c:when>
					<c:otherwise>
						<form id="catform" action="/prodcat/showCategories"><table><tbody>
							<c:forEach items="${categories}" var="c">
								<tr>
									<td><button onclick="setParamAndGo(${c.getId()})">${c.getName()}</button></td>
								</tr>
							</c:forEach>
						</tbody></table></form>					
					</c:otherwise>
				</c:choose>
			</div>		
		</div>
		<script>
		function setParamAndGo(category) {
			var theForm = document.forms['catform'];
		    var input = document.createElement('input');
		    input.type = 'hidden';
		    input.name = "category";
		    input.value = category;
		    theForm.appendChild(input);
		    theForm.submit();		
		}
		</script>
	</body>
</html>