<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Welcome to Purchase Register Page</h1>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="save" method="POST"
					modelAttribute="purchase">
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="orderCode"> ORDERCODE</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control" />
						</div>
						<div class="col-4" id="orderCodeError"></div>
					</div>
					
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="shipmentType"> SHIPMENT CODE</label>
						</div>
						<div class="col-4">
							<form:select path="shipmentType.id" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${stobs}"/>
							</form:select>
						</div>
						<div class="col-4" id="shipmentType"></div>
					</div>
					
					
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="vendor"> VENDOR</label>
						</div>
						<div class="col-4">
							<form:select path="vendor.id" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${users}"/>
							</form:select>
						</div>
						<div class="col-4" id="vendorError"></div>
					</div>
					
					
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="refNum"> REFNUM</label>
						</div>
						<div class="col-4">
							<form:input path="refNum" class="form-control" />
						</div>
						<div class="col-4" id="refNumError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="qltyCheck"> QLTYCHECK</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="qltyCheck" value="Required" /> Required
							<form:radiobutton path="qltyCheck" value="Not Required"  />Not Required
						</div>
						<div class="col-4" id="qltyCheckError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="status"> STATUS</label>
						</div>
						<div class="col-4">
							<form:input path="status"  class="form-control" readonly="true" />
						</div>
						<div class="col-4" id="statusError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="note"> NOTE</label>
						</div>
						<div class="col-4">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-4" id="noteError"></div>
					</div>
					<input type="submit" value="Register" class="btn btn-success" />
				</form:form>
			</div>
			<div class="card-footer bg-info text-white">
				<b>${message}</b>
			</div>
		</div>
	</div>
</body>
</html>