<%@include file="layout/head.jsp"%>
<%@include file="menu/menu.jsp"%>


<div class="container-fluid ">
    <div class="row">
        <div class="col-md-3">

            <form:form method="POST" commandName="newList" action="${formAction}">
                <%--<h1>${pageName}</h1>--%>
                <form:label path="listDate" >List Date ${newList.listDate.toLocaleString()} </form:label><br>
                <form:label path="listName">List Name</form:label>
                <%--<form:input path="listName" class="form-control" placeholder="Q12345" required autofocus/>--%>
                <input type="text" id="listName" name="listName" value="${newList.listName}" class="form-control" placeholder="Q12345" required autofocus>
                <br>
                <form:label path="listContent">List Content</form:label>
                <%--<form:textarea path="listContent" rows="40" cols="80" />--%>
                <textarea name="listContent" id="listContent" rows="10" class="form-control" required placeholder="Microsoft Office Professional Plus 2016
Microsoft Access MUI (English) 2016
Microsoft Excel MUI (English) 2016
Microsoft PowerPoint MUI (English) 2016
">${newList.listContent}</textarea>

                <c:if test="${listMode!='baseList'}">
                    <form:label path="idbl">Exclude from Base List</form:label>
                    <form:select id="idbl" path="idbl" items="${blLists}"  class="form-control" />
                </c:if>

                <%--<input type="submit" class="btnLogin" value="filter this list with base list" tabindex="4">--%>

                <button class="btn btn-lg btn-primary btn-block" type="submit">${submitText}</button>


            </form:form>
        </div>
    </div>
</div>


<%@include file="layout/footer.jsp"%>