<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Third Party Auditor | Change password </title>
	<!--fonts-->
		<link href='//fonts.googleapis.com/css?family=Francois+One' rel='stylesheet' type='text/css'>
		<link href='//fonts.googleapis.com/css?family=Cabin:400,500,600,700' rel='stylesheet' type='text/css'>		
		 <link href='//fonts.googleapis.com/css?family=Audiowide' rel='stylesheet' type='text/css'>
	<!--//fonts-->
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
			<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
	
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
		<script type="text/javascript" src="js1/bootstrap.min.js"></script>
	
	<!-- js -->
	
	
	
	
</head>
<body>

<%

int id=0;
HttpSession session1=request.getSession();

String uname=(String)session1.getAttribute("uname");
if(uname==null )
{

	response.sendRedirect("login.jsp?msg=Login Frist...!");
}else{
	 id=(Integer)session1.getAttribute("id");
}


%>
<!-- header -->
<div class="header">
	 <div class="container">
		 <div class="logo">
			   <h1><a href="userWel.jsp">Third Party Auditor</a></h1>
		 </div>	
		 <div class="top-menu">
			 <span class="menu"></span>
			  <ul>
				 <li ><a href="userWel.jsp">HOME</a></li>
				 <li><a href="uploadFile.jsp">UPLOAD FILE</a></li>
				  <li><a href="userDownload.jsp">DOWNLOAD</a></li>
				    <li ><a href="alertMessage.jsp">Alert</a></li>
				 <li class="active"><a href="changePass.jsp">CHANGE PASSWORD</a></li>
				  <li><a href="LogoutServlet">SIGNOUT</a></li>
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
		


	<div class="modal-content login-modal" style="width:325px; height:300px; background-color:white; margin-left:400px; margin-top:80px;">
	  <form class="form-horizontal" role="form" action="ChangePassServlet" method="post">
	   <h1 class="form-login-heading" style="margin: 0;
	padding: 25px 20px;
	text-align: center;
	background: #68dff0;
	border-radius: 5px 5px 0 0;
	-webkit-border-radius: 5px 5px 0 0;
	color: #fff;
	font-size: 20px;
	text-transform: uppercase;
	font-weight: 300;">Change Password</h1>
	<br>
		<p style="color:red;">${message }</p>
       
  <div class="form-group">
    <div class="col-sm-11" style="margin-left:18px;"> 
      <input type="password" class="form-control" placeholder="Original Password" id="orgPwd" name="orgPwd" pattern="[A-z0-9]{8,8}" maxlength="8" minlength="8">
    </div>
  </div>
   <div class="form-group">
    <div class="col-sm-11" style="margin-left:18px;"> 
      <input type="password" class="form-control" id="newPwd" name="newPwd" placeholder="new Password" required="required" pattern="[A-z0-9]{8,8}" maxlength="8" minlength="8">
    </div>
  </div>
   <div class="form-group">
     <div class="col-sm-11" style="margin-left:18px;"> 
      <input type="password" class="form-control" id="confirmPwd" name="confirmPwd" placeholder="confirm Password" required="required" pattern="[A-z0-9]{8,8}" maxlength="8" minlength="8">
    </div>
  </div>
   
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
   <!--    <button type="submit" class="btn btn-default">Submit</button> -->
    <button class="btn btn-primary" type="Reset" style="margin-left:-50px; width:55%; background: #68dff0; color:#fff;">Reset</button>
     <button class="btn btn-primary" type="submit" style="margin-left:110px; margin-top:-53px; width:55%; background: #68dff0; color:#fff;">Submit</button>
    </div>
  </div>
 
</form>
		 
		 </div>
 </div>
</div>
		 
		 
		 	 <br><br><br><br><br><br>
		 
	
		 
		 <!--footer-->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
			 <p>© 2018 Third Party Auditor. All rights reserved | Developed by <a href="#"></a></p>
		 </div>
		 <div class="footer-menu">
			<ul>
				 <li ><a href="index2.jsp">HOME</a></li>
				 <li><a href="uploadFile.jsp">UPLOAD FILE</a></li>
				  <li><a href="userDownload.jsp">DOWNLOAD</a></li>
				 <li class="active"><a href="changePass.jsp">CHANGE PASSWORD</a></li>
				  <li><a href="index.jsp">SIGNOUT</a></li>
			 </ul>	
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>

<!-- //footer -->
</body>
</html>