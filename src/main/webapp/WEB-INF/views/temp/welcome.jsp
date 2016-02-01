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
<body background="pg/image/background/welcome.jpg">
	<nav class="navbar navbar-inverse" style="background-color: black; font-size: medium; border-radius:0px; -webkit-border-radius:0px; -moz-border-radius:0px;">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="myNavbar" style="height: 1000px">
			<ul class="nav navbar-nav  navbar-right">
				<li><a href="http://localhost:8080/surveySystem/blog" class="toggle button"><span class="glyphicon glyphicon-bold"></span>Blog</a></li>
				<li><a href="#login" class="toggle button" id="loginButton" style="display: none;"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<li><a href="#signIn" class="toggle button" id="signButton"><span class="glyphicon glyphicon-hand-up"></span> SignIn</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container" style="float: right; width: 250px;">
		<div ng-app="myApp" ng-controller="formCtrl">
			<form id="signIn" novalidate ng-submit="registerForm()" style="display: none;">
				<div id="emailAddress" class="form-group" style="width: 250px">
					<label>Email Address :</label> <input type="text" name="emailAddress" class="form-control" placeholder="Email Address" ng-model="user.emailAddress">
				</div>
				<div id="password" class="form-group" style="width: 250px">
					<label>Password :</label> <input type="password" name="password" class="form-control" placeholder="Password" ng-model="user.password">
				</div>
				<div id="firstname" class="form-group" style="width: 250px">
					<label>First Name :</label> <input type="text" name="firstName" class="form-control" placeholder="First Name" ng-model="user.firstName">
				</div>
				<div id="middleName" class="form-group" style="width: 250px">
					<label>Middle Name :</label> <input type="text" name="middleName" class="form-control" placeholder="Middle Name" ng-model="user.middleName">
				</div>
				<div id="lastName" class="form-group" style="width: 250px">
					<label>Last Name :</label> <input type="text" name="lastName" class="form-control" placeholder="Last Name" ng-model="user.lastName">
				</div>
				<button type="submit" class="btn btn-success btn-lg btn-block" style="width: 150px">
					<span class="glyphicon glyphicon-flash"></span> Join Us
				</button>
			</form>
			<form id="logIn" novalidate ng-submit="loginForm()">
				<div class="input-group form-group">
					<span class="input-group-addon"> <span class="glyphicon glyphicon-envelope"></span>
					</span> <input class="form-control" type="text" placeholder="Email address" name="username" ng-model="credential.username">
				</div>
				<br>
				<div class="input-group form-group">
					<span class="input-group-addon"> <span class="glyphicon glyphicon-lock"></span>
					</span> <input class="form-control" type="password" placeholder="Password" name="password" ng-model="credential.password">
				</div>
				<br>
				<div class="input-group form-group" style="width: 100px">
					<button type="submit" class="btn btn-success active">
						<span class="glyphicon glyphicon-star"></span> Let Start
					</button>
				</div>
			</form>

			<br>{{credential}} <br>{{ user }} <br> {{message}}
		</div>
	</div>

</body>
</html>