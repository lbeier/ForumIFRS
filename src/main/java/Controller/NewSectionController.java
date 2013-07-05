package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Section;
import Model.User;

public class NewSectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewSectionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		int id = (Integer) request.getSession().getAttribute("idUser");
		boolean isAdmin = user.isUserAdmin(id);

		if(isAdmin) {
			RequestDispatcher rs = request.getRequestDispatcher("newSection.jsp");
			rs.forward(request, response);
		} else {
			response.sendRedirect("index");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("titulo");
		String description = request.getParameter("descricao");
		Section section = new Section();
		section.setTitleSection(title);
		section.setDescriptionSection(description);
		int idSection = section.insertNewSection(section);

		response.sendRedirect("exibeSecao?id="+idSection);
	}

}