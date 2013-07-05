package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.User;

public class NewUserController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public NewUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		boolean isAdmin = isLoggedUserAdmin(request);

		if(isAdmin) {
			render("newUserByAdmin", request, response);
		} else {
			render("newUser", request, response);
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
		}
		
		redirect("index", response);			
	}
}
