package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserData;

import util.ConstantMessage;

/**
 * Servlet implementation class ChangePassServlet
 */
@WebServlet("/ChangePassServlet")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassServlet() {
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
		
		String orgPass=request.getParameter("orgPwd");
		String newPass=request.getParameter("newPwd");
		String confirmPwd=request.getParameter("confirmPwd");
		System.out.println(orgPass+"\n"+newPass+"\n"+confirmPwd);
		
		HttpSession session1=request.getSession();
		int id=(Integer) session1.getAttribute("id");
		System.out.println("id"+id);
		
		if(newPass.equals(confirmPwd))
		{
			
			UserData ud=new UserData();
			int change=ud.ChangePass(id, confirmPwd);
			System.out.println("change pass="+change);
			if(change==1)
			{
				request.setAttribute("message", ConstantMessage.succChangPass);
				request.getRequestDispatcher("changePass.jsp").forward(request, response);
			}else
			{
				request.setAttribute("message", ConstantMessage.failChangPass);
				request.getRequestDispatcher("changePass.jsp").forward(request, response);
			}
			
		}else
		{
			request.setAttribute("message", ConstantMessage.diffPass);
			request.getRequestDispatcher("changePass.jsp").forward(request, response);
		}
		
	}

}
