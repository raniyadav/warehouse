<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<%@include file="UserMenu.jsp" %>
<h3>welcome to Uom View one Page</h3>
<table border="1">
	<tr>
		<th>ID</th> <td>${ob.id}</td>
    </tr>
    <tr>		
		<th>TYPE</th> <td>${ob.uomType}</td>
    </tr>
    <tr>		
		<th>MODEL</th> <td>${ob.uomModel}</td>
    </tr>
    <tr>		
		<th>NOTE</th> <td>${ob.description}</td>
		
	</tr>
</table>

<a href="excel?id=${ob.id}">EXCEL</a>
<a href="pdf?id=${ob.id}">PDF</a>


</body>
</html>





