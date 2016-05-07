<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Survey Designer</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="pg/js/designer.js"></script>
</head>
<body>
	<!-- Full Width Container -->
	<br>
	<br>
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">Survey Designer</div>
			<div class="panel-body">
				<button class="btn btn-primary" type="button" data-toggle="modal" data-target="#createSections">
					Add Block &nbsp;&nbsp;<span class="glyphicon glyphicon-pencil"></span>
				</button>
				<div id="createSections" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Create Section Block</h4>
							</div>
							<div class="modal-body">
								<form role="form">
									<div class="form-group">
										<label>Section Name :&nbsp;&nbsp;</label><input type="text" placeholder="section name" />
									</div>
									<div class="form-group">
										<label class="form-control">Field Type :&nbsp;&nbsp;</label> <select class="form-control" id="fieldType">
											<option>Text</option>
											<option>TextArea</option>
											<option class="divider"></option>
											<option>CheckBox</option>
											<option>Radio Button</option>
											<option class="divider"></option>
											<option>Single Select DropDown</option>
											<option>Multi Select DropDown</option>
										</select>

									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				<form action="">
					<div class="ui-widget-content"></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>