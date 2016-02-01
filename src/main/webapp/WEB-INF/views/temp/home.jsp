<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grand View Tech Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="pg/js/home.js"></script>
<link rel="stylesheet" href="pg/css/home.css">
</head>
<body>
	<div>
		<nav class="navbar navbar-inverse" style="background-color: black; font-size: medium; border-radius:0px; -webkit-border-radius:0px; -moz-border-radius:0px;"> <!-- <div class="container-fluid"> --> <!-- <div class="collapse navbar-collapse" id="myNavbar1"> -->
		<ul class="nav navbar-nav navbar-left">
			<li><a href="#" class="toggle button" id="menuDown"><span class="glyphicon glyphicon-menu-hamburger"></span> Menu <span class="glyphicon glyphicon-menu-down"></span></a></li>
			<li><a href="#" class="toggle button" id="menuUp" style="display: none;"><span class="glyphicon glyphicon-menu-hamburger"></span> Menu <span class="glyphicon glyphicon-menu-up"></span></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="http://localhost:8080/surveySystem/blog" class="toggle button"><span class="glyphicon glyphicon-bold"></span></a></li>
			<li><a href="#" class="toggle button" id="logoutButton" ng-app="myApp" ng-controller="logoutController" ng-click="logout()"><span class="glyphicon glyphicon-user"></span></a></li>
		</ul>
		</nav>
	</div>


	<div ng-app="myApp" ng-controller="tabController">{{ firstName}}</div>

	<div id="menuPanel" class="col-sm-2" style="display: none; padding: 5px; z-index: 1; position: fixed; background-color: #E0E0E0; height: 100%" ng-app="myApp" ng-controller="tabController">
		<span> <img alt="" style="" img-cirlce" src="http://localhost:8080/surveySystem/pg/image/puneet.png"></span><br> Welcome {{ firstName }}
		<hr>
		<ul class="nav nav-pills nav-stacked">
			<li><a href="#">Home</a></li>
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">My Account</a></li>
			<li><a href="#">Subscription</a></li>
			<!-- <li class="divider"></li> -->
			<li><hr>
			<li>
			<li><a href="#">About Us</a></li>
		</ul>
	</div>
	<div class="row" style="padding: 2px; padding-left: 220px;">
		<div class="col-sm-11" style="padding: 2px;">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">Survey Forms</div>
				<div class="panel-body"></div>
				<!-- <table class="table"></table> -->
				<!-- <div class="panel-footer"> -->
				<div style="float: rigth">
					<button class="round-button btn btn-danger">
						<span class="glyphicon glyphicon-pencil"></span>
					</button>
				</div>
				<!-- </div> -->


			</div>
		</div>
		<!-- <div class="col-sm-4" style="padding: 2px;">
			<div class="panel panel-default">
				Default panel contents
				<div class="panel-heading">Panel heading</div>
				<div class="panel-body">
					<p>...</p>
				</div>
				Table
				<table class="table">
				</table>
			</div>
		</div> -->
	</div>
</body>
</html>