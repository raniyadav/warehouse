<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Welcome to Grn Data Page</h1>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr class="bg-warning ">
						<td>CODE</td>
						<td>GRNTYPE</td>
						<td>PURCHASE CODE</td>
						<td>NOTE</td>
						<td colspan='3'>OPERATIONS</td>
					</tr>
					<c:forEach items="${list}" var="ob">
						<tr>
							<td><c:out value="${ob.code}" /></td>
							<td><c:out value="${ob.grnType}" /></td>
							<td><c:out value="${ob.purchase.orderCode}" /></td>
							<td><c:out value="${ob.note}" /></td>
							<td><a href='parts?id=${ob.id}'>PARTS</a></td>
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
