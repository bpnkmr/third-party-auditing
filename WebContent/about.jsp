
<%@page import="util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
	<title>Third Party Auditor | About </title>
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
			   <h1><a href="index.jsp">Third Party Auditor</a></h1>
		 </div>	
		 <div class="top-menu">
			 <span class="menu"></span>
			    <ul>
				 <li><a href="index.jsp">HOME</a></li>
				  <li><a href="login.jsp">USER</a></li>
			      <li><a href="serverLogin.jsp">SERVER</a></li>
			      <li><a href="tpaLogin.jsp">TPA</a></li>
			          
				
				 <li><a href="register.jsp">REGISTER</a></li>
				  <li class="active"><a href="about.jsp">ABOUT US</a></li>
				
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
<!-- about -->
<div class="about">
	 <div class="container">
		 <ol class="breadcrumb">
		  <li><a href="index.jsp">Home</a></li>
		  <li class="active">About</li>
		 </ol>
		 
		 <div class="about-grids">
			 <div class="about-grid">
				 <h3>WHO WE ARE</h3>
				 <p class="abt-info" align="justify">Using cloud storage, users can remotely store their data and enjoy the on-demand high-quality applications and services
from a shared pool of configurable computing resources, without the burden of local data storage and maintenance. However, the fact
that users no longer have physical possession of the outsourced data makes the data integrity protection in cloud computing a
formidable task, especially for users with constrained computing resources. Moreover, users should be able to just use the cloud
storage as if it is local, without worrying about the need to verify its integrity. Thus, enabling public auditability for cloud storage is of
critical importance so that users can resort to a third-party auditor (TPA) to check the integrity of outsourced data and be worry free. To
securely introduce an effective TPA, the auditing process should bring in no new vulnerabilities toward user data privacy, and introduce
no additional online burden to user. In this paper, we propose a secure cloud storage system supporting privacy-preserving public
auditing. We further extend our result to enable the TPA to perform audits for multiple users simultaneously and efficiently. Extensive
security and performance analysis show the proposed schemes are provably secure and highly efficient. Our preliminary experiment
conducted on Amazon EC2 instance further demonstrates the fast performance of the design
			</div>
			 <div class="about-pic">
				 <img src="images/Architecturetpa.jpg" height="500px" width="500px"/>
			 </div>
			 <div class="clearfix"></div>
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
				  <li class="active"><a href="about.jsp">ABOUT US</a></li>
				
				  <li><a href="contact.jsp">CONTACT</a></li>
			 </ul>			
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!-- //footer -->
</body>
</html>