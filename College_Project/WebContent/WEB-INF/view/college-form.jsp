<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>College Form</title>
<style>
.error {
	color: red
}
</style>
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
	<br>

	<div class="container">
		<h2>College Form</h2>
		<form:form action="collegeRegistration" modelAttribute="college"
			method="post">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>College Name:</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" /></td>
					<td><form:errors path="address" cssClass="error" /></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><form:input path="state" /></td>
					<td><form:errors path="state" cssClass="error" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:input path="city" /></td>
					<td><form:errors path="city" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Phone No.:</td>
					<td><form:input path="phone" /></td>
					<td><form:errors path="phone" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>

