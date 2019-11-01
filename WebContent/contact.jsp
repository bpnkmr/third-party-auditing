<%@page import="util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
		<title>ThirdPartyAuditor| CONTACT</title>
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
		<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- js -->
</head>
<body>
<!-- header -->
<div class="header">
	 <div class="container">
		 <div class="logo">
			   <h1><a href="index.jsp">ThirdPartyAuditor</a></h1>
		 </div>	
		 <div class="top-menu">
			 <span class="menu"></span>
			 <ul>
				 <li><a href="index.jsp">HOME</a></li>
				  <li><a href="login.jsp">USER</a></li>
			      <li><a href="serverLogin.jsp">SERVER</a></li>
			      <li><a href="tpaLogin.jsp">TPA</a></li>
			          
				
				 <li><a href="register.jsp">REGISTER</a></li>
				  <li><a href="about.jsp">ABOUT US</a></li>
				
				  <li class="active"><a href="contact.jsp">CONTACT</a></li>
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
			 <a href="#"><i class="facebook"></i></a>
			 <a href="#"><i class="twitter"></i></a>
			 <a href="#"><i class="dribble"></i></a>	
			 <a href="#"><i class="google"></i></a>	
			 <a href="#"><i class="youtube"></i></a>	
	 </div>
		<div class="clearfix"></div>
		</div>
</div>
<!-- banner -->
<!-- //header -->
<div class="container">
		<!--  <ol class="breadcrumb">
		  <li><a href="index.jsp">Home</a></li>
		  <li class="active">Contact</li>
		 </ol> -->
</div>
<!-- //header -->
<div class="contact">
	 <div class="container">
		 <div class="contact-grids">
			 <h2>CONTACT</h2>
			 
		 <form>
				<input type="text" placeholder="Name" required=" ">
				<input type="text" placeholder="Email" required=" ">
				<input type="text" placeholder="Website" required=" ">
				<textarea placeholder="Message..." required=" "></textarea>
				<input type="submit" value="SEND">
			 </form>
			 
			 	  <div class="contact-icons">
				<div class="contact-grid">
					<div class="contact-fig">
						<span> </span>
					</div>
					<p>7385331011</p>
				</div>
				<div class="contact-grid">
					<div class="contact-fig1">
						<span> </span>
					</div>
					<p>Chinchwad Station
						<span>pune 411019</span></p>
				</div>
				<div class="contact-grid">
					<div class="contact-fig2">
						<span> </span>
					</div>
					<p><a href="mominbilalse444@gmail.com">mominbilalse444@gmail.com</a></p>
				</div>
				<div class="clearfix"> </div>
			 </div>
			 
			 
		 </div>
	 </div>
</div>


<!--footer-->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
			 <p>© 2019 Third Party Auditor. All rights reserved | <a href="#"></a></p>
	 </div>
		 <div class="footer-menu">
			 <ul>
				 <li><a href="index.jsp">HOME</a></li>
				  <li><a href="login.jsp">USER</a></li>
			      <li><a href="serverLogin.jsp">SERVER</a></li>
			      <li><a href="tpaLogin.jsp">TPA</a></li>
			          
				
				 <li><a href="register.jsp">REGISTER</a></li>
				  <li><a href="about.jsp">ABOUT US</a></li>
				
				  <li class="active"><a href="contact.jsp">CONTACT</a></li>
			 </ul>			
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!-- //footer -->
</body>
</html>