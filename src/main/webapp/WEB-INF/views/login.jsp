<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>${user.status}</h1>
	<form:form method="POST" commandName="user" action="main" class="box login">

		<fieldset class="boxBody">

			<h1>Login</h1>

			<form:label path="userName">Username:</form:label>
			<form:input path="userName" />

			<form:label path="password">Password:</form:label>
			<form:password path="password"/>


			<%
			//<form:label path="testField">testField:</form:label>
			//<form:input path="testField" />
			%>

		</fieldset>

		<footer>
			<label><input type="checkbox" tabindex="3">Keep me logged in</label>

			<input type="submit" class="btnLogin" value="Login" tabindex="4">
			<br>
			<br>
			<br>

			<label><a href="/reg-user">Registration</a></label>
		</footer>

	</form:form>


</body>
</html>