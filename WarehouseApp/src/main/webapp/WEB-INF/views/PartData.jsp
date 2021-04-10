<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h3>Welcome to Part Data Page</h3>
<table border="1">
	<tr>
		<td>ID</td>
		<td>CODE</td>
		<td>COST</td>
		<td>UOM</td>
		<td>SALE</td>
		<td>PURCHASE</td>
		
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td><c:out value="${ob.id }"/> </td>
			<td><c:out value="${ob.code }"/> </td>
			<td><c:out value="${ob.baseCost }"/> </td>
			<td><c:out value="${ob.uom.uomModel }"/> </td>
			<td><c:out value="${ob.omSale.orderCode }"/> </td>
			<td><c:out value="${ob.omPurchase.orderCode }"/> </td>
		</tr>
	</c:forEach>
</table>
</body>
</html>

