<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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



<table>
    <c:forEach var="fld" items="${listFld}">
    <tr>
        <td><a href="/filtered-list-detail-delete/${fld.fldId}">Delete</a></td>
        <td><c:out value="${fld.fldName}"/></td>
        <td><c:out value="${fld.fldStatus}"/></td>
    </tr>
    </c:forEach>
</table>





















</body>
</html>
