<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Welcome to Purchase Data Page</h1>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr class="bg-warning ">
						<td>ID</td>
						<td>ORDERCODE</td>
						<td>SHIPMENT CODE</td>
						<td>VENDOR</td>
						<!-- <td>REFNUM</td>
						<td>QLTYCHECK</td> -->
						<td>STATUS</td>
						<!-- <td>NOTE</td> -->
						<td colspan='3'>OPERATIONS</td>
					</tr>
					<c:forEach items="${list}" var="ob">
						<tr>
							<td><c:out value="${ob.id}" /></td>
							<td><c:out value="${ob.orderCode}" /></td>
							<td><c:out value="${ob.shipmentType.code}" /></td>
							<td><c:out value="${ob.vendor.code}" /></td>
							<%-- <td><c:out value="${ob.refNum}" /></td>
							<td><c:out value="${ob.qltyCheck}" /></td> --%>
							<td><c:out value="${ob.status}" /></td>
							<%-- <td><c:out value="${ob.note}" /></td> --%>
							
							<td>
							<c:choose>
								<c:when test="${ob.status eq 'ORDERED' }">
									<a href="updateStatus?id=${ob.id}&status=INVOICED" class="btn btn-info">Get Invoice</a>
								</c:when>
								<c:when test="${ob.status eq 'INVOICED' || ob.status eq 'RECEIVED' }">
									<a href="venInvoice?id=${ob.id}" class="btn btn-info">Print Invoice</a>
								</c:when>
							</c:choose>
							<a href='parts?id=${ob.id}'>
							  <img src="../resources/images/items.png" width="35" height="35">
							  </a></td>
							<td><a href='delete?id=${ob.id}'>DELETE</a></td>
							<td><a href='edit?id=${ob.id}'>EDIT</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="card-footer bg-info text-white">
				<b>${message}</b>
			</div>
		</div>
	</div>
</body>
</html>
