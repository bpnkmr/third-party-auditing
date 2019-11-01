package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.FileBean;

import dao.FileDao;

import util.*;

import encryDecry.*;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
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
	String fileName = "";
	 String storePath="tpa";
	 String encryptedpath="";
	 String decryptPath="";
	 InputStream orgFile;
	 FileInputStream orgFile1;
	 String hash="";
	  String publicKey="";
	  String storeFile="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session1=request.getSession();
		int id=(Integer)session1.getAttribute("id");
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 File uploadedFile=null ;
		 File encryptedFile=null;
		 
	        if (isMultipart) {
	        	// Create a factory for disk-based file items
	        	FileItemFactory factory = new DiskFileItemFactory();
          
	        	// Create a new file upload handler
	        	ServletFileUpload upload = new ServletFileUpload(factory);
	        	File path1 =null;
	        	
	        	
	        	 String name="";
	        	 String root="";
	            try {
			            	// Parse the request
			            	/* FileItem */
			            	List  items = upload.parseRequest(request);
			                Iterator iterator = items.iterator();
			                while (iterator.hasNext()) 
			                {
			                    FileItem item = (FileItem) iterator.next();
			                    if (!item.isFormField()) 
			                    {
				                        fileName = item.getName();	 
				                        name=fileName;
				                        root = getServletContext().getRealPath("/");
				                        System.out.println("root:"+root);
				                      
				                        path1 = new File(root+"/"+storePath +"/" + id);
				                      //  File path2 = new File("c:/uploads");
				                        if (!path1.exists())
				                        {
				                            boolean status = path1.mkdirs();
				                            System.out.println("Status  " +status);
				                           /* if(!path1 +"/" +fileName){
				                            	
				                            }*/
				                        }
				                      
				                       // File uploadedFile = new File(path + "/" + fileName);
				                         uploadedFile = new File(path1 + "/" +id+fileName);
				                         encryptedpath=path1 + "/" +id+"enc"+(fileName);
				                         decryptPath=path1 + "/" +id+"dec"+(fileName);
				                         System.out.println("enc path:"+encryptedpath);
				                        System.out.println("full path:"+uploadedFile.getAbsolutePath());
				                        item.write(uploadedFile);
			                        
			                        
			                     }
			                }
			               
			                FileDao fd=new FileDao();
			          int checkFile= fd.getFile(id+fileName, id);
			          System.out.println("same file name:"+checkFile);
			          if(checkFile==1)
			          {
			        	  request.setAttribute("message", ConstantMessage.sameFileName);
			        	  request.getRequestDispatcher("uploadFile.jsp").forward(request, response);
			          }else
			          {
			          
			               
			              		try {
					            	   orgFile=new FileInputStream(uploadedFile);
					            	   orgFile1=new FileInputStream(path1 + "/" + id+fileName);
						            
					            	   Random r=new Random();
						                String key=RandomString.random();
						                String s=new String(Base64.encodeBase64(FileDao.generateString(r,"user@gmail.com"+"1"+new Date(1),16).getBytes()));
						                publicKey=FileDao.generateString(r,s,16);
						                System.out.println("Key:"+publicKey);
					            	  
						                TextEncryptDecrypt.reencrypt(orgFile,encryptedpath, publicKey);
					                  //TextEncryptDecrypt.reDecrypt(encryptedpath, publicKey, decryptPath);
					                  
					                  hash=SHA_512_Hash.getSHA_512_Hash(encryptedpath);
					                  System.out.println("hash:"+hash);
					              }catch (Exception e)
						            {
						                e.printStackTrace();
						            }
			                
			   FileInputStream enc=new FileInputStream(new File(encryptedpath));
			   FileInputStream enc1=new FileInputStream(new File(encryptedpath));
				
						             /** file save to DAtabase*/
						             FileBean fb=new FileBean();
						             fb.setEncFileName(encryptedpath);
						              fb.setFile(enc);
						              fb.setFileTpa(enc1);
						              fb.setFileName(id+fileName);
						              fb.setFilePath(path1 + "/" +id+ fileName);
						              fb.setHashCode(hash);
						              fb.setPublicKey(publicKey);
						              fb.setFk(id);
						              
			           
						             boolean check= fd.insertFileInfo(fb);
						             System.out.println("save file to server:"+check);
						             if(check==false)
						             {
						             boolean check1=fd.saveFileTpa(fb);
						             System.out.println("save file to tpa:"+check1);
						             if( check1==false)
						             {
						            	 request.setAttribute("message", ConstantMessage.succRegFile);
						            	 request.getRequestDispatcher("uploadFile.jsp").forward(request, response);
						             }
						             else
						             {
						            	 request.setAttribute("message", ConstantMessage.failRegFile);
						            	 request.getRequestDispatcher("uploadFile.jsp").forward(request, response);
						        
						            	 
						             }
						             }  else
						             {
						            	 request.setAttribute("message", ConstantMessage.failRegFile);
						            	 request.getRequestDispatcher("uploadFile.jsp").forward(request, response);
						        
						            	 
						             }
			          }
		            } catch (FileUploadException e) 
		            {
		                e.printStackTrace();
		            } catch (Exception e)
		            {
		                e.printStackTrace();
		            }
	       
	        }
		
	}

}
