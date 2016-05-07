var getQueryString = function(field, url)
	{
		var href = url ? url : window.location.href;
		var reg = new RegExp('[?&]' + field + '=([^&#]*)', 'i');
		var string = reg.exec(href);
		return string ? string[1] : null;
	};

var userName = "";
var clientId = getQueryString('clientId');

var supplierController = angular.module('myApp', []);
supplierController.controller('supplierController', function($scope, $http)
	{
		$scope.clear = function()
			{
				$scope.supplier = "";
			};
		$scope.addModalLocation = function(supplier, action)
			{
				// $scope.supplier = supplier;
				// console.log(JSON.stringify($scope.supplier));
				if (action == "Edit")
					{
						return "data-toggle=\"modal\" data-target=\"#addSupplier\"";
					}
				else
					{
						return;
					}
			};
		$scope.addIconToAction = function(action)
			{
				if (action == "Edit")
					{
						return "glyphicon glyphicon-edit";
					}
				else if (action == "Add Catalog")
					{
						return "glyphicon glyphicon-credit-card";
					}
				else if (action == "Active")
					{
						return "glyphicon glyphicon-ok";
					}
				else if (action == "Inactive")
					{
						return "glyphicon glyphicon-remove";
					}
				else if (action == "Notify")
					{
						return "glyphicon glyphicon-bell";
					}
			};
		$scope.loadInitialSupplierData = function()
			{
				$http.get("http://localhost:8080/surveySystem/ws/rest/supplierWebService/getAllSupplier?clientId=" + clientId).then(function(response)
					{
						$scope.suppliers = response.data;
						console.log(JSON.stringify($scope.suppliers));
					});
			};

		$scope.performSupplierAction = function(supplier, action)
			{
				if (action == "Edit")
					{
						$scope.supplier = supplier;
						// $scope.getSupplierBySupplierId(supplier);
						$('#addSupplier').modal('show');
						console.log(JSON.stringify($scope.supplier));
					}
				else if (action == "Active" || action == "Inactive")
					{
						$http({
							method : "POST",
							url : "http://localhost:8080/surveySystem/ws/rest/supplierWebService/changeStatusOfSupplier?clientId=" + clientId + "&supplierId=" + supplier.supplierId + "&status=" + action,
							headers : {
								"Content-Type" : "application/json"
							}
						}).success(function(response)
							{
								$scope.loadInitialSupplierData();
							});
					}
			}
		$scope.getDynamicClassForActionDropDown = function(index, pageSize)
			{
				if (index <= pageSize / 2)
					{
						return "dropdown";
					}
				else
					{
						return "dropup";
					}
			}
	});
