<%@page import="dao.UserData"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Third Party Auditor | Server </title>
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
	String ch=request.getParameter("check");
			System.out.println("ch"+ch);
			if(ch!=null){
	if(ch.equals("false")){
		%>
		
		<script type="text/javascript">
		alert("File Deleted Successfully");
		</script>
	<%}
	else{%>
		<script type="text/javascript">
		alert("File Not Deleted");
		</script>
	<%}
			}
%>	
	
	<%
String succUpdate=request.getParameter("succUpdate");
		

if(succUpdate!=null)
{
%>

<script type="text/javascript">

alert("<%=succUpdate%>");
</script>
	<%} %>
	
	
	
</head>
<body>
<!-- header -->
<div class="header">
	 <div class="container">
		 <div class="logo">
			   <h1><a href="server.jsp">Third Party Auditor</a></h1>
		 </div>	
		 <div class="top-menu">
			 <span class="menu"></span>
			   <ul>
				 <li ><a href="server.jsp">HOME</a></li>
				 <li><a href="server.jsp">SERVER</a></li>
				
				
				
				  <li><a href="LogoutServlet">LOGOUT</a></li>
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
		 <!-- <ol class="breadcrumb">
		  <li><a href="index.jsp">Home</a></li>
		  <li class="active">About</li>
		 </ol>
		  -->
		 
		<br><br>
	
	  <div class="modal-content login-modal">
	   <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>File Name</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <%
		 UserData ud=new UserData();
				ResultSet rs1= ud.getFileDB();
			if(rs1!=null)
			{
				while(rs1.next())
				{
		 %>
		
		 
        <td><%= rs1.getInt(1)%></td>
        <td><%=rs1.getString(2) %></td>
        <td><a id="edit1" class="btn btn-launch" href="FileReadServlet?id=<%=rs1.getString(1)%>&name=<%=rs1.getString(2)%>" 
         > <span class="label label-primary">Edit</span></a></td>
      
      <!--  
        <td><a id="edit1" class="btn btn-launch" data-toggle="modal" data-target="#loginModal" 
         > Edit</a></td>
      --> 
       
          <td><a href="DeleteFileServlet?id=<%=rs1.getString(1)%>&name=<%=rs1.getString(2)%>"><span class="label label-success">Delete</span></a>
        
        <!-- onClick="goTranDeleteBill('<%=rs1.getString(1)%>','<%=rs1.getString(2)%>')" -->
      </tr>
     <%
			}%>
			
			
			<%	}else
			{%>
				<tr> 
				<td></td>
				<td>Data not avaible</td></tr>
				
		<%	}
					%>
     </tbody>
  </table>
  </div>
  
  <%
  HttpSession session6=request.getSession();
  byte[] byt=(byte[]) session6.getAttribute("file");
  
 
  if(byt!=null){
	  
	  out.println(byt.length);
  %>
  
  

		<!--  <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true" style="height:100%px;">
		 -->  <div class="modal-dialog" >
		   <div class="modal-content login-modal">
		    <div class="modal-header login-modal-header">
	           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title text-center" id="loginModalLabel">File Data</h4>
	      	</div>
	      	<div class="modal-body">
	      	 <div class="text-center">
		      <div role="tabpanel" class="login-tab">
		      <form name="update" action="UpdateFileServlet" method="post" >
			       <div class="form-group">
	                <textarea class="form-control" id="pwd" name="pwd" style="height:400px;"><%=byt %></textarea>
	                <hr><br>
	               </div>
	                <div class="form-group"> 
    				 <div class="col-sm-offset-2 col-sm-10">
					   <button class="btn btn-lg btn-login btn-block" type="Reset" style="margin-left:-100px; margin-top:-50px; width:55%; background: #68dff0; color:#fff;">Reset</button>
					   <button class="btn btn-lg btn-login btn-block" type="submit" style="margin-left:180px; margin-top:-45px; width:55%; background: #68dff0; color:#fff;">Sign in</button>
					 </div>
  					</div>
               </form>
               </div>
		  </div>
		  </div>
		 </div>
	</div>	 	 

		 
		 <%} %>
		 
		 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		 
		 
		 <!--footer-->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
		 <p>� 2019 Third Party Auditor. All rights reserved | <a href="#"></a></p>
		 </div>
		 <div class="footer-menu">
			 <ul>
				 <li ><a href="serverWel.jsp">HOME</a></li>
				 <li><a href="server.jsp">SERVER</a></li>
				
				
				
				  <li><a href="index.jsp">LOGOUT</a></li>
			 </ul>		
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
</div>
</div>
<!-- //footer -->
<script type="text/javascript">

function goTranDeleteBill(icKeyId,filename){
  
	
	document.update.action="/FileReadServlet?id="+icKeyId+"& name="+filename;
	document.update.submit();
    
}
</script>

<script>

$(document).ready(function(){
		$('.table table-striped a').click(function(){
			var val=$(this).attr('value').val();
			alert(val);
		});
});

</script>
</body>
</html>

