<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
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
	<nav class="navbar navbar-expand-sm bg-light">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Home Page</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/college/college-list">CollegeList</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/college/college-form">Add College</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/student/student-list">Student List</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/student/student-form">Add Student</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/marksheet/marksheet-list">Marksheet List</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/marksheet/marksheet-form">Add Marksheet</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/user-list">User List</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/user-form">Add User</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
		</ul>
	</nav>
	
	<div class="container">
		<div align="left">
			<table class="table table-bordered">
				<tr>
					<th>ID</th>
					<th>Roll No.</th>
					<th>Name</th>
					<th>Physics</th>
					<th>Chemistry</th>
					<th>Maths</th>
					<th>Student Id</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="tempMarksheet" items="${marksheet}">
					<c:url var="updateLink" value="/marksheet/marksheetFormForUpdate">
						<c:param name="marksheet" value="${tempMarksheet.id}" />
					</c:url>
					<c:url var="deleteLink" value="/marksheet/marksheet-delete">
						<c:param name="marksheet" value="${tempMarksheet.id}" />
					</c:url>
					<tr>
						<td>${tempMarksheet.id}</td>
						<td>${tempMarksheet.rollno}</td>
						<td>${tempMarksheet.name}</td>
						<td>${tempMarksheet.physics}</td>
						<td>${tempMarksheet.chemistry}</td>
						<td>${tempMarksheet.maths}</td>
						<td>${tempMarksheet.studentId}</td>
						<td><a href="${updateLink}">Update</a></td>
						<td><a href="${deleteLink}">Delete</a></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>