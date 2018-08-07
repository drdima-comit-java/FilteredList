<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/4/2018
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>




<c:if test="${not empty blList}">

    <table border="1">
        <c:forEach var="listValue" items="${blList}">
            <tr>
                <td><a href="/base-list-edit/${listValue.idbl}">Edit</a></td>
                <td><a href="/base-list-delete/${listValue.idbl}">Delete</a></td>
                <td>${listValue.listDate.toLocaleString()}</td>
                <td>${listValue.listName}</td>

            </tr>
        </c:forEach>
    </table>

</c:if>



<br>
<br>
<a href="/base-list-create">Create a new Base list</a>

</body>
</html>
