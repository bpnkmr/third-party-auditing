package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TpaDao;

/**
 * Servlet implementation class AuditingServlet
 */
@WebServlet("/AuditingServlet")
public class AuditingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuditingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public static String str=null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id1=request.getParameter("id2");
		System.out.println("id1::"+id1);
		int id=Integer.parseInt(id1);
		
		String email=request.getParameter("mail1");
		System.out.println("mail in servlet:"+email);
		TpaDao td=new TpaDao();
		 str=td.batchAuditing(id);
		 
		 System.out.println("str in auditing servlet:"+str);
		 
		 if(str!=null && str!="")
		 {
			 
			 boolean flag=td.storedTpaHackFileResponse(str, id);
			 
			 if(flag)
			 {
				 response.sendRedirect("bachAuditing.jsp");
			 }
			 
		 }
		 
		 
	
//		 if(str!=null && str!="")
//		 {
//			 boolean flag=td.storedTpaResponse(str, id);
//			 
//		 }
//		 
		 Cookie statusCookies=new Cookie(id1, "id");
		 //expire cookies in 5 min
		 statusCookies.setMaxAge(5*60);
		 response.addCookie(statusCookies);
		
		/* HttpSession ss1=request.getSession();
		 ss1.setAttribute("id2", id1);
		 ss1.setAttribute("str", str);
		 ss1.setAttribute("email22", email);
	*/	 
		/* request.setAttribute("id2", id1);
		 request.setAttribute("str", str);
		 request.setAttribute("email22", email);
		 request.getRequestDispatcher("SendEmail.jsp").forward(request, response);*/
		 response.sendRedirect("bachAuditing.jsp?msg=Checking completed");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
