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
						<th>App Name</th>
						<th>App Path</th>

					</tr>
				</thead>
				<!--Table head-->
				<!--Table body-->
				<tbody>
					<c:forEach var="appValue" items="${appsList}">
						<tr>
								<%--Edit--%>
							<td><a href="/app-edit/${appValue.appsId}" class="btn btn-primary" aria-label="Edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>

								<%--Delete--%>
							<td><a href="/delete-app/${appValue.appsId}" class="btn btn-danger" aria-label="Delete"><i class="fa fa-times" aria-hidden="true"></i></a></td>

							<td>${appValue.appsName}</td>
							<td>${appValue.appsPath}</td>


						</tr>
					</c:forEach>


				</tbody>
				<!--Table body-->
			</table>
			<!--Table-->
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalAddApp">Add Application</button>



			<%@include file="add-setup-edit-app.jsp"%>





		</div>
	</div>
</div>




























<%@include file="layout/footer.jsp"%>

