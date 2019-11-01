package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FileDao;
import encryDecry.TextEncryptDecrypt;

/**
 * Servlet implementation class DownloadFileShareServlet
 */
@WebServlet("/DownloadFileShareServlet")
public class DownloadFileShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadFileShareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String filename=request.getParameter("name");
		System.out.println(filename);
		
		String str=request.getParameter("id");
		int id=Integer.parseInt(str);
		System.out.println(filename+id);
		
		FileDao fd=new FileDao();
		/*String filePath=fd.getFilePath(filename,id);*/
		
		InputStream is=fd.getEncFile(filename,id);
		
		
		
		 ServletContext context = getServletContext();
	       
		 String mimeType = context.getMimeType(filename);
	        if (mimeType == null) { 
	        	
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        
	        }
	        System.out.println("MIME type: " + mimeType);
	         
	        // forces download
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",filename);
	        response.setHeader(headerKey, headerValue);
	         
	      try{
		       String key=fd.getPublicKey(filename);
	    	  
	        /*  byte[] decry=TextEncryptDecrypt.Decrypt(filePath, key);*/
		       byte[] decry=null;
		      decry=TextEncryptDecrypt.DecryptInputstream(is, key);
	          // obtains response's output stream
		      OutputStream outStream =null;
		      if(decry!=null)
		      {
		    	   outStream = response.getOutputStream();
	            outStream.write(decry);
	            outStream.close();     
		      }else
		      {
		    	  
		    	  response.sendRedirect("userDownload.jsp?msg=File is hack!!!");
		      }
	           
	      }catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
