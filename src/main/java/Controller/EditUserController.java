package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;

public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		boolean isAdmin = new User().isUserAdmin(idUSer);
		int idUserEdit = Integer.parseInt(request.getParameter("id"));

		if(isAdmin) {
			User user = new User().findById(idUserEdit);
			request.setAttribute("user", user);
			RequestDispatcher rs = request.getRequestDispatcher("editUserByAdmin.jsp");
			rs.forward(request, response);
		} else if(idUSer == idUserEdit){
			User user = new User().findById(idUSer);
			request.setAttribute("user", user);
			RequestDispatcher rs = request.getRequestDispatcher("editUser.jsp");
			rs.forward(request, response);
		} else {
			response.sendRedirect("index");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		boolean isAdmin = new User().isUserAdmin(idUSer);
		int idUserEdit = Integer.parseInt(request.getParameter("id"));

		if(isAdmin) {
			boolean typeUser = Boolean.parseBoolean(request.getParameter("tipo"));
			User user = new User().findById(idUserEdit);
			String passwordUser = user.getPasswordUser();
			user.updateUser(idUserEdit, passwordUser, typeUser, true);

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