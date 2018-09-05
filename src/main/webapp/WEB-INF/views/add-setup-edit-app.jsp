<!-- The Modal -->
<div class="modal fade" id="myModalAddApp">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Add Application</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<form:form id="form-modal-body" method="POST" action="/add-app" class="form-signin">
				<div class="modal-body">

					<input type="text" id="appsName" name="appsName" class="form-control" placeholder="Application Name" required autofocus>
					<input type="text" id="appsPath" name="appsPath" class="form-control" placeholder="\\servername\folder1\folder2\app.exe" required autofocus>

				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Add</button>
						<%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
				</div>
			</form:form>

		</div>
	</div>
</div>