<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="pg/css/common.css">
<link rel="stylesheet" href="http://ui-grid.info/release/ui-grid.css" type="text/css">
<!-- <link rel="stylesheet" href="pg/css/main.css" type="text/css"> -->
<!-- <script src="pg/js/app.js"></script> -->
<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script> -->
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-touch.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script> -->
<script src="http://ui-grid.info/docs/grunt-scripts/csv.js"></script>
<script src="http://ui-grid.info/docs/grunt-scripts/pdfmake.js"></script>
<script src="http://ui-grid.info/docs/grunt-scripts/vfs_fonts.js"></script>
<script src="http://ui-grid.info/release/ui-grid.js"></script>
<script>
	var app = angular.module('myApp', []);
	app.controller('customersCtrl', function($scope, $http)
		{
			$http.get("http://localhost:8080/surveySystem/ws/rest/userWebService/getAllUser").then(function(response)
				{
					$scope.names = response.data.records;
				});
		});
</script>
</head>
<body>
	<h1>Hello world!</h1>

	<div ng-app="myApp" ng-controller="customersCtrl">
		<table>
			<tr ng-repeat="x in names">
				<td>{{ x.id }}</td>
				<td>{{ x.emailAddress }}</td>
				<td>{{ x.profilePic }}</td>
				<!-- <td><img class="img-circle" alt="" src="{{ x.profilePic }}" /></td>
			 -->
			</tr>
		</table>
	</div>
	<!-- <div ng-app="">
		<label>First Name : </label> <input type="text" name="user.username" ng-model="user.username" /><br> <label>Last Name</label> <input type="password" name="user.password" /><br> <label>Company Name</label> <input type="text" name="user.company" /><br> <label>Profile Pic </label><img class="img-circle" alt="" src="http://localhost:8080/surveySystem/pg/images/female.png">
		<p ng-bind="user.username"></p>
	</div> -->
	-
	<!-- <div ng-controller="MainCtrl">
		<div id="grid1" ui-grid="{ data: myData }" class="grid"></div>
	</div> -->
</body>
</html>