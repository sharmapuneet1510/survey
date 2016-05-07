<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grand View Tech</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="pg/js/welcome.js"></script>
</head>
<body style="background: #FFFFFF;">

	<!-- background="pg/image/background/welcome.jpg" -->
	<nav class="navbar navbar-inverse" style="background-color: #333333; font-size: medium; border-radius:0px; -webkit-border-radius:0px; -moz-border-radius:0px;">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav  navbar-right">
				<li><a href="http://localhost:8080/surveySystem/blog" class="toggle button"><span class="glyphicon glyphicon-bold"></span></a></li>
				<li><a href="#login" class="toggle button" id="loginButton" style="display: none;"><span class="glyphicon glyphicon-log-in"></span> Lets Begin</a></li>
				<li><a href="#signIn" class="toggle button" id="signButton"><span class="glyphicon glyphicon-hand-up"></span> Join Us</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<div style="float: right; width: 250px;">
			<div ng-app="myApp" ng-controller="formCtrl">

				<form id="signIn" novalidate ng-submit="registerForm()" style="display: none;">
					Your Business Start's Here With Us.
					<div class="input-group form-group">
						<span class="input-group-addon"> <span class="glyphicon glyphicon-envelope"></span>
						</span> <input class="form-control" type="text" placeholder="Email address" name="username" ng-model="user.emailAddress">
					</div>
					<div class="input-group form-group">
						<span class="input-group-addon"> <span class="glyphicon glyphicon-lock"></span>
						</span> <input class="form-control" type="password" placeholder="Password" name="password" ng-model="user.password">
					</div>
					<div class="input-group form-group">
						<span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span>
						</span> <input class="form-control" type="text" placeholder="First Name" name="firstName" ng-model="user.firstName">
					</div>
					<div class="input-group form-group">
						<span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span>
						</span> <input class="form-control" type="text" placeholder="Last Name" name="lastName" ng-model="user.lastName">
					</div>
					<div id="loginId" class="input-group form-group" style="width: 100px">
						<button type="submit" class="btn btn-success active">
							<span class="glyphicon glyphicon-flash"></span> Let's Begin
						</button>
					</div>
				</form>
				<form id="logIn" novalidate ng-submit="loginForm()">
					<fieldset id="loginFieldSetId">
						<div class="input-group form-group">
							<span class="input-group-addon"> <span class="glyphicon glyphicon-envelope"></span>
							</span> <input class="form-control" type="text" placeholder="Email address" name="username" ng-model="credential.username">
						</div>
						<!-- <br> -->
						<div class="input-group form-group">
							<span class="input-group-addon"> <span class="glyphicon glyphicon-lock"></span>
							</span> <input class="form-control" type="password" placeholder="Password" name="password" ng-model="credential.password">
						</div>
						<!-- <br> -->
						<div class="input-group form-group" style="width: 100px">
							<button type="submit" class="btn btn-success active">
								<span class="glyphicon glyphicon-star"></span> Let's Start
							</button>
						</div>
					</fieldset>
				</form>
				<div id="loadingId" style="width: 50%; display: none; float: right;">
					<div style="text-align: center; vertical-align: middle;">
						<fieldset disabled>
							<button class="btn btn-lg btn-danger">
								<span class="glyphicon glyphicon-refresh gly-spin"> </span>Loading ...
							</button>
						</fieldset>
					</div>
				</div>
				<div id="errorId" class="alert alert-danger" style="display: none">
					<p align="center">
						<strong>{{error }}</strong>
					</p>
				</div>
			</div>


		</div>
	</div>

</body>
</html>