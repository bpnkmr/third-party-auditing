package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FileDao;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String filename=request.getParameter("name");
		String str=request.getParameter("id");
		int id=Integer.parseInt(str);
		System.out.println(filename+id);
		
		FileDao fd=new FileDao();
		boolean check=fd.deleteUserFile(filename, id);
		System.out.println("check in delete file servle:"+check);
		if(check==false){
			String str1="File Deleted";
		request.setAttribute("check", str1);
		request.getRequestDispatcher("userDownload.jsp").forward(request, response);
		}
		else{
			String str1="Error occure in File Deleted";
			request.setAttribute("check", str1);
			request.getRequestDispatcher("userDownload.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
