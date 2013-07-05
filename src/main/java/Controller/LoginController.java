package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("action") != null) {
			HttpSession session = ((HttpServletRequest) request).getSession();
			session.invalidate();
		}
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginUser = request.getParameter("loginUser");
		String passwordUser = request.getParameter("passwordUser");

		User user = new User();

		user.setLoginUser(loginUser);
		user.setPasswordUser(passwordUser);
		int idUser = user.loginUser();

		if(idUser != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("userAuth", "true");
			session.setAttribute("idUser", idUser);
			response.sendRedirect("index");
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}
	}

}
