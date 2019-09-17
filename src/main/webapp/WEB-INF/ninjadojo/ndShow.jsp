<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<meta charset="ISO-8859-1">
		<title>Dojos Page</title>
	</head>
	<body>
		<div class="top">
			<form action="/ninjadojo" method="post"><input type="submit" value="Ninja Home"></form>
			<form id="dojo-form">
				<select id="dojo" name="id" onchange="refresh()">
					<option value="">Select Dojo</option>
					<c:forEach items="${dojos}" var="d">
						<option value="${d.getId()}">${d.getName()}</option>
					</c:forEach>
				</select>			
			</form>
			<h1>Ninjas of the ${dojo.getName()} dojo</h1>
		</div>
		<div id="container">
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dojo.getNinjas()}" var="n">
						<tr>
							<td>${n.getFirstName()}</td>
							<td>${n.getLastName()}</td>
							<td>${n.getAge()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<script>
		var BASE = "/ninjadojo/show/";
			function refresh(){
				var select = document.getElementById('dojo');
				var dojo_id = select.options[select.selectedIndex].value;
				document.getElementById("dojo-form").action = BASE + dojo_id;
				document.getElementById("dojo-form").submit();
			}			    
		</script>		
	</body>
</html>