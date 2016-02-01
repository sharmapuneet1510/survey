var register = angular.module("myApp", []);
register.controller("formCtrl", function($scope, $http)
	{
		$scope.registerForm = function()
			{
				$http({
					method : "POST",
					url : "http://localhost:8080/surveySystem/ws/rest/userWebService/registerUser",
					data : $scope.user,
					headers : {
						"Content-Type" : "application/json"
					}
				}).success(function(response)
					{
						$scope.message = "sussess";
						console.log(response)
						window.location = "http://localhost:8080/surveySystem/home?clientId=" + response.clientId;
					});
			};

		$scope.loginForm = function()
			{
				$("#loadingId").show();
				document.getElementById("loginFieldSetId").disabled = true;
				$http({
					method : "POST",
					url : "http://localhost:8080/surveySystem/ws/rest/userWebService/login",
					data : $scope.credential,
					headers : {
						"Content-Type" : "application/json"
					}
				}).success(function(response)
					{
						$("#loadingId").hide();
						window.location = "http://localhost:8080/surveySystem/home?clientId=" + response.clientId;
					}).error(function(response)
					{
						$("#loadingId").hide();
						document.getElementById("loginFieldSetId").disabled = false;
						$("#errorId").show();
						$scope.error = response.error;
					});
			};
	});

$(document).ready(function()
	{
		$("#signButton").click(function()
			{
				// Div
				$("#signIn").show()
				$("#logIn").hide();
				// Tab
				$("#signButton").hide();
				$("#loginButton").show();
			});
		$("#loginButton").click(function()
			{
				// Div
				$("#signIn").hide();
				$("#logIn").show();
				// Tab
				$("#signButton").show();
				$("#loginButton").hide();
			});
	});
