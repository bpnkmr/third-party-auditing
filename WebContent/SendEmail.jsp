<%@page import="dao.TpaDao"%>
<%@page import="dao.UserData"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="java.sql.*" %>
<html>
<head>
<title>Send Email using JSP</title>
</head>
<body>
<%

HttpSession ss1=request.getSession();
String id=(String)ss1.getAttribute("id2");
String str=(String)ss1.getAttribute("str");
String mail=(String)ss1.getAttribute("email22");
			
System.out.println("mail:"+mail+"  ***id:  "+id);

System.out.println("Strrrrrrrrr:"+str);
			String i=request.getParameter("name");
			String msg="";
			String msg1="";
			
			System.out.println("emai id:"+id);
			
			if(str!=null || str!="")
			{
				msg="your all file is hack and replace file is:";
				msg1=msg.concat(str);
			}
			
			
			
			
      %>       
 <%
   String result;
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        String from = "bestpeerproject@gmail.com";
        String pass = "bestpeer";
        String to = mail;
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");     
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.timeout", "25000");
        Session mailsession = Session.getDefaultInstance(props);
   try
   {
        MimeMessage message = new MimeMessage(mailsession);       
        message.setFrom(new InternetAddress(from));   
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Third Party Reminder");
        message.setText(msg1);
        Transport transport = mailsession.getTransport("smtp");
        transport.connect(host, from, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        result = "Sent message successfully....";
        %>
        <script type="text/javascript">
        alert(" Email send Successfully.");
        <%
        
        TpaDao td=new TpaDao();
        int n=td.setFlag(id);
        
        
       
        System.out.println("in email sending"+n);
       request.setAttribute("ii", n);
      request.getRequestDispatcher("bachAuditing.jsp").forward(request, response);
      // rd.include(request, response);
        %>
        </script>
 <%         
    }catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
    }
%>
</body>
</html>
