<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h3>Welcome to Documents page</h3>
<form action="upload" method="POST" enctype="multipart/form-data">
<pre>
ID  : <input type="text" name="fid"/>
DOC : <input type="file" name="fdoc"/>
  <input type="submit" value="Upload"/>
</pre>
</form>
<table border="1">
	<tr>
		<td>FileName</td>
		<td>Link</td>
	</tr>
	
	<c:forEach items="${list}" var="ob">
		<tr>
			<td>${ob[1]}</td>
			<td>
			<a href="download?fid=${ob[0]}">Download</a>
			</td>
		</tr>
	</c:forEach>
	
</table>

</body>
</html>




