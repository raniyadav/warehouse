<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%@include file="UserMenu.jsp" %>
<div class="container">
<table class="table table-bordered bg-info text-white">
<tr>
 <td> <b>Order Code: ${parent.orderCode}</b></td>
</tr>
<tr> 
 <td><b>Status    : ${parent.status}</b></td>
</tr>
</table>

<c:if test="${parent.status eq 'OPEN' || parent.status eq 'PICKING' }">
<h3>Choose Parts Here</h3>
<form:form action="add" method="POST" modelAttribute="purchaseDtl">
<pre>
PART: <form:select path="part.id" class="form-control">
	<form:option value="">-SELECT-</form:option>
	<form:options items="${parts}"/>
</form:select>
QNTY: <form:input path="qty" class="form-control"/>
<form:hidden path="parent.id"/>
<input type="submit" value="Add" class="btn btn-success"/>
</pre>
</form:form>
</c:if>

<table class="table">
	<tr>
		<th>Slno</th>
		<th>Part</th>
		<th>Base Cost</th>
		<th>Qnty</th>
		<c:if test="${parent.status eq 'PICKING' }">
		<th>Operation</th>
		</c:if>
	</tr>
	<c:forEach items="${parent.childs}" var="ob">
		<tr>
			<td><c:out value="${ob.slno}"/> </td>
			<td><c:out value="${ob.part.code}"/> </td>
			<td><c:out value="${ob.part.baseCost}"/> </td>
			<td><c:out value="${ob.qty}"/> </td>
			<td>
				<c:if test="${parent.status eq 'PICKING' }">
				<a href="remove?id=${parent.id}&dtlId=${ob.id}">
				  <img src="../resources/images/delete.png" width="35" height="35">
				</a>
				</c:if>
			</td>
		</tr> 
	</c:forEach>
</table>
<c:if test="${parent.status eq 'PICKING'}">
	<a href="updateStatus?id=${parent.id}&status=ORDERED" class="btn btn-success">PLACE ORDER</a>
</c:if>
</div>
</body>
</html>







