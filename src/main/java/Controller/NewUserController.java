package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;

public class NewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user = new User();
		int id = (Integer) request.getSession().getAttribute("idUser");
		boolean isAdmin = user.isUserAdmin(id);

		if(isAdmin) {
			RequestDispatcher rs = request.getRequestDispatcher("newUserByAdmin.jsp");
			rs.forward(request, response);
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("newUser.jsp");
			rs.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String loginUser = request.getParameter("login");
		String passwordUser = request.getParameter("senha");
		String passwordUserConfirmation = request.getParameter("senhaConfirma");
		String typeUser = request.getParameter("tipo");

		if(passwordUser.equals(passwordUserConfirmation)) {
			User user = new User();
			user.setLoginUser(loginUser);
			user.setPasswordUser(passwordUser);
			if(typeUser.equals("true"))
				user.setTypeUser(true);
			else
				user.setTypeUser(false);

			user.insertNewUser(user);
		} else {

		}

	}

}
