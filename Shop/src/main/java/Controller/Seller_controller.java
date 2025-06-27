package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.seller_dao;
import Service.Email_otp;
import model.seller;

/**
 * Servlet implementation class Seller_controller
 */
@WebServlet("/Seller_controller")
public class Seller_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seller_controller() {
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
			seller s = new seller();
			s.setName(request.getParameter("name"));
			s.setEmail(request.getParameter("email"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setPassword(request.getParameter("password"));
			System.out.println(s);
			String email = request.getParameter("email");
			boolean flag = seller_dao.checkemail("email");
			if(flag == false) {
				seller_dao.insertseller(s);
				response.sendRedirect("sell-login.jsp");
			}
			else {
				request.setAttribute("msg", "Account already registered");
				request.getRequestDispatcher("sell-register.jsp").forward(request, response);
			}
			
		}else if(action.equalsIgnoreCase("login")) {
			seller s = new seller();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = seller_dao.checkemail(email);
			if(flag == true) {
				seller s1 = seller_dao.loginseller(s);
				System.out.println(s1);
				if(s1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data",s1);
					request.getRequestDispatcher("seller-home.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "Password is incorrect");
					request.getRequestDispatcher("seller-login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("msg", "Account not registered");
				request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("Update")) {
			seller s = new seller();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setEmail(request.getParameter("email"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			seller_dao.updateseller(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.setAttribute("msg", "Profile updated");
			request.getRequestDispatcher("seller-profile.jsp").forward(request, response);
		}else if (action.equalsIgnoreCase("change")){
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cp = request.getParameter("cp");
			boolean flag = seller_dao.checkpassword(email, op);
			if(flag == true ) {
				if(np.equals(cp)) {
					seller_dao.updatepassword(email, np);
					request.setAttribute("msg","Password Updated");
					response.sendRedirect("seller-change-pass.jsp");
				}
				else {
					request.setAttribute("msg", "New pass and Confirm  pass not matched");
					request.getRequestDispatcher("seller-change-pass.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Old pass is incorrect");
				request.getRequestDispatcher("seller-change-pass.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("get_otp")) {
			String email = request.getParameter("email");
			boolean flag = seller_dao.checkemail(email);
			if(flag == true) {
				Random r = new Random();
				int num = r.nextInt(999999);
				Email_otp e = new Email_otp();
				e.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("seller-otp.jsp").forward(request, response);
				
			}else {
				request.setAttribute("msg", "Account does not exist");
				request.getRequestDispatcher("seller-fp.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				request.setAttribute("email",email);
				request.getRequestDispatcher("seller-fp-np.jsp").forward(request, response);
			}else {
				request.setAttribute("email", email);
				request.setAttribute("otp1", otp1);
				request.setAttribute("msg", "OTP does not match");
				request.getRequestDispatcher("seller-otp.jsp").forward(request, response);
			}
			
		}else if (action.equalsIgnoreCase("fp")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cp = request.getParameter("cp");
			if(np.equals(cp)) {
				seller_dao.forgotpass(email, np);
				response.sendRedirect("sell-login.jsp");
			}else {
				request.setAttribute("email", email);
				request.setAttribute("msg", "Password not matched");
				request.getRequestDispatcher("seller-fp-np.jsp").forward(request, response);
			}
		}
	}

}
