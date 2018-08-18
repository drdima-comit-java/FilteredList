<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="layout/head.jsp" %>


<body class="text-center">
    <div class="container-fluid">
        <div class="row justify-content-md-center">
            <div class="col-md-12">
                <form:form method="POST" commandName="reg-user" action="reg-user-add" class="form-signin">
                    <h1 class="h3 mb-3 font-weight-normal">Registration Form</h1>
                    <form:label path="userName" class="sr-only">Username:</form:label>
                    <%--<form:input path="userName"/>--%>
                    <input type="text" id="userName" name="userName" class="form-control" placeholder="username" required autofocus>


                    <form:label path="password" class="sr-only">Password:</form:label>
                    <%--<form:password path="password"/>--%>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                        <%--<input type="submit" class="btnLogin" value="Register me" tabindex="4">--%>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Register me</button>





                </form:form>
            </div>
        </div>



</div>





<%@include file="layout/footer.jsp"%>