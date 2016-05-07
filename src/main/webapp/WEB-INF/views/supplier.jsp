<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supplier</title>
<!-- scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="pg/js/supplier.js"></script>
<script src="pg/js/common.js"></script>
<!-- style sheets -->

<link rel="stylesheet" href="pg/css/common.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="pg/css/supplier.css">
</head>
</head>
<body>
	<div ng-app="myApp" ng-controller="supplierController" ng-init="loadInitialSupplierData()">
		<div class="container-fluid">
			<br>
			<div>
				<button ng-click="clear()" id="createNewSupplier" class="btn btn-primary btn-sm" type="button" data-toggle="modal" data-target="#addSupplier">
					Supplier <span class="glyphicon glyphicon-plus"> </span>
				</button>
			</div>
		</div>
		<hr>

		<div class="container-fluid">
			<!-- Table -->
			<div class="table-responsive">
				<!-- <table class="table table-striped table-bordered table-condensed"> -->
				<table class="table table-striped table-condensed ">
					<thead>
						<tr>
							<th style="width: 5%">Sr No</th>
							<th style="width: 20%">Supplier Name</th>
							<th style="width: 40%">Description</th>
							<th style="width: 10%">Industry</th>
							<th style="width: 5%">Status</th>
							<th style="width: 10%">Actions</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="supplierGrid in suppliers.pages">
							<td style="width: 5%">{{$index +1}}</td>
							<!-- <td>{{supplier.supplierId}}</td> -->
							<td style="width: 20%">{{supplierGrid.supplier.supplierName}}</td>
							<td style="width: 40%">{{supplierGrid.supplier.description}}</td>
							<td style="width: 10%">{{supplierGrid.supplier.industry}}</td>
							<td style="width: 5%">{{supplierGrid.supplier.status}}</td>
							<th style="width: 10%">
								<!-- <div class="dropdown"> -->
								<div ng-class="getDynamicClassForActionDropDown($index+1,suppliers.pageSize)">
									<button id="actionMenu" class="btn btn-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
										Action <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu" aria-labelledby="actionMenu">
										<li role="presentation" ng-repeat="action in supplierGrid.supplierActions"><a ng-click="performSupplierAction(supplierGrid.supplier,action)" role=" menuitem" href="#"> {{action}}</a></li>
									</ul>
								</div>
							</th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="container-fluid" align="center">
			<ul class="pagination" style="padding: 0px">
				<li><a href="#">1</a></li>
				<li class="active"><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
			<!-- Modal -->
		</div>



		<div id="addSupplier" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Add Supplier</h4>
					</div>
					<form>
						<div class="modal-body">
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">@</span> <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1" ng-model="supplier.supplierName" ng-bind="supplier.supplierName">
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Recipient's username" aria-describedby="basic-addon2"> <span class="input-group-addon" id="basic-addon2">@example.com</span>
							</div>
							<div class="input-group">
								<span class="input-group-addon">$</span> <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)"> <span class="input-group-addon">.00</span>
							</div>
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon3">https://example.com/users/</span> <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
							</div>

						</div>
						<div class="modal-footer">
							<div style="float: left">
								<button type="button" class="btn btn-default btn-sm">
									Submit<span class="glyphicon glyphicon-send"></span>
								</button>
							</div>
							<div style="float: rigth">
								<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</body>
</html>