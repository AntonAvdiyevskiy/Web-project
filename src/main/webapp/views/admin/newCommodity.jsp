<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<script src="/js/jquery-3.1.1.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="css/validation-category.css">
<c:forEach var="commodity" items="${commodities}" > 
${commodity.name} ${commodity.color} ${commodity.price} ${commodity.ageOfProduction} 

<a href="deleteCommodity/${commodity.id}">delete</a> 
<br> 




</c:forEach > 


 <%-- <sf:form modelAttribute="commodity" action="saveCommodity" method="post" > 
<p><sf:input path="name" type="text" placeholder="name"/> </p> 
<p><sf:input path="color" type="text" placeholder="color"/> </p> 
<p><input name="price" type="number" placeholder="price" /> </p> 
<p><input name="ageOfProduction" type="number" placeholder="age of production"/> </p> 


<sf:select path="categoryOfCommodity" items="${categoriesOfCommodity}" itemLabel="type" 
itemValue="id"> 
</sf:select> 

<sf:select path="producer"> 
<c:forEach var="producer" items="${producers}"> 
<sf:option value="${producer.id}">${producer.name}</sf:option>
 
</c:forEach> 
</sf:select> 
 

<input type="submit" value="save commodity" />


</sf:form>  --%>

<sf:form modelAttribute="commodity" action="saveCommodity" method="post" > 
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">

<div class="testbox">
  <h1>New Commodity</h1>

  <form>
   <label for="name">${commodityException}</label>
  <sf:input path="name" type="text" placeholder="name" required="required"/> 
<sf:input path="color" type="text" placeholder="color" required="required"/> 
<input name="price" type="text" placeholder="price" pattern="^[ 0-9]+$" required="required" />  
<input name="ageOfProduction" type="text" placeholder="age of production" pattern="^[ 0-9]+$" required="required"/>


<sf:select path="categoryOfCommodity" items="${categoriesOfCommodity}" itemLabel="type" 
itemValue="id"> 
</sf:select> 

<sf:select path="producer"> 
<c:forEach var="producer" items="${producers}"> 
<sf:option value="${producer.id}">${producer.name}</sf:option>
 
</c:forEach> 
</sf:select> 
  
   
  <input type="submit" value="save producer">
   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
  </form>
</div>	  
						
	
	
	
	
	</sf:form>
	























<%-- <br>
<img src="${commodity.commodityImage}" alt="add foto" width="500px" height="500px">
<br>
<form:form action="./saveCommodityImage?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">
	<input type="file" name="image">
	<button>save image</button>
</form:form> --%>
<%------------------
	<%--  <c:forEach var="commodity" items="${commodities}" >
			${commodity.name} ${commodity.color} ${commodity.price} ${commodity.ageOfProduction}  
			    
			<a href="deleteCommodity/${commodity.id}">delete</a> 
			<br> 
			
			


	</c:forEach>
	
	
	  <sf:form modelAttribute="commodity" action="saveCommodity" method="post">
	<p><sf:input path="name" type="text" placeholder="name"/> </p>
	<p><sf:input path="color" type="text" placeholder="color"/> </p>
	<p><input name="price" type="number" placeholder="price" /> </p>
	<p><input name="ageOfProduction" type="number" placeholder="age of production"/> </p>
	<!-- <p><input name="dateOfProducing" type="date" /> </p> -->
	
	<sf:select path="categoryOfCommodity" items="${categoriesOfCommodity}" itemLabel="type"
			itemValue="id">
		</sf:select>

		<sf:select path="producer">
			<c:forEach var="producer" items="${producers}">
				<sf:option value="${producer.id}">${producer.name}</sf:option>
			</c:forEach>
		</sf:select>
	
	
	<p><input type="submit" value="save commodity" /> </p>
	
	
	
	
	</sf:form>  --%>  
	<%-- <p><input path="name" type="text" placeholder="name"/> </p>
	<p><input path="color" type="text" placeholder="color"/> </p>
	<p><input name="price" type="number" placeholder="price" /> </p>
	<p><input name="ageOfProduction" type="number" placeholder="age of production"/> </p>
	<!-- <p><input name="dateOfProducing" type="date" /> </p> -->
	
	<select path="categoryOfCommodity" items="${categoriesOfCommodity}" itemLabel="name"
			itemValue="id">
			<c:forEach var="category" items="${categoriesOfCommodity}">
				<option value="${category.id}">${category.type}</option>
			</c:forEach>
		</select>

		<select path="producer">
			<c:forEach var="producer" items="${producers}">
				<option value="${producer.id}">${producer.name}</option>
			</c:forEach>
		</select>
	 --%>
	
	<!-- <p><input type="submit" value="save commodity" /> </p> -->
	<!-- <button id="saveCommodity">save commodity</button -->>
	
	<!-- <script src="/js/commodity.js"></script> -->
	
	
	
	
	 
<%-- 	<sf:form modelAttribute="commodity" action="saveCommodity" method="post">
	<sf:input path="name" placeholder="name"/>
	<sf:input path="color" placeholder="color"/>
	<input name="dateOfProducing" type="number"/>
	<input name="price" type="date"/>
	<button>save commodity</button>
		
	
	<select name="categoryOfCommodityId" multiple="multiple">
			<option>choose Category</option>
			<c:forEach var="category" items="${categoryOfCommodities}">
				
				<option value="${category.id}">${category.name} ${acousticGuitar.amountOfStrings}
			${acousticGuitar.color} ${acousticGuitar.type}}</option>
				
			</c:forEach>
			
		</select>
			
	
	
	
	
	
	</sf:form>
	  ------------------------------------------------%>
	<!-- <form action="saveCommodity" method="post">
	
		<input name="name" placeholder="commodity"> <br>
		<input name="price" placeholder="price"> <br>
		<input name="availability" placeholder="availability"> <br>
		<
		<button>save  Commodity</button>
	
	
	
	</form> -->
	

