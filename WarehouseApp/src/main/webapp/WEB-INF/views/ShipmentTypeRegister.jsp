<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Welcome to ShipmentType Register Page</h1>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="save" method="POST"
					modelAttribute="shipmenttype">
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="mode"> MODE</label>
						</div>
						<div class="col-4">
							<form:select path="mode" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="AIR">AIR</form:option>
								<form:option value="TRUCK">TRUCK</form:option>
								<form:option value="SHIP">SHIP</form:option>
								<form:option value="TRAIN">TRAIN</form:option>
							</form:select>
						</div>
						<div class="col-4" id="modeError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="code"> CODE</label>
						</div>
						<div class="col-4">
							<form:input path="code" class="form-control" />
						</div>
						<div class="col-4" id="codeError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="enableShp"> ENABLESHP</label>
						</div>
						<div class="col-4">
							<form:select path="enableShp" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="YES">YES</form:option>
								<form:option value="NO">NO</form:option>
							</form:select>
						</div>
						<div class="col-4" id="enableShpError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="grade"> GRADE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="grade" value="A" />A
							<form:radiobutton path="grade" value="B" />B
							<form:radiobutton path="grade" value="C" />C
						</div>
						<div class="col-4" id="gradeError"></div>
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