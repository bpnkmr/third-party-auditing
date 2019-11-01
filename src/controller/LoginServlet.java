package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.ConstantMessage;

import dao.UserData;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("UserName");
		String password=request.getParameter("pwd");
		System.out.println("in login username:"+username+"pass:"+password);
		
		UserData ud=new UserData();
	int i=	ud.loginCheck(username, password);
	System.out.println("login in i:"+i);
		if(i==1)
		{
			int id=ud.getId(username);
			HttpSession session1=request.getSession();
			session1.setAttribute("id", id);
			session1.setAttribute("uname", username);
			
			response.sendRedirect("uploadFile.jsp");
		}
		else
		{
			request.setAttribute("message", ConstantMessage.failLogin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
