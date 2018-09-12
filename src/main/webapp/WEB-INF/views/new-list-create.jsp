<%@include file="layout/head.jsp"%>
<%@include file="menu/menu.jsp"%>


<div class="container-fluid ">
    <div class="row">
        <div class="col-md-8">
            <br>

            <div class="col-md-5">


            <a class="btn btn-lg btn-primary btn-block" href="/download/-1">Get List from this computer</a>
            </div>
            <br>

            <br>

            <form:form method="POST" commandName="newList" action="${formAction}">
                <%--<h1>${pageName}</h1>--%>
                <form:label path="listDate" >List Date ${newList.listDate.toLocaleString()} </form:label><br>
                <form:label path="listName">List Name</form:label>
                <%--<form:input path="listName" class="form-control" placeholder="Q12345" required autofocus/>--%>
                <input type="text" id="listName" name="listName" value="${newList.listName}" class="form-control"
                       <%--placeholder="Q12345"--%>
                       required autofocus>
                <br>
                <form:label path="listContent">List Content</form:label>
                <%--<form:textarea path="listContent" rows="40" cols="80" />--%>
                <textarea name="listContent" id="listContent" rows="10" class="form-control" required
                          <%--placeholder="--%>
                          <%--Microsoft Office Professional Plus 2016--%>
                            <%--Microsoft Access MUI (English) 2016--%>
                            <%--Microsoft Excel MUI (English) 2016--%>
                            <%--Microsoft PowerPoint MUI (English) 2016--%>
                            <%--"--%>
                >${newList.listContent}</textarea>

                <c:if test="${listMode!='baseList'}">
                    <form:label path="idbl">Exclude from exclude list</form:label>
                    <form:select id="idbl" path="idbl" items="${blLists}"  class="form-control" />
                </c:if>
                <br>
                <br>

                <%--<input type="submit" class="btnLogin" value="filter this list with base list" tabindex="4">--%>
                <div class="col-md-3">
                <button class="btn btn-lg btn-primary btn-block" type="submit">${submitText}</button>
                </div>

            </form:form>
            <br>
            <br>
            <p>Sample data</p>
            <textarea  rows="10" cols="80">


EditPlus
Everything 1.4.1.895 (x86)
GIMP 2.10.6
Mozilla Firefox 61.0.2 (x86 en-US)
Mozilla Maintenance Service
Notepad++ (32-bit x86)
Microsoft Office Professional Plus 2016
Total Commander (Remove or Repair)
VLC media player

WinRAR 5.60 (32-bit)
WinSCP 5.13.4
Microsoft .NET Framework 4.7.2
Java 8 Update 181
MySQL Workbench 6.0 CE
Java Auto Updater
Google Update Helper
Google Chrome
Microsoft Visual C++ 2015 Redistributable (x86) - 14.0.23026
Microsoft Office Professional Plus 2016
Microsoft Access MUI (English) 2016
Microsoft Excel MUI (English) 2016
Microsoft PowerPoint MUI (English) 2016
Microsoft Publisher MUI (English) 2016
Microsoft Outlook MUI (English) 2016
Microsoft Word MUI (English) 2016
Microsoft Office Proofing Tools 2016 - English
Outils de v‚rification linguistique 2016 de Microsoft Officeÿ- Fran‡ais
Herramientas de correcci¢n de Microsoft Office 2016: espa¤ol
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
Microsoft .NET Framework 4.7.2
Update for Microsoft .NET Framework 4.7.2 (KB4087364)
Microsoft Visual C++ 2008 Redistributable - x86 9.0.30729.6161
Microsoft Visual C++ 2015 x86 Minimum Runtime - 14.0.23026
OpenOffice 4.1.5
Adobe Acrobat Reader DC
Microsoft Visual C++ 2015 x86 Additional Runtime - 14.0.23026
VMware Tools
paint.net
Microsoft Visual Studio Code


</textarea>
        </div>
    </div>
</div>


<%@include file="layout/footer.jsp"%>