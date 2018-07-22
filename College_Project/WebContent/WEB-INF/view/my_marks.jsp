<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>My Marks</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<br>

	<div class="container">
		<div align="left">
			<table class="table table-bordered">
				<tr>
					<th>ROLLNO</th>
					<th>NAME</th>
					<th>PHYSICS</th>
					<th>CHEMISTRY</th>
					<th>MATHS</th>
				</tr>
				<c:forEach var="c" items="${marksheetList}" varStatus="st">
					<tr>
						<td>${c.rollno}</td>
						<td>${c.name}</td>
						<td>${c.physics}</td>
						<td>${c.chemistry}</td>
						<td>${c.maths}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>