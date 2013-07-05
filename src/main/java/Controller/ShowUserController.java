package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.User;

public class ShowUserController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public ShowUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isAdmin = isLoggedUserAdmin(request);

		if(isAdmin) {
			List<User> users = new User().findAllUsers();
			request.setAttribute("users", users);

			render("showUser", request, response);
		} else {
			redirect("index", response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}
}