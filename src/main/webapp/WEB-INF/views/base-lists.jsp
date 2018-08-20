<%@include file="layout/head.jsp"%>
<%@include file="menu/menu.jsp"%>

<div class="container-fluid ">
    <div class="row">
        <div class="col-md-5">


            <!--Table-->
            <table id="tablePreview" class="table table-striped table-hover">
                <!--Table head-->
                <thead>
                    <tr>
                        <th> </th>
                        <th> </th>
                        <th>List Date</th>
                        <th>List Name</th>

                    </tr>
                </thead>
                <!--Table head-->
                <!--Table body-->
                <tbody>
                    <c:forEach var="listValue" items="${blList}">
                    <tr>
                        <%--Edit--%>
                        <td><a href="/base-list-edit/${listValue.idbl}" class="btn btn-primary" aria-label="Edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>

                        <%--Delete--%>
                        <td><a href="/base-list-delete/${listValue.idbl}" class="btn btn-danger" aria-label="Delete"><i class="fa fa-times" aria-hidden="true"></i></a></td>

                        <td>${listValue.listDate.toLocaleString()}</td>
                        <td>${listValue.listName}</td>

                    </tr>
                    </c:forEach>


                </tbody>
                <!--Table body-->
            </table>
            <!--Table-->
            <a href="/base-list-create"><button type="button" class="btn btn-primary">Create a new Base list</button></a>

        </div>
    </div>
</div>


























<%--<c:if test="${not empty blList}">--%>

    <%--<table border="1">--%>
        <%--<c:forEach var="listValue" items="${blList}">--%>
            <%--<tr>--%>
                <%--<td><a href="/base-list-edit/${listValue.idbl}">Edit</a></td>--%>
                <%--<td><a href="/base-list-delete/${listValue.idbl}">Delete</a></td>--%>
                <%--<td>${listValue.listDate.toLocaleString()}</td>--%>
                <%--<td>${listValue.listName}</td>--%>

            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>

<%--</c:if>--%>



<%--<br>--%>
<%--<br>--%>
<%--<a href="/base-list-create">Create a new Base list</a>--%>





<%@include file="layout/footer.jsp"%>
