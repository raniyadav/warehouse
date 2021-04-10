<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<div class="container">
<h3>Welcome to GRN PARTS</h3>
<table class="table table-bordered">
<tr>
	<th>ITEM CODE</th>
	<th>BASE COST</th>
	<th>QNTY</th>
	<th>ITEM VALUE</th>
</tr>
<c:forEach items="${childs}" var="ob">
	<tr>
		<td><c:out value="${ob.itemCode}"/> </td>
		<td><c:out value="${ob.baseCost}"/> </td>
		<td><c:out value="${ob.qnty}"/> </td>
		<td><c:out value="${ob.itemVal}"/> </td>
		<td><a href="#" class="btn btn-success">ACCEPT</a></td>
		<td><a href="#" class="btn btn-danger">REJECT</a></td>
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>


