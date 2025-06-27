package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.buyer_dao;
import Dao.seller_dao;
import Service.Email_otp;
import model.buyer;

/**
 * Servlet implementation class buyer_controller
 */
@WebServlet("/buyer_controller")
public class buyer_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyer_controller() {
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
		if(action.equalsIgnoreCase("register")) {
			buyer b = new buyer();
			b.setName(request.getParameter("name"));
			b.setEmail(request.getParameter("email"));
			b.setContact(Long.parseLong(request.getParameter("contact")));
			b.setPassword(request.getParameter("password"));
			System.out.println(b);
			String email = request.getParameter("email");
			boolean flag = buyer_dao.checkemail("email");
			if(flag == false) {
				buyer_dao.insertbuyer(b);
				response.sendRedirect("buy-login.jsp");
			}
			else {
				request.setAttribute("msg", "Account already registered");
				request.getRequestDispatcher("buy-sign.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("login")) {
			buyer b = new buyer();
			b.setEmail(request.getParameter("email"));
			b.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = buyer_dao.checkemail(email);
			if(flag == true) {
				buyer b1 = buyer_dao.loginbuyer(b);
				System.out.println(b1);
				if(b1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data",b1);
					request.getRequestDispatcher("buyer-home.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "Password is incorrect");
					request.getRequestDispatcher("buyer-login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("msg", "Account not registered");
				request.getRequestDispatcher("buyer-login.jsp").forward(request, response);
			}
			
		}else if (action.equalsIgnoreCase("Update")) {
			buyer b = new buyer();
			b.setId(Integer.parseInt(request.getParameter("id")));
			b.setName(request.getParameter("name"));
			b.setEmail(request.getParameter("email"));
			b.setContact(Long.parseLong(request.getParameter("contact")));
			buyer_dao.updatebuyer(b);
			HttpSession session = request.getSession();
			session.setAttribute("data", b);
			request.setAttribute("msg", "Profile updated");
			request.getRequestDispatcher("buyer-profile.jsp").forward(request, response);
			
		}else if (action.equalsIgnoreCase("change")) {
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cp = request.getParameter("cp");
			boolean flag = buyer_dao.checkpassword(email, op);
			if(flag == true) {
				if(np.equals(cp)) {
					buyer_dao.updatepassword(email, np);
					request.setAttribute("msg","Password Updated");
					response.sendRedirect("buyer-change-pass.jsp");
				}
				else {
					request.setAttribute("msg", "New pass and Confirm  pass not matched");
					request.getRequestDispatcher("buyer-change-pass.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Old pass is incorrect");
				request.getRequestDispatcher("buyer-change-pass.jsp").forward(request, response);
			}
		}else if (action.equalsIgnoreCase("get_otp")) {
			String email = request.getParameter("email");
			boolean flag = buyer_dao.checkemail(email);
			if(flag == true) {
				Random r = new Random();
				int num = r.nextInt(999999);
				Email_otp e = new Email_otp();
				e.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("buyer-otp.jsp").forward(request, response);
				
				
			}else {
				request.setAttribute("msg", "Account does not exist");
				request.getRequestDispatcher("buyer-fp.jsp").forward(request, response);
			}
		}else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("buyer-fp-np.jsp").forward(request, response);
			}else {
				request.setAttribute("email", email);
				request.setAttribute("otp1", otp1);
				request.setAttribute("msg", "OTP does not match");
				request.getRequestDispatcher("buyer-otp.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("fp")) { 
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cp = request.getParameter("cp");
			if(np.equals(cp)) {
				buyer_dao.forgotpass(email, np);
				response.sendRedirect("buy-login.jsp");
			}else {
				request.setAttribute("email", email);
				request.setAttribute("msg", "Password not matched");
				request.getRequestDispatcher("seller-fp-np.jsp").forward(request, response);
			}
		}
	}

}
