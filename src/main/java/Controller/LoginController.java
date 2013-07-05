package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Framework.ApplicationController;
import Model.User;

public class LoginController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("action") != null) {
			logout(request);
		}
		render("login", request, response);		
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
			login(idUser, request);
			redirect("index", response);
		} else {
			render("login", request, response);
		}
	}
}