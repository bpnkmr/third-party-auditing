<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
	<title>Third Party Auditor | Upload File </title>
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
<%
HttpSession session1=request.getSession();

String uname=(String)session1.getAttribute("uname");

if(uname==null)
{

	response.sendRedirect("login.jsp?msg=Login Frist...!");
}
%>





<!-- header -->
<div class="header">
	 <div class="container">
		 <div class="logo">
			   <h1><a href="uploadFile.jsp">Third Party Auditor</a></h1>
		 </div>	
		 <div class="top-menu">
			 <span class="menu"></span>
			   <ul>
				 <li ><a href="uploadFile.jsp">HOME</a></li>
				 <li><a href="uploadFile.jsp">UPLOAD FILE</a></li>
				  <li><a href="userDownload.jsp">DOWNLOAD</a></li>
				    <li ><a href="alertMessage.jsp">ALERT</a></li>
				 <li><a href="changePass.jsp">CHANGE PASSWORD</a></li>
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
		<!--  <ol class="breadcrumb">
		  <li><a href="index.jsp">Home</a></li>
		  <li class="active">About</li>
		 </ol> -->
		 


	<div class="modal-content login-modal" style="width:325px; height:280px; background-color:white; margin-left:400px; margin-top:80px;">
	  <form class="form-horizontal" role="form" action="UploadFileServlet" method="post" enctype="multipart/form-data">
	   <h1 class="form-login-heading" style="margin: 0;
	padding: 25px 20px;
	text-align: center;
	background: #68dff0;
	border-radius: 5px 5px 0 0;
	-webkit-border-radius: 5px 5px 0 0;
	color: #fff;
	font-size: 20px;
	text-transform: uppercase;
	font-weight: 300;">Upload here</h1>
	<br>
		<p style="color:red;">${message }</p>
      <br>
         <div style="margin-left:20px;">
     <input type="file"  id="file" name="file" required="required">
         </div>
      
 <br><br>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
 
     <button class="btn btn-primary" type="Reset" style="margin-left:-50px; width:55%; background: #68dff0; color:#fff;">Reset</button>
     <button class="btn btn-primary" type="submit" style="margin-left:110px; margin-top:-53px; width:55%; background: #68dff0; color:#fff;">Submit</button>
    </div>
  </div>
  <div id="message" style="margin-top:-50px; ">
  <p style="margin-left;30px;"></p>
  
  </div>
 
</form>
		 
		 </div>
 
		 
		 
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
		 
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
				 <li><a href="changePass.jsp">CHANGE PASSWORD</a></li>
				  <li><a href="index.jsp">SIGNOUT</a></li>
			 </ul>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
</div>
</div>
<!-- //footer -->

<script type="text/javascript">
		$(document).ready(function() {
							document.oncontextmenu = document.body.oncontextmenu = function() {
								return false;
							};

							$("#file").change(
									function() {

										var val = $(this).val();

										switch (val.substring(
												val.lastIndexOf('.') + 1)
												.toLowerCase()) {
										case 'txt':
										case 'pdf':
										case 'docx':
										case 'java':
										case 'pptx':
										case 'jpg':
										case 'png':
											$('#message').text("correct file")
													.css("color", "red");
											$('#message').addClass("info");

											break;
										default:
											$(this).val('');
											$('#message').text(
													"Please select only  file")
													.css("color", "red");
											;
											$('#message').addClass("warning");

											break;
										}
									});
							$('#btnUpload')
									.bind(
											"click",
											function() {
												var imgVal = $('#file').val();
												if (imgVal == '') {
													$('#message')
															.text(
																	"Please select your  file")
															.css("color", "red");
													;
													$('#message').addClass(
															"validation");
													return false;

												}

												else {

													$('form').submit();
												}

											});
						});
	</script>
	
	



</body>
</html>