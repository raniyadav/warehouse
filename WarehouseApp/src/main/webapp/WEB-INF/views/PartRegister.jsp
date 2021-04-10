<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h3>Welcome to Part Register Page!!</h3>
<form:form action="save" method="POST" modelAttribute="part">
<pre>
Code : <form:input path="code"/>
Dims: L : <form:input path="len" size="3"/>  W : <form:input path="wdth" size="3"/>   H : <form:input path="hght" size="3"/>
Base Cost:<form:input path="baseCost" size="3"/>
Base Curr: <form:select path="baseCurr">
				<form:option value="">-SELECT-</form:option>
				<form:option value="INR">INR</form:option>
				<form:option value="USD">USD</form:option>
			</form:select>      
Description: <form:textarea path="note"/>

UOM : <form:select path="uom.id">
		<form:option value="">-SELECT-</form:option>
		<form:options items="${uoms}"/>
	</form:select>

SALE: <form:select path="omSale.id">
		<form:option value="">-SELECT-</form:option>
		<form:options items="${sales}"/> 
	</form:select>
	
PURCHASE: <form:select path="omPurchase.id">
			<form:option value="">-SELECT-</form:option>
			<form:options items="${purchases}"/>
		</form:select>	
 <input type="submit" value="Register"/>
</pre>
</form:form>
${message}
</body>
</html>






