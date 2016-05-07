var getQueryString = function(field, url)
	{
		var href = url ? url : window.location.href;
		var reg = new RegExp('[?&]' + field + '=([^&#]*)', 'i');
		var string = reg.exec(href);
		return string ? string[1] : null;
	};

var userName = "";
var clientId = getQueryString('clientId');

$(document).ready(function()
	{
		$('[data-toggle="logoutPopOver"]').popover();
	});

var tabController = angular.module('myApp', []);
tabController.controller('tabController', function($scope, $http)
	{
		$scope.tab = function()
			{
				console.log("tab");
				$http.get("http://localhost:8080/surveySystem/ws/rest/userWebService/getHomeScreenDropDrow?clientId=" + clientId).then(function(response)
					{
						$scope.tab = response.data;
						$scope.firstName = tab.user.firstName;
					});
			};
	});
/**
 * var logoutController = angular.module('myApp', []);
 * logoutController.controller('logoutController', function($scope, $http) {
 * console.log("logout") $scope.logout = function() { $http({ method : "POST",
 * url :
 * "http://localhost:8080/surveySystem/ws/rest/userWebService/logout?clientId=" +
 * clientId, data : $scope.user, headers : { "Content-Type" : "application/json" }
 * }).success(function(response) { window.location =
 * "http://localhost:8080/surveySystem/welcome"; }); }; });
 */
$(document).ready(function()
	{
		$("#menuDown").click(function()
			{
				$("#menuUp").show()
				$("#menuDown").hide();
				$("#menuPanel").show();
			});
		$("#menuUp").click(function()
			{
				$("#menuUp").hide();
				$("#menuDown").show();
				$("#menuPanel").hide();
			});
	});

var userLoginInfoController = angular.module('myApp', []);
userLoginInfoController.controller('userLoginInfoController', function($scope, $http)
	{

		$scope.uploadImage = function()
			{
				$("#updateSuccessId").hide();
				$("#updateErrorId").hide();
				$("#form1").hide();
				$("#form2").css("float", "left");
				$("#loadingId").show();
				document.getElementById("updateUserFormId2").disabled = true;
				var x = document.getElementById("file");
				if ('files' in x)
					{
						for (var i = 0; i < x.files.length; i++)
							{
								var file = x.files[i];
								break;
								if ('name' in file)
									{

									}
								if ('size' in file)
									{
										txt += "size: " + file.size + " bytes <br>";
									}
							}
					}
				var formData = new FormData();
				formData.append(file.name, file);
				// formData.append(file);
				$http({
					method : "POST",
					url : "http://localhost:8080/surveySystem/ws/rest/userWebService/uploadProfilePic?clientId=" + clientId,
					data : formData,
					headers : {
						"Content-Type" : "multipart/form-data"
					}
				}).success(function(response)
					{
						$scope.user.profilePic = response.profilePic;
						$("#updateSuccessId").show();
						$("#loadingId").hide();
						$("#form2").css("float", "right");
						$("#form1").show();
						document.getElementById("updateUserFormId2").disabled = false;
					}).error(function(response)
					{
						$("#updateErrorId").show();
						$("#loadingId").hide();
						$("#form2").css("float", "right");
						$("#form1").show();
						document.getElementById("updateUserFormId2").disabled = false;
					});
			}

		$scope.logout = function()
			{
				$http({
					method : "POST",
					url : "http://localhost:8080/surveySystem/ws/rest/userWebService/logout?clientId=" + clientId,
					data : $scope.user,
					headers : {
						"Content-Type" : "application/json"
					}
				}).success(function(response)
					{
						window.location = "http://localhost:8080/surveySystem/welcome";
					});
			};
		$scope.getUserLoginInfo = function()
			{
				$http.get("http://localhost:8080/surveySystem/ws/rest/userWebService/getUserLoginInfo?clientId=" + clientId).then(function(response)
					{
						$scope.firstName = response.data.firstName;
						$scope.lastName = response.data.lastName;
						$scope.emailAddress = response.data.emailAddress;
						$scope.lastLogin = response.data.lastLogin;
					});
			};

		$scope.getSettingDropDown = function()
			{
				$http.get("http://localhost:8080/surveySystem/ws/rest/uiWebService/getSettingsDropDown?clientId=" + clientId).then(function(response)
					{
						$scope.settings = response.data;
					});
			}
		$scope.getUser = function()
			{
				$http.get("http://localhost:8080/surveySystem/ws/rest/userWebService/getUser?clientId=" + clientId).then(function(response)
					{
						$scope.user = response.data;
					});
			};
		$scope.updateUser = function()
			{
				$("#updateSuccessId").hide();
				$("#updateErrorId").hide();
				// $("#udpateUserSubmitId").hide();
				$("#form2").hide();
				$("#loadingId").show();
				document.getElementById("updateUserFormId1").disabled = true;
				$http({
					method : "POST",
					url : "http://localhost:8080/surveySystem/ws/rest/userWebService/updateUser?clientId=" + clientId,
					data : $scope.user,
					headers : {
						"Content-Type" : "application/json"
					}
				}).success(function(response)
					{
						$scope.user.emailAddress = response.emailAddress;
						$scope.user.firstName = response.firstName;
						$scope.user.lastName = response.lastName;
						$scope.user.middleName = response.middleName;
						$("#updateSuccessId").show();
						// $("#udpateUserSubmitId").show();
						$("#loadingId").hide();
						$("#form2").show();
						document.getElementById("updateUserFormId1").disabled = false;
					}).error(function(response)
					{
						$("#updateErrorId").show();
						// $("#udpateUserSubmitId").show();
						$("#loadingId").hide();
						$("#form2").show();
						document.getElementById("updateUserFormId1").disabled = false;
					});
			};
	});
$(document).ready(function()
	{
		$("#updateUserProfileId").click(function()
			{
				$("#updateSuccessId").hide();
				$("#updateErrorId").hide();
			});

	});
var surveyCardController = angular.module('bodyApp', [])
surveyCardController.controller('surveyCardController', function($scope, $http)
	{
		$scope.createNewSurvey = function()
			{
				$location.url("http://localhost:8080/surveySystem/designer");
			};
	});
