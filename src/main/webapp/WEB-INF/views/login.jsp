<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/head.jsp"%>



	<div class="container-fluid h-100">
		<div class="row justify-content-center ">
			<div class="col-md-3 col align-self-center">
				<c:if test="${user.status!=null}">
					<div class="alert alert-danger" role="alert">
						${user.status}
					</div>
				</c:if>
			</div>
		</div>


		<div class="row justify-content-center align-items-center  h-100">
			<div class="col col-md-2 col align-self-center">
			<form:form method="POST" commandName="user" action="/home" class="form-signin">
				<div class="text-center">
					<img class="mb-4" src="<c:url value="/resources/i/bootstrap/bootstrap-solid.svg" />" alt="" width="72" height="72">
				</div>
				<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
				<!-- <fieldset class="boxBody"> -->



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
							<input type="checkbox" value="remember-me"> Keep me logged in
						</label>
					</div>


					<%--<input type="submit" class="btnLogin" value="Login" tabindex="4">--%>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
					<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>

					<label><a href="/reg-user">Create an Account</a></label>
				<%--</footer>--%>

			</form:form>
			</div>
		</div>
	</div>





<%@include file="layout/footer.jsp"%>
