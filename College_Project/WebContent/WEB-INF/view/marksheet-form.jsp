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

	<jsp:include page="menu.jsp"></jsp:include>
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

