package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.cart_dao;
import Dao.product_dao;
import model.cart;
import model.product;

/**
 * Servlet implementation class Cart_Controller
 */
@WebServlet("/Cart_Controller")
public class Cart_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int cart_id = Integer.parseInt(request.getParameter("cart_id"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		cart c = new cart();
		c.setCart_id(cart_id);
		c.setQty(qty);

		c.setTotal_price(qty * pprice);
		cart_dao.updatecart(c);
		response.sendRedirect("buy-cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("addtocart")) {
			cart c = new cart();
			c.setCid(Integer.parseInt(request.getParameter("cid")));
			int pid = Integer.parseInt(request.getParameter("pid"));
			c.setPid(pid);
			product p = product_dao.getProductByPid(pid);
			c.setQty(1);
			c.setPprice(p.getPprice());
			c.setTotal_price(p.getPprice());
			c.setNet_price(p.getPprice());
			c.setPayment_status("pending");
			cart_dao.insertINtoCart(c);
			response.sendRedirect("buyer-home.jsp");
		}
	}

}
