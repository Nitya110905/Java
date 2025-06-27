package Controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.product_dao;
import model.product;

/**
 * Servlet implementation class Product_Controller
 */
@WebServlet("/Product_Controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024 * 512)
public class Product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private String extractfilename(Part file) {
	    String cd = file.getHeader("content-disposition");
	    System.out.println(cd);
	    String[] items = cd.split(";");
	    for (String string : items) {
	        if (string.trim().startsWith("filename")) {
	            return string.substring(string.indexOf("=") + 2, string.length()-1);
	        }
	    }
	    return "";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("upload")){
			String savepath = "C:\\Users\\Nitya Shah\\eclipse-workspace\\Shop\\src\\main\\webapp\\product image";
			File fileSaveDir=new File(savepath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	            }
	        Part file1 = request.getPart("pimage");
	   		 	String fileName=extractfilename(file1);
	   		    file1.write(savepath + File.separator + fileName);
	   		    String filePath= savepath + File.separator + fileName ;
	   		    
	   		    String savepath2 = "C:\\Users\\Nitya Shah\\eclipse-workspace\\Shop\\src\\main\\webapp\\product image";
	   	        File imgSaveDir=new File(savepath2);
	   	        if(!imgSaveDir.exists()){
	   	            imgSaveDir.mkdir();
	   	        }
	   	        
	   	        product p = new product();
	   	        p.setSid(Integer.parseInt(request.getParameter("sid")));
	   	        p.setPname(request.getParameter("pname"));
	   	        p.setPcompany(request.getParameter("pcompany"));
	   	        p.setPdesc(request.getParameter("pdesc"));
	   	        p.setPquant(Integer.parseInt(request.getParameter("pquant")));
	   	        p.setPimage(fileName);
	   	        p.setPprice(Integer.parseInt(request.getParameter("pprice")));
	   	        product_dao.uploadproduct(p);
	   	        response.sendRedirect("seller-upload-product.jsp");
		}else if(action.equalsIgnoreCase("update")) {
			String savePath = "C:\\Users\\Nitya Shah\\eclipse-workspace\\Shop\\src\\main\\webapp\\product image";
			File fileSaveDir=new File(savePath);
			if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("pimage");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\Nitya Shah\\eclipse-workspace\\Shop\\src\\main\\webapp\\product image";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        product p = new product();
	        p.setPid(Integer.parseInt(request.getParameter("pid")));
   	        p.setPname(request.getParameter("pname"));
   	        p.setPcompany(request.getParameter("pcompany"));
   	        p.setPdesc(request.getParameter("pdesc"));
   	        p.setPquant(Integer.parseInt(request.getParameter("pquant")));
   	        p.setPimage(fileName);
   	        p.setPprice(Integer.parseInt(request.getParameter("pprice")));
   	        product_dao.updateProduct(p);
	        response.sendRedirect("seller-manage-product.jsp");
	        
		}
	}

}
