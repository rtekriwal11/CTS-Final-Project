<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="/css/bootstrap.min.css"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- <link rel="stylesheet" href="/css/name.css/" type="text/css" />
<script src="/js/bootstrap.min.js"></script>
 -->
 <style type="text/css">
		body{
			background-image: url('/image/homemedium.jpg');
			background-size: 1040px 650px;
			/*background-size: cover;
  -webkit-filter: blur(8px);
			background-position: center;
			*/
		}
		.col-6{
			width: 40%;
			opacity: 0.9;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="container" style="margin-top: 300px;">
		<div class="row justify-content-md-center ">
			<div class="card col-6 "><!--  style="width: 40%;opacity: 0.9"> -->
		 		<!-- <img class="card-img-top" src="" alt="Card image cap" style="background-size: 200px 200px"> -->
  		  		<div class="card-body">
    				<h5 class="card-title" style="text-align: center;">View Schedule</h5>
    			<p class="card-text">
    			<!-- <p style="font-size: 15px"></p> -->
    			<p style="text-align: center;">Click to view Medical Representative Schedule</p> 
    			</p>
    			<a href="checkSchedule" class="btn btn-primary" style="margin-left: 95px;">View Schedule</a>
    			</div>
			</div>
<!-- opacity: 0.9;width: 40%;  -->
			<div class="card col-6" style="margin-left: 20px;">
		  		<!-- <img class="card-img-top" src="..." alt="Card image cap"> -->
  		   		<div class="card-body">
    			<h5 class="card-title" style="text-align: center;">Place Demand</h5>
    			<p class="card-text">
    			<!-- <p style="font-size: 15px"></p> -->
    			<p style="text-align: center;">Place the medicine demand from stock
    			</p> 
    			</p>
    			<a href="/viewDemand" class="btn btn-primary" style="margin-left: 95px;">Place Demand</a>
  		  		</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>