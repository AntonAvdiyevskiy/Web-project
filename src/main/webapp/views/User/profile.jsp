<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
<link rel="stylesheet" href="css/profile.css">

${customer.login} ${customer.mail} 

<h1><center>Your Commodities</center></h1>
<c:forEach var="commodity" items="${customer.commodities}">

	<ul class="photo-stack-grid">
  <li>
    <a href="#d">
      <figure class="photo-stack">
          
          
        <!-- 
            ***change aspect ratio of image - /200/400*** 
        -->
        <img src="https://58eca9fdf76150b92bfa-3586c28d09a33a8c605ed79290ca82aa.ssl.cf3.rackcdn.com/Fender-2016-Deluxe-Stratocaster-2-Colour-Sunburst-Rosewood-359834.jpg" />
          
          
      </figure>
      ${commodity.name}
      
      <p>${commodity.price}$</p>
     
	  <a href="deleteCommodityFromCustomer/${commodity.id}">delete</a> 
	</a>

</li>
</ul>
<br>

</c:forEach> 
<img src="${customer.pathImage}" alt="add foto" width="300px" height="300px">

<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">
	<input type="file" name="image" required="required">
	<button>save image</button>
	
</form:form>


<a href="updateProfile" class="button3">update profile</a>