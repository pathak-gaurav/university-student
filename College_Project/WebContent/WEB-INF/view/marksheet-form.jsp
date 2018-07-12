<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Marksheet Form</title>
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
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard">Home Page</a></li>
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
		<h2>Marksheet Form</h2>
		<form:form action="marksheetRegistration" modelAttribute="marksheet"
			method="post">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>Roll No:</td>
					<td><form:input path="rollno" /></td>
					<td><form:errors path="rollno" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Physics:</td>
					<td><form:input path="physics" /></td>
					<td><form:errors path="physics" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Chemistry:</td>
					<td><form:input path="chemistry" /></td>
					<td><form:errors path="chemistry" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Maths:</td>
					<td><form:input path="maths" /></td>
					<td><form:errors path="maths" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Student Id:</td>
					<td><form:input path="studentId" /></td>
					<td><form:errors path="studentId" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>

