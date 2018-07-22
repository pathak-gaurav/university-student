<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>College Application - Login</title>
</head>

<body>
	<table >
		<tr>
			<td >

			</td>
		</tr>
		<tr>
			<td  valign="top">
				<!-- This is for form -->
				<h3>User Login Form</h3> 
				<c:if test="${err!=null}">
					<p class="error">${err}</p>
				</c:if>
				<c:if test="${param.act eq 'lo'}">
					<p class="success"> You been logged out successfully!</p>
				</c:if>
				<c:if test="${param.act eq 'reg'}">
					<p class="success"> User created Successfully! Kindly Login.</p>
				</c:if>
				<c:if test="${param.act eq 'succ'}">
					<p class="success"> User created Successfully! Kindly Login.</p>
				</c:if>
				<s:url var="url_login" value="/login"></s:url>
				<f:form action="${url_login}" modelAttribute="command">
					<table >
						<tr> 
							<td>Username</td>
							<td> <f:input path="login"/> </td>
						</tr>
						<tr> 
							<td>Password</td>
							<td> <f:password path="password"/> </td>
						</tr>
						<tr> 
							<td><button>Login</button>
						</tr>
							
					</table>
				</f:form>
			</td>
		</tr>
		
		<tr>
			<td >
				<!-- This is for footer -->
			</td>
		</tr>

	</table>
</body>

</html>