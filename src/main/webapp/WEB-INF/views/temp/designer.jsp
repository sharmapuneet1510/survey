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
	<div>
		<div class="container-fluid">
			<div class="row">
				<br>
				<div class="col-md-2">
					<ul id="draggable" class="list-group ui-widget-content">
						<li id="draggable1" class="list-group-item ui-state-highlight">Text</li>
						<li id="draggable2" class="list-group-item ui-state-highlight">Numeric</li>
						<li id="draggable3" class="list-group-item ui-state-highlight">Decimal</li>
						<li id="draggable4" class="list-group-item ui-state-highlight">Radio Button</li>
						<li id="draggable5" class="list-group-item ui-state-highlight">CheckBox</li>
						<li id="draggable6" class="list-group-item ui-state-highlight">DropDown</li>
					</ul>
				</div>
				<!-- <br> -->
				<div id="droppable" class="col-md-10">
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
												<div class="dropdown form-group">
													<label>Section layout :&nbsp;&nbsp;</label>
													<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
														<span class="caret"></span>
													</button>
													<ul class="dropdown-menu">
														<li><a href="#">Single Column</a></li>
														<li><a href="#">Double Column</a></li>
													</ul>
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

			</div>

		</div>
</body>
</html>