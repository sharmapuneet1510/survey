<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="pg/js/home.js"></script>
<script src="pg/js/common.js"></script>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
 <script src="js/jquery.circliful.min.js"></script>
-->
<!-- style sheets -->
<link rel="stylesheet" href="pg/css/common.css">
<link rel="stylesheet" href="pg/css/home.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-default" style="	font-size: medium; border-radius:0px; -webkit-border-radius:0px; -moz-border-radius:0px;">
	<div class="container-fluid">
		<div ng-app="myApp" ng-controller="userLoginInfoController">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span> <strong>  Survenoma </strong></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="http://localhost:8080/surveySystem/blog" class="toggle button"><span class="glyphicon glyphicon-bold"></span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" ng-click="getUserLoginInfo()"><span class="glyphicon glyphicon-user"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#" id="updateUserProfileId" class="toggle button" data-toggle="modal" data-target="#profile" ng-click="getUser()"><span class="glyphicon glyphicon-heart"></span> {{ firstName }} {{ lastName }}</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#" class="toggle button" id="logoutButton" ng-click="logout()"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#" class="toggle button"><span class="glyphicon glyphicon-envelope"></span> Contact Us</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#" class="toggle button"><span class="glyphicon glyphicon-time"></span> {{ lastLogin }}</a></li>
						</ul></li>
				</ul>
			</div>
			<!--  Controller Scope Ends Here All the Controller Call Can be Done Here  -->
			<div class="modal fade" id="profile" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">
								Welcome {{ user.firstName }}</span>
							</h4>
						</div>
						<div class="modal-body">
							<div id="form1" style="width: 50%; float: left;">
								<form id="updateFormId" novalidate ng-submit="updateUser()" style="width: 280px">
									<fieldset disabled>
										<div class="input-group form-group">
											<span class="input-group-addon"> <span class="glyphicon glyphicon-envelope"></span>
											</span> <input class="form-control" type="text" placeholder="Email address" name="username" ng-model="user.emailAddress">
										</div>
									</fieldset>
									<fieldset id="updateUserFormId1">
										<div class="input-group form-group">
											<span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span>
											</span> <input class="form-control" type="text" placeholder="First Name" name="firstName" ng-model="user.firstName">
										</div>
										<div class="input-group form-group">
											<span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span>
											</span> <input class="form-control" type="text" placeholder="Last Name" name="lastName" ng-model="user.lastName">
										</div>
										<div id="udpateUserSubmitId" class="input-group form-group" style="width: 100px; text-align: center;">
											<button type="submit" class="btn btn-success active">
												<span class="glyphicon glyphicon-flash"></span> Update
											</button>
										</div>
									</fieldset>
								</form>
							</div>
							<div id="loadingId" style="width: 50%; display: none; float: right;">
								<div style="text-align: center; vertical-align: middle;">
									<fieldset disabled>
										<button class="btn btn-lg btn-danger">
											<span class="glyphicon glyphicon-refresh gly-spin"> </span>Loading ...
										</button>
									</fieldset>
								</div>
							</div>
							<div id="form2" style="width: 50%; float: right;">
								<div>
									<img class="img-circle img-responsive center-block" ng-src="{{user.profilePic}}">
								</div>
								<fieldset id="updateUserFormId2" enctype="multipart/form-data">
									<div>
										<form ng-submit="uploadImage()" enctype="multipart/form-data">
											<input type="file" id="file" ng-model="file" name="file" size="50">
											<button type="submit" class="btn btn-success active">
												<span class="glyphicon glyphicon-flash"></span> change Image
											</button>
										</form>
									</div>

								</fieldset>
							</div>
						</div>
						<div class="modal-footer" style="height: 20%; clear: both">
							<div id="updateSuccessId" class="alert alert-success" style="display: none">
								<p align="center">
									<strong>User Updated Successfully !!</strong>
								</p>
							</div>
							<div id="updateErrorId" class="alert alert-danger" style="display: none">
								<p align="center">
									<strong>User Update Failed !!</strong>
								</p>
							</div>
							<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<table class="table table-striped table-condensed">
		<!-- On rows -->
		<tr>
			<td>Hi</td>
		</tr>
		<tr>
			<td>Bye</td>
		</tr>
	</table>
</body>
</html>