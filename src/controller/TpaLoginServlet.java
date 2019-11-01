package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.ConstantMessage;

/**
 * Servlet implementation class TpaLoginServlet
 */
@WebServlet("/TpaLoginServlet")
public class TpaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TpaLoginServlet() {
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
		
		
		if(username.equals("tpa") && password.equals("tpa123"))
		{
			HttpSession tpasess=request.getSession();
			tpasess.setAttribute("tpaname","tpa");
			
			response.sendRedirect("bachAuditing.jsp");
		}  
		else
		{
			request.setAttribute("message", ConstantMessage.failLogin);
			request.getRequestDispatcher("tpaLogin.jsp").forward(request, response);
		}
	}

		
	

}
