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
					<c:forEach var="listValue" items="${flList}">
						<tr>
								<%--Edit--%>
							<td><a href="/filtered-list-details-view/${listValue.flId}" class="btn btn-primary" aria-label="Edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>

								<%--Delete--%>
							<td><a href="/filtered-list-delete/${listValue.flId}" class="btn btn-danger" aria-label="Delete"><i class="fa fa-times" aria-hidden="true"></i></a></td>

							<td>${listValue.flDateCreation.toLocaleString()}</td>
							<td>${listValue.flName}</td>


						</tr>
					</c:forEach>


				</tbody>
				<!--Table body-->
			</table>
			<!--Table-->
			<a href="/new-list-create"><button type="button" class="btn btn-primary">Create a new Filtered List</button></a>

		</div>
	</div>
</div>




























<%@include file="layout/footer.jsp"%>
