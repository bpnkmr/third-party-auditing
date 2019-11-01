<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.UserData"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>Third Party Auditor | User Download </title>
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
	
	
	<%
		String str=(String) request.getAttribute("check");
			if(str!=null)
			{
	%>
	<script type="text/javascript">
	alert(str);
	</script>
	<%
			}
	%>
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
			   <h1><a href="index.jsp">Third Party Auditor</a></h1>
		 </div>	
		 <div class="top-menu">
			 <span class="menu"></span>
			   <ul>
				 <li ><a href="index2.jsp">HOME</a></li>
				 <li><a href="uploadFile.jsp">UPLOAD FILE</a></li>
				  <li class="active"><a href="userDownload.jsp">DOWNLOAD</a></li>
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

<br><br><br>

<%
String UserFile=request.getParameter("name");
				 String userID=request.getParameter("id");
				 String FileID=request.getParameter("fileid");
%>
<div  class="modal-content login-modal" style="width:350px; height:450px;  margin-left:400px; margin-top:80px;">
	  <form class="form-horizontal" role="form" action="FileShareServlet" method="post">
	   <h1 class="form-login-heading" style="margin: 0;
	padding: 25px 20px;
	text-align: center;
	background: #68dff0;
	border-radius: 5px 5px 0 0;
	-webkit-border-radius: 5px 5px 0 0;
	color: #fff;
	font-size: 20px;
	text-transform: uppercase;
	font-weight: 300;">Share File</h1>
	<br>
		<p style="color:red; margin-left:30px;">${message }</p>
        <div class="form-group">
        <!--   <label class="control-label col-sm-2" for="UserName">UserName</label>
       -->    
           <div class="col-sm-11" style="margin-left:20px;">
              <!--   <input type="text" class="form-control" id="uname" name="userName" placeholder="UserName" required pattern="[A-za-z0-9]{2,10}">
             -->
           
            <select class="form-control" name="userid">
             <%
            UserData ud=new UserData();
          ResultSet rs=  ud.getUserList();
          while(rs.next())
          {
            %>
            <option value="<%=rs.getString(1) %>"><%=rs.getString(2) %></option>
            <%
          }
            %>
            
            </select>
            
            </div>
       </div>
  <div class="form-group">
   <!--  <label class="control-label col-sm-2" for="pwd" >Password:</label>
  -->   <div class="col-sm-11" style="margin-left:20px;"> 
    	     <input type="text" class="form-control" id="Filename" name="Filename" placeholder="Filename" required value="<%=UserFile%>">
       
      </div>
  </div>
  
   <div class="form-group">
   <!--  <label class="control-label col-sm-2" for="pwd" >Password:</label>
  -->   <div class="col-sm-11" style="margin-left:20px;"> 
    	     <input type="hidden" class="form-control" id="Filename" name="Fileid" placeholder="Filename" required value="<%=FileID%>">
       
      </div>
  </div>
  
  
  <div class="form-group">
   <!--  <label class="control-label col-sm-2" for="pwd" >Password:</label>
  -->   <div class="col-sm-11" style="margin-left:20px;"> 
    	    <input type="text" class="form-control" id="lat" name="lat" placeholder="Latitude" required ">
      
      </div>
  </div>
  
  <div class="form-group">
   <!--  <label class="control-label col-sm-2" for="pwd" >Password:</label>
  -->   <div class="col-sm-11" style="margin-left:20px;"> 
    	     <input type="text" class="form-control" id="Longitude" name="Longitude" placeholder="Longitude No" required  >
      
      </div>
  </div>
  
  
  
  
 
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
   <!--    <button type="submit" class="btn btn-default">Submit</button> -->
    <button class="btn btn-success" type="Reset" style="margin-left:-50px; width:45%; ">Reset</button>
     <button class="btn btn-success" type="submit" style="margin-left:60px; margin-top:0px; width:45%; ">Register</button>
    </div>
  </div>
  <div style="margin-left:40px;">
 <!--  <a href="register.jsp">New User</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <a href="login.jsp">Login Now</a>
    -->  </div>
</form>
		 <br><br><br><br>
		 </div>
		 
		 <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		 
		 
		 
		 <!--footer-->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
		 <p>© 2019 Third Party Auditor. All rights reserved | <a href="#"></a></p>
		 </div>
		 <div class="footer-menu">
			 <ul>
				 <li ><a href="index2.jsp">HOME</a></li>
				 <li><a href="uploadFile.jsp">UPLOAD FILE</a></li>
				  <li class="active"><a href="userDownload.jsp">DOWNLOAD</a></li>
				 <li><a href="changePass.jsp">CHANGE PASSWORD</a></li>
				  <li><a href="index.jsp">SIGNOUT</a></li>
			 </ul>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>

<!-- //footer -->
</body>
</html>
<script type="text/javascript">

function goTranDeleteBill(icKeyId,filename){ 	
	document.update.action="DownloadFileServlet?id="+icKeyId+"&name="+filename;
	document.update.submit();
    
}
</script>
