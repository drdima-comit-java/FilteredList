<%@include file="layout/head.jsp"%>
<%@include file="menu/menu.jsp"%>


<div class="container-fluid ">
    <div class="row">
        <div class="col-md-5">

            <h1>Filtered List: ${filteredListName}</h1>
            <table id="tablePreview" class="table table-striped table-hover">
                <!--Table head-->
                <thead>
                    <tr>
                        <th> </th>
                        <th>Name</th>
                        <th>Status</th>

                    </tr>
                </thead>
                <!--Table head-->
                <tbody>
                    <c:forEach var="fld" items="${listFld}">
                    <tr>
                        <td><a href="/filtered-list-details-delete/${fld.fldId}" class="btn btn-danger" aria-label="Delete"><i class="fa fa-times" aria-hidden="true"></i></a></td>
                        <td><c:out value="${fld.fldName}"/></td>
                        <td><button type="button" class="<c:out value="${fld.fldsCss}"/>"><c:out value="${fld.fldsName}"/></button></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>



















<%@include file="layout/footer.jsp"%>
