package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.FileBean;

import util.ConstantMessage;

import dao.FileDao;
import encryDecry.SHA_512_Hash;

/**
 * Servlet implementation class UpdateFileServlet
 */
@WebServlet("/UpdateFileServlet")
public class UpdateFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateFileServlet() {
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
	 InputStream is=null;
	 InputStream is1=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hash = "";
		String fileStr=request.getParameter("pwd");
		System.out.println("******fileStr*******"+fileStr.length());
		String id=request.getParameter("hidd");
		int id1=Integer.parseInt(id);


		 is=new ByteArrayInputStream(fileStr.getBytes(StandardCharsets.UTF_8));
		 is1=new ByteArrayInputStream(fileStr.getBytes(StandardCharsets.UTF_8));
		System.out.println("is size in update Servlet:"+is.available());
		

		try
		{
			hash = SHA_512_Hash.getSHA_512_Hash1(is);
			is.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("hash:"+hash);
		System.out.println("is size in update Servlet++++++++++++++++:"+is.available());
		
		FileBean fb=new FileBean();
		fb.setFile(is1);
		fb.setFk(id1);
		fb.setHashCode(hash);
		
		FileDao fd=new FileDao();
		boolean check1=fd.updateFile(fb);
		System.out.println("check1 in update file servlet:"+check1);
		
		if(check1==false)
		{
				response.sendRedirect("server.jsp?succUpdate="+ConstantMessage.succUpdateFile);
		}
		else
		{
			response.sendRedirect("server.jsp?succUpdate="+ConstantMessage.failUpdateFile);
		}
	}

}
