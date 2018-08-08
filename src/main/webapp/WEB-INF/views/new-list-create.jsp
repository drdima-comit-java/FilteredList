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



<form:form method="POST" commandName="newList" action="new-list-add" class="box login">



    <h1>${pageName}</h1>
    <form:label path="listDate">List Date ${newList.listDate.toLocaleString()} </form:label><br>
    <form:label path="listName">List Name</form:label>
    <form:input path="listName"/>
    <br>
    <form:label path="listContent">List Content</form:label><br>
    <form:textarea path="listContent" rows="40" cols="80" />






    <footer>

        <form:select path="baseListId" items="${baseLists}" />

        <input type="submit" class="btnLogin" value="filter this list with base list" tabindex="4">
        <br>
        <br>
        <br>


    </footer>

</form:form>


</body>
</html>
