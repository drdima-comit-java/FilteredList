<%@include file="layout/head.jsp"%>
<%@include file="menu/menu.jsp"%>

<style>

    .btn-xs {
        padding: 1px 5px;
    }


</style>
<div class="container-fluid ">
    <div class="row">
        <div class="col-sm-5">
            <h1>Filtered List: ${filteredListName}</h1>
            <table id="tablePreview" class="table table-striped table-hover">
                <!--Table head-->
                <thead>
                    <tr class="row">
                        <th class="col-sm-1">X</th>
                        <th class="col-sm-3">Name</th>
                        <th class="col-sm-3">Status</th>

                    </tr>
                </thead>
                <!--Table head-->
                <tbody>
                    <c:forEach var="fld" items="${listFld}">
                    <tr class="row">
                        <td class="col-sm-1"><a href="/filtered-list-details-delete/${fld.fldId}" class="btn btn-danger" aria-label="Delete"><i class="fa fa-times" aria-hidden="true"></i></a></td>
                        <td class="col-sm-8">
                            <c:out value="${fld.fldName}"/><br>
                            <c:out value="${fld.appsPath}"/>
                            <c:if test="${fld.appsPath==null}">
                                <button type="button"
                                        class="btn btn-primary btn-xs open-AddAppDialog"
                                        data-toggle="modal"
                                        data-target="#myModalAddApp"
                                        data-apps-name="<c:out value="${fld.fldName}"/>">
                                        Add Path
                                </button>
                            </c:if>
                        </td>
                        <td class="col-sm-3">
                            <button type="button"
                                    data-flds-id="<c:out value="${fld.fldsId}"/>"
                                    data-flds-sort="<c:out value="${fld.fldsSort}"/>"
                                    data-fld-id="<c:out value="${fld.fldId}"/>"
                                    data-fld-apps-path="<c:if test="${fld.appsPath!=null}">true</c:if>"
                                    class="<c:out value="${fld.fldsCss}"/>">
                                    <c:out value="${fld.fldsName}"/>
                            </button>
                            <c:if test="${fld.fldsSort==2}">
                                <script>inProgress=true</script>
                            </c:if>

                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%@include file="add-setup-edit-app.jsp"%>


        </div>
    </div>
</div>



















<%@include file="layout/footer.jsp"%>
