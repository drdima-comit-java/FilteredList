<%@include file="layout/head.jsp"%>
<%@include file="menu/menu.jsp"%>


<div class="container-fluid ">
    <div class="row">
        <div class="col-md-8">
            <br>

            <a class="btn btn-lg btn-primary btn-block" href="/download/-1">Get List from this computer</a>
            <br>

            <br>

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
            <br>
            <br>
            <p>Sample data</p>
            <textarea  rows="10" cols="80">Spark 2.8.3.960
IntelliJ IDEA 2018.1.6
Notepad++ (32-bit x86)
Microsoft Office Professional Plus 2016
MySQL Connector Net 8.0.11
MySQL Connector J
Java Auto Updater
MySQL Notifier 1.1.7
MySQL Examples and Samples 5.5
Microsoft Office Professional Plus 2016
Microsoft Access MUI (English) 2016
Microsoft Excel MUI (English) 2016
Microsoft PowerPoint MUI (English) 2016
Microsoft Publisher MUI (English) 2016
Microsoft Outlook MUI (English) 2016
Microsoft Word MUI (English) 2016
Microsoft Office Proofing Tools 2016 - English
Outils de vérification linguistique 2016 de Microsoft Office - Français
Herramientas de corrección de Microsoft Office 2016: español
Microsoft Office Proofing (English) 2016
Microsoft InfoPath MUI (English) 2016
Microsoft Office Shared MUI (English) 2016
Microsoft DCF MUI (English) 2016
Microsoft OneNote MUI (English) 2016
Microsoft Groove MUI (English) 2016
Microsoft Office OSM MUI (English) 2016
Microsoft Office OSM UX MUI (English) 2016
Microsoft Office Shared Setup Metadata MUI (English) 2016
Microsoft Access Setup Metadata MUI (English) 2016
Microsoft Skype for Business MUI (English) 2016
Microsoft Visual C++ 2008 Redistributable - x86 9.0.30729.6161
MySQL Documents 5.5
Microsoft Visual C++ 2015 Redistributable (x64) - 14.0.23026
MySQL Installer - Community</textarea>
        </div>
    </div>
</div>


<%@include file="layout/footer.jsp"%>