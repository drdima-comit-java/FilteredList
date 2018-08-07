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

<form:form method="POST" commandName="reg-user" action="reg-user-add" class="box login">

    <fieldset class="boxBody">

        <h1>Registration</h1>

        <form:label path="userName">Username:</form:label>
        <form:input path="userName" />

        <form:label path="password">Password:</form:label>
        <form:password path="password"/>




    </fieldset>

    <footer>


        <input type="submit" class="btnLogin" value="Register me" tabindex="4">
        <br>
        <br>
        <br>


    </footer>

</form:form>


</body>
</html>