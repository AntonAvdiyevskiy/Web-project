<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<link rel="stylesheet" href="css/list.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.mi.."></script>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home2.css">
<link rel="stylesheet" href="css/button.css">
</head> -->

	<%-- <input type="text" id ="search" placeholder="search">
	<div  id = "allCommodities">
		<c:forEach var="commodity" items="">
		
		
		</c:forEach>
	
	</div>
 --%>
<!-- <link rel="stylesheet" href="css/home2.css"> -->
<!-- 
 -->
 
 
 
 
 
 
 
<%--  <input type="text" id="liveSearch">
<div  id="allCommodities">
		<c:forEach var="commodity" items="${commodities}">
		${commodity.name}
		 <sec:authorize access="isAuthenticated()">
		 <sec:authorize access="!hasRole('ROLE_ADMIN')">

	



		<a href="buyCommodity/${commodity.id}" >buy</a>
				</sec:authorize>
        </sec:authorize>
		 
		</c:forEach>
	
	</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>
<script>
    document.getElementById('liveSearch').oninput = function () {
        var liveSearch = document.getElementById('liveSearch').value;
//        console.log(liveSearch);
        $.ajax({
            url: 'liveSearchCommodities?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: liveSearch,
            success: function (res) {
                var all = '';
                for (var i = 0; i < res.length; i++) {
                    all += res[i].name + ' ' + res[i].price + '<br>';
                }
                document.getElementById('allCommodities').innerHTML = all;
            }
        })
    }
</script>


  

 


<sec:authentication property="name"/>
<sec:authorize access="isAuthenticated()">
<form:form action="logout" method="post">
  
<button>logout</button>
</form:form>

</sec:authorize>
<br>
<sec:authorize access="!isAuthenticated()">
<a href="loginpage" style="color:grey" >login</a>


<br>
<a href="registration" style="color:grey">registration</a>
<br>
</sec:authorize>
<br>
 <sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="admin">admin page</a>

</sec:authorize>
 
<br>
<sec:authorize access="isAuthenticated()">
	<a href="profile">profile</a>
</sec:authorize>
<br>
 --%>


<c:forEach var="commodity" items="${commodities}">
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
       <sec:authorize access="isAuthenticated()">
		 <sec:authorize access="!hasRole('ROLE_ADMIN')">

		<h1><a href="buyCommodity/${commodity.id}" >buy</a></h1>
				</sec:authorize>
        </sec:authorize>
    </a>
  </li>
</ul>
		
        </c:forEach>
        <input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>
<script>
    document.getElementById('liveSearch').oninput = function () {
        var liveSearch = document.getElementById('liveSearch').value;
//        console.log(liveSearch);
        $.ajax({
            url: 'liveSearchCommodities?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: liveSearch,
            success: function (res) {
                var all = '';
                for (var i = 0; i < res.length; i++) {
                    all += res[i].name + ' ' + res[i].price + '<br>';
                }
                document.getElementById('allCommodities').innerHTML = all;
            }
        })
    }
</script>


  

 


<%-- <sec:authentication property="name"/> --%>
<sec:authorize access="isAuthenticated()">
<form:form action="logout" method="post">
  
<button class = "button1">logout</button>
</form:form>

</sec:authorize>
<br>

 <sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="admin">admin page</a>

</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">

	<a href="profile" class="button2">profile</a>

</sec:authorize>
 
<br>
<%-- sec:authorize access="isAuthenticated()">
	<a href="profile" class="button2">profile</a>
</sec:authorize> --%>
<br>
























<!-- <body >
	
	<button  class="btn btn-6 btn-6d" ><a href="newCommodity" >add commodity</a></button>
	<br>
	<br>
	<button class="btn btn-6 btn-6d"><a href="newCategoryOfCommodity">add  category</a></button>
	<br>
	
	
	
	<br>
	<button class="btn btn-6 btn-6d"><a href="newCustomer">add  customer </a></button>
	<br>
	<br>
	<button class="btn btn-6 btn-6d"><a href="newOrder">add  order</a></button>
	<br>
	<br>
	<button class="btn btn-6 btn-6d"><a href="newProducer">add  producer</a></button>
	<br>
	<br>
	
	
	
	
	<img class="banner-suggest-e js-banner-suggest" src="http://s.cdpn.io/6859/music-time-suggest.png" alt="" />
<img class="banner-e js-banner" src="http://s.cdpn.io/6859/music-time.png" alt="" />

<img src="http://s.cdpn.io/6859/guitar.png" id="guitar" alt="" class="guitar-image-e">
    <canvas id="myCanvas" class="canvas-e"></canvas>
    <div class="twitter-icon-b">
      <div class="hover-circle-be"><a href="http://twitter.com/legomushroom" target="_blank" class="twitter-icon-text-be">@legomushroom</a></div>
      <div class="twitter-mask-be"></div>
      <div class="circle1-be"></div>
      <div class="circle2-be"></div>
      <div class="circle3-be"></div>
    </div>
    <div class="font-holder-e">&nbsp;</div>
    <div class="my-gui-container"></div>
  
  <audio src="http://s.cdpn.io/6859/a3.mp3"></audio>
	
	
	<script src="js/home.js"></script>
	
	
	<body>
  <b:if cond="data:blog.pageType != &quot;error_page&quot;">
    ... Daerah ini berisi bagian-bagian utama dalam sebuah blog seperti main-wrapper, sidebar-wrapper, hingga footer-wrapper. Daerah ini akan diabaikan karena kita berada di dalam kondisi pengingkaran. ...
  </b:if>
  <b:if cond="data:blog.pageType == &quot;error_page&quot;">
    <div id="container-error">
      <div class="minion">
        <div class="hands">
          <div class="left"></div>
          <div class="right"></div>
          <div class="fingers-l"></div>
          <div class="fingers-r"></div>
          <div class="glove-l"></div>
          <div class="glove-r"></div>
        </div>
        <div class="glasses">
          <div class="glassesline1"></div>
          <div class="glassesline2"></div>
          <div class="glass1">
            <div class="eye1"></div>
          </div>
          <div class="glass2">
            <div class="eye2"></div>
          </div>
        </div>
        <div class="mouth">
          <ul class="teeth">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
          </ul>
        </div>
        <div class="belt-left"></div>
        <div class="belt-right"></div>
        <div class="pants"></div>
        <div class="legs">
          <div class="left"></div>
          <div class="right"></div>
          <div class="shoe-l"></div>
          <div class="shoe-r"></div>
        </div>
      </div>
      <div id="buttonerror">
<a href="newCommodity">Add commodity</a>

<a href="newCategoryOfCommodity">add Category</a>

<a href="newCustomer">add customer</a>

<a href="newOrder">add order</a>

<a href="newProducer">add producer</a>
    </div>
    <div id="buttonerror"><a href="newCommodity">Add commodity</a></div>
    <div id="buttonerror1"><a href="newCategoryOfCommodity">add Category</a></div>
    <div id="buttonerror2"><a href="newCustomer">add customer</a></div>
    <div id="buttonerror3"><a href="newOrder">add order</a></div>
    <div id="buttonerror4"><a href="newProducer">add producer</a></div>
  </b:if>
</body>
</body> -->
<!-- </html> -->