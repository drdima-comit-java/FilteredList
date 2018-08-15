<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">


	<!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">


	<link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body class="text-center">
	<h1>${user.status}</h1>
	<form:form method="POST" commandName="user" action="main" class="form-signin">
		<img class="mb-4" src="<c:url value="/resources/i/bootstrap/bootstrap-solid.svg" />" alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<!-- <fieldset class="boxBody"> -->

			<h1>Login</h1>

			<form:label path="userName" class="sr-only">Username:</form:label>
			<%--<form:input path="userName" class="form-control" />--%>
			<input type="text" id="userName" name="userName" class="form-control" placeholder="username" required autofocus>


			<form:label path="password" class="sr-only">Password:</form:label>
			<%--<form:password path="password" class="form-control" placeholder="Password" />--%>

			<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>



			<%
			//<form:label path="testField">testField:</form:label>
			//<form:input path="testField" />
			%>

		<%--</fieldset>--%>

		<%--<footer>--%>
			<div class="checkbox mb-3">
				<label>
					<%--<input type="checkbox" tabindex="3">Keep me logged in</label>--%>
					<input type="checkbox" value="remember-me">Keep me logged in
				</label>
			</div>

			<%--<input type="submit" class="btnLogin" value="Login" tabindex="4">--%>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>

			<label><a href="/reg-user">Registration</a></label>
		<%--</footer>--%>

	</form:form>


</body>
</html>
