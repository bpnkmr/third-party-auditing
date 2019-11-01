package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConstantMessage;

import dao.UserData;

import bean.UserBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	String userName,fullName,email,password,mobile;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		userName=request.getParameter("userName");
		fullName=request.getParameter("fullName");
		email=request.getParameter("userEmail");
		password=request.getParameter("userPass");
		mobile=request.getParameter("userMobile");
		System.out.println(userName+fullName+email+password+mobile);
		
		UserBean ub=new UserBean();
		ub.setFullName(fullName);
		ub.setUserName(userName);
		ub.setMobile(mobile);
		ub.setEmail(email);
		ub.setPassword(password);
		
		UserData ud=new UserData();
	int checkUname=	ud.CheckUsername(userName);
	System.out.println("checkUname:"+checkUname);
	if(checkUname==0)
	{
		int check=ud.insertRecord(ub);
		System.out.println("check:"+check);
		if(check==1)
		{
			request.setAttribute("message", ConstantMessage.register);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			
		}
		else
		{
			request.setAttribute("message", ConstantMessage.failRegister);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			
		}
	}else
	{
		request.setAttribute("message", ConstantMessage.sameUserName);
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}
		
	}

}
