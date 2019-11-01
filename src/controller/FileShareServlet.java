package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareDao;

/**
 * Servlet implementation class FileShareServlet
 */
@WebServlet("/FileShareServlet")
public class FileShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileShareServlet() {
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
		
		String filename=request.getParameter("Filename");
		String fileid=request.getParameter("Fileid");
		String userId=request.getParameter("userid");
		String latitude=request.getParameter("lat");
		String longitude=request.getParameter("Longitude");
		
		
		ShareDao sd=new ShareDao();
	int i=	sd.insertShareRecord(fileid, userId, latitude, longitude);
		if(i>0)
		{
			response.sendRedirect("Share.jsp?message=Share Successfull");
		}else{
			
			response.sendRedirect("Share.jsp?message=Share Un..Successfull");
			
		}
		
		
		
		
		
	}

}
