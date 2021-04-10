<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
<%@include file="UserMenu.jsp" %>
	<h3>welcome to UOM Data Page</h3>
	<a href="excel">
	<img src="../resources/images/BulkExcel.png"
				width="60" height="30"/> </a>
	<a href="pdf">
	<img src="../resources/images/BulkPdf.png"
			width="80" height="35"/></a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>MODEL</th>
			<th>TYPE</th>
			<th colspan="3">OPERATION</th>
		</tr>

		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob.id }" /></td>
				<td><c:out value="${ob.uomModel }" /></td>
				<td><c:out value="${ob.uomType }" /></td>
				
				<td>
					<a href="delete?id=${ob.id}">
					<img src="../resources/images/delete.png"
						width="25" height="25"
					/>
					</a>
                </td>
                <td>					
					<a href="edit?id=${ob.id}">
						<img src="../resources/images/edit.png"
						width="25" height="25"
					/>
					</a>
				</td>
				<td>
					<a href="view?id=${ob.id}">
						<img src="../resources/images/view.png"
						width="25" height="25"
					/>
					</a>
				</td>
			</tr>
		</c:forEach>

	</table>
  ${msg}
</body>
</html>



