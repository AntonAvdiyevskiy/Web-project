<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
     <link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="css/validation-category.css">
<!-- !DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Producer</title>
</head>
<body> -->
		<c:forEach var="producer" items="${producers}" >
			${producer.name} ${producer.countryName}
			 
			<a href="deleteProducer/${producer.id}">delete</a> 
			<br> 


	</c:forEach>
	<%-- <form:form modelAttribute="producer" action="saveProducer" method="post">
	
		<form:input path="name" type="text" placeholder="name of Producer"/><br> 
		<form:input path="countryName" type="text" placeholder="country"/> <br>
		<input type="submit" value="save producer">
			
			
			
			
				
		
	
				
	
	</form:form> --%>
	<sf:form modelAttribute="producer" action="saveProducer" method="post">
				<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">

<div class="testbox">
  <h1>New Category</h1>

  <form>
   
  
		<label for="name">${producerException}</label>
		<sf:input path="name" type="text" placeholder="name of Producer" required="required"/><br> 
		<label for="countryName">${countryException}</label>
		<sf:input path="countryName" type="text" placeholder="country" required="required"/> <br>
  
   
  <input type="submit" value="save producer">
   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
  </form>
</div>	  
						
	
	
	
	
	</sf:form>
	


	


<!-- </body>
</html> -->