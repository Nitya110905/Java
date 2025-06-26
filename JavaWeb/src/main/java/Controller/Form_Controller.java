package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.form_dao;
import model.form;

/**
 * Servlet implementation class Form_Controller
 */
@WebServlet("/Form_Controller")
public class Form_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form_Controller() {
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
		if(action.equalsIgnoreCase("submit")) {
			form f = new form();
			f.setName(request.getParameter("name"));
			f.setEmail(request.getParameter("email"));
			f.setContact(Long.parseLong(request.getParameter("contact")));
			f.setPassword(request.getParameter("password"));
			f.setAddress(request.getParameter("address"));
			f.setHobby(request.getParameter("hobby[]"));
			f.setCourse(request.getParameter("course"));
			f.setGender(request.getParameter("gender"));
			System.out.println(f);
			form_dao.submitform(f);
			response.sendRedirect("form.jsp");
			request.setAttribute("msg", "Your response has been noted");
		}
	}

}
