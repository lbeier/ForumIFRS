package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Section;
import Model.User;

public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Section section = new Section();
		List<Section> sections = section.findAll();
		
		User user = new User();
		int id = (Integer) request.getSession().getAttribute("idUser");
		boolean isAdmin = user.isUserAdmin(id);
		request.setAttribute("sections", sections);
		request.setAttribute("isAdmin", isAdmin);
		RequestDispatcher rs = request.getRequestDispatcher("app.jsp");
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}