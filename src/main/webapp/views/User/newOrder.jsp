<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="orders" items="${orders}" >
			${orders.name} ${orders.priceOfCommodity}
			 
			<a href="deleteOrders/${orders.id}">delete</a> 
			<br> 


	</c:forEach>
	<form action="saveOrders" method="post">
	
		<input name="name" placeholder="order"> <br>
		<input name="priceOfCommodity" placeholder="price of order"> <br>
		
		<button>save  order</button>
	
	
	
	</form>


	

</body>
</html>