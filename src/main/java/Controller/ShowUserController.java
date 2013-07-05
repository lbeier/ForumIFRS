package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Comment;
import Model.Thread;
import Model.User;

public class ShowUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowUserController() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		boolean isAdmin = new User().isUserAdmin(idUSer);

		if(isAdmin) {
			List<User> users = new User().findAllUsers();
			request.setAttribute("users", users);

			RequestDispatcher rs = request.getRequestDispatcher("showUser.jsp");
			rs.forward(request, response);
		} else {
			response.sendRedirect("index");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
