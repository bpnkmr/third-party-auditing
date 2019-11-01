package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FileDao;

/**
 * Servlet implementation class FileReadServlet
 */
@WebServlet("/FileReadServlet")
public class FileReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		System.out.println(name+id);
		FileDao fd=new FileDao();
		InputStream is=fd.getFileData(name, id1);
		System.out.println("is in servlet:"+is.available());
		
		

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		/* String myString="";
		 String sCurrentLine="";
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		 */
		/* while ((sCurrentLine = br.readLine()) != null) {
	        System.out.println(sCurrentLine);
	        myString += sCurrentLine;
	    } */
	    
	    int n = 0;
	    while ((n=is.read(buf))>=0)
	    {
	       baos.write(buf, 0, n);
	    }

	    is.close();
	    byte[] bytes = baos.toByteArray();
	    String blobString = new String(bytes); 
	    
		request.setAttribute("blobString", blobString);
		request.setAttribute("fileId", id1);
		request.getRequestDispatcher("fileEdit.jsp").forward(request, response);
		
		
		
		
		
		
		//response.sendRedirect("fileEdit.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
