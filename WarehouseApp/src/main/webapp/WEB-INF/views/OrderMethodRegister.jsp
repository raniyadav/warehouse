<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp" %>
	<div class="container">

		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to OrderMethod Register Page!!</h3>
			</div>



			<div class="card-body">

				<form:form action="save" method="post" modelAttribute="orderMethod" id="orderForm">

					<!-- 1st Input -->
					<div class="row">
						<div class="col-4">
							<label for="orderMode">Order Mode</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="orderMode" value="Sale"  />
							Sale
							<form:radiobutton path="orderMode" value="Purchase" />
							Purchase

						</div>
						<div class="col-4" id="orderModeError"></div>
					</div>


					<!-- 2nd input -->
					<div class="row">
						<div class="col-4">
							<label for="orderCode">Order Code</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control"/>
						</div>
						<div class="col-4" id="orderCodeError"></div>
					</div>

					<!-- 3rd input -->
					<div class="row">
						<div class="col-4">
							<label for="orderType">Order Type</label>
						</div>
						<div class="col-4">
							<form:select path="orderType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
						</div>
						<div class="col-4" id="orderTypeError"></div>
					</div>

					<!-- 4th input -->
					<div class="row">
						<div class="col-4">
							<label for="orderAccept">Order Accept</label>
						</div>
						<div class="col-4">

							<form:checkbox path="orderAccept" value="Multi-Model" />
							Multi-Model
							<form:checkbox path="orderAccept" value="Accept Return" />
							Accept Return

						</div>
						<div class="col-4" id="orderAcceptError"></div>
					</div>

					<!-- 5th input -->
					<div class="row">
						<div class="col-4">
							<label for="description" >Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control" />
							

						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>


					<input type="submit" value="Create Order Method" class="btn btn-success"/>
				</form:form>
			</div>
			<!-- card body ends here -->


			<c:if test="${null ne message }">
				<div class="card-footer text-white bg-info">
				<b>${message}</b></div>
			</c:if>
			<!-- card footer ends here -->

		</div>

	</div>
	<script type="text/javascript" src="../resources/js/order.js"></script>
</body>
</html>




