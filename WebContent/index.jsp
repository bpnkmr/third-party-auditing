<%@page import="util.CoverImg"%>
<%@page import="util.ConstantMessage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html>
<head>
	<title>ThirdPartyAuditor| Home</title>
	<!-- for dropdown login -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="js1/jquery.min.js"></script>
  <script src="js1/bootstrap.min.js"></script>
  
	<!--fonts-->
		<link href='//fonts.googleapis.com/css?family=Francois+One' rel='stylesheet' type='text/css'>
		<link href='//fonts.googleapis.com/css?family=Cabin:400,500,600,700' rel='stylesheet' type='text/css'>	
	   <link href='//fonts.googleapis.com/css?family=Audiowide' rel='stylesheet' type='text/css'>		
	<!--//fonts-->		
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- for-mobile-apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Soccer Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //for-mobile-apps -->
	<!-- js -->
		<script src="js/jquery.min.js"></script>
	<!-- js -->
</head>
<body>
<!-- header -->
<div class="header">
	 <div class="container">
		 <div class="logo">
			   <h1><a href="index.jsp">Third Party Auditor</a></h1>
		 </div>	
		 <div class="top-menu">
			 <span class="menu"></span>
			  <ul>
				 <li class="active"><a href="index.jsp">HOME</a></li>
				  <li><a href="login.jsp">USER</a></li>
			      <li><a href="serverLogin.jsp">SERVER</a></li>
			      <li><a href="tpaLogin.jsp">TPA</a></li>
			          
				
				 <li><a href="register.jsp">REGISTER</a></li>
				  <li><a href="about.jsp">ABOUT US</a></li>
				
				  <li><a href="contact.jsp">CONTACT</a></li>
			 </ul>			 
		 </div>			
		 <!-- script-for-menu -->
		 <script>
				$("span.menu").click(function(){
					$(".top-menu ul").slideToggle("slow" , function(){
					});
				});
		 </script>
		 <!-- script-for-menu -->	  	

		 <div class="clearfix"></div>
	 </div>
</div>
<!-- //header -->
<!-- banner -->
<div class="strip">
	 <div class="container">
	 <div class="search">
		    <form>
		    	<input type="text" value="" placeholder="Search...">
				<input type="submit" value="">
			</form>
     </div>     
	 <div class="social">			 
			 <a href=""><i class="facebook"></i></a>
			 <a href="#"><i class="twitter"></i></a>
			 <a href="#"><i class="dribble"></i></a>	
			 <a href="#"><i class="google"></i></a>	
			 <a href="#"><i class="youtube"></i></a>	
	 </div>
		<div class="clearfix"></div>
		</div>
</div>
<!-- banner -->
<div class="banner">
		<script src="js/responsiveslides.min.js"></script>
  <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 300,
        manualControls: '#slider3-pager',
      });
    });
  </script>

 <div class="slider">
	  <div class="callbacks_container">
	     <ul class="rslides" id="slider">
	         <li>
				   <img src="images/bnrr3.jpg" alt="">
				  <div class="banner-info">
				  <h3>Our System Benefits:</h3>
				  <p>It allows the client to verify the integrity of the data stored on download or retrieval of its own stored data in cloud. </p>
				  </div>
	         </li>
	         <li>
				 <img src="images/wal4.jpg" alt="">
	        	 <div class="banner-info">
				 <h3>Our System Benefits:</h3>
				  <p>It reliefs the client from maintaining any kind of key information and allowing the client for using any browser enabled device to access the cloud services.</p>
				  </div>
			 </li>
	         <li>
	             <img src="images/wal3.jpg" alt="">
	        	 <div class="banner-info">
				  <h3>Our System Benefits:</h3>
				  <p>The client can share the data securely with specific band of people without any overhead of key distribution.</p>
				  </div>
	         </li>
	      </ul>
	  </div>
  </div>

		<%
		CoverImg.check();
		%>	
	<!--footer-->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
			 <p>© 2019 Third Party Auditor. All rights reserved | <a href="#"></a></p>
	 </div>
		 <div class="footer-menu">
			 <ul>
				 <li class="active"><a href="index.jsp">HOME</a></li>
				  <li><a href="login.jsp">USER</a></li>
			      <li><a href="serverLogin.jsp">SERVER</a></li>
			      <li><a href="tpaLogin.jsp">TPA</a></li>
			          
				
				 <li><a href="register.jsp">REGISTER</a></li>
				  <li><a href="about.jsp">ABOUT US</a></li>
				
				  <li><a href="contact.jsp">CONTACT</a></li>
			 </ul>			
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!-- //footer -->
</body>
</html>