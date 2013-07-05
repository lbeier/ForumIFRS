package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.User;

public class EditUserController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public EditUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUser = getIdUserLoggedIn(request);
		boolean isAdmin = isLoggedUserAdmin(request);
		int idUserEdit = Integer.parseInt(request.getParameter("id"));

		if(isAdmin) {
			User user = new User().findById(idUserEdit);
			request.setAttribute("user", user);
			render("editUserByAdmin", request, response);
		} else if(idUser == idUserEdit){
			User user = new User().findById(idUser);
			request.setAttribute("user", user);
			render("editUser", request, response);
		} else {
			redirect("index", response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUSer = getIdUserLoggedIn(request);
		boolean isAdmin = isLoggedUserAdmin(request);
		int idUserEdit = Integer.parseInt(request.getParameter("id"));

		if(isAdmin) {
			boolean typeUser = Boolean.parseBoolean(request.getParameter("tipo"));
			User user = new User().findById(idUserEdit);
			String passwordUser = user.getPasswordUser();
			user.updateUser(idUserEdit, passwordUser, typeUser, true);

			redirect("listarUsuarios", response);
		} else if(idUSer == idUserEdit){
			User user = new User().findById(idUserEdit);
			String oldPasswordUser = request.getParameter("senhaAntiga");
			String newPasswordUser = request.getParameter("senhaNova");
			String passwrodUser = user.getPasswordUser();

			if(oldPasswordUser.equals(passwrodUser)) {
				user.updateUser(idUserEdit, newPasswordUser, false, false);
			} else {
				response.sendRedirect("editarUsuario?id="+idUSer);
			}
		} else {
			response.sendRedirect("index");
		}
	}
}