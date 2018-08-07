<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/4/2018
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<form:form method="POST" commandName="baseList" action="${pageAction}" class="box login">



        <h1>${pageName}</h1>
        <form:label path="listDate">List Date ${baseList.listDate.toLocaleString()}</form:label><br>
        <form:label path="listName">List Name</form:label>
        <form:input path="listName"/>
        <br>
        <form:label path="listContent">List Content</form:label><br>
    <form:textarea path="listContent" rows="40" cols="80" />






    <footer>


        <input type="submit" class="btnLogin" value="${submitMsg}" tabindex="4">
        <br>
        <br>
        <br>


    </footer>

</form:form>


</body>
</html>
