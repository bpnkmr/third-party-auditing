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
 * Servlet implementation class ServerLoginServlet
 */
@WebServlet("/ServerLoginServlet")
public class ServerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerLoginServlet() {
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
	
		
		String username=request.getParameter("UserName");
		String password=request.getParameter("pwd");
		System.out.println("in server login username:"+username+"pass:"+password);
		
		
		if(username.equals("server") && password.equals("server12"))
		{
			
			
			response.sendRedirect("server.jsp");
		}  
		else
		{
			request.setAttribute("message", ConstantMessage.failLogin);
			request.getRequestDispatcher("serverLogin.jsp").forward(request, response);
		}
	}

		
	

}
