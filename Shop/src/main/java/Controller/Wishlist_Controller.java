package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.wishlist_dao;
import model.wishlist;

/**
 * Servlet implementation class Wishlist_Controller
 */
@WebServlet("/Wishlist_Controller")
public class Wishlist_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wishlist_Controller() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			wishlist w = new wishlist();
			w.setCid(Integer.parseInt(request.getParameter("cid")));
			w.setPid(Integer.parseInt(request.getParameter("pid")));
			boolean flag = wishlist_dao.checkProductForWishList(Integer.parseInt(request.getParameter("cid")),
					Integer.parseInt(request.getParameter("pid")));
			
			if(flag == false) {
				wishlist_dao.addtowishlist(w);
				response.sendRedirect("buyer-home.jsp");
			}
			else {
				request.setAttribute("msg", "Product already added !");
				request.getRequestDispatcher("wishlist.jsp").forward(request, response);
			}
		}
	}

}
