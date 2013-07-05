package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Section;
import Model.Thread;
import Model.User;

public class EditSectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditSectionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		int idSection = Integer.parseInt(request.getParameter("id"));
		boolean isAdmin = new User().isUserAdmin(idUSer);

		if(isAdmin) {
			Section section = new Section().findById(idSection);
			request.setAttribute("section", section);
			RequestDispatcher rs = request.getRequestDispatcher("editSection.jsp");
			rs.forward(request, response);
		} else {
			response.sendRedirect("index");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		String titleSection = String.valueOf(request.getParameter("titleSection"));
		String descriptionSection = String.valueOf(request.getParameter("descriptionSection"));
		int idSection = Integer.parseInt(request.getParameter("idSection"));
                boolean isAdmin = new User().isUserAdmin(idUSer);
		
		if(isAdmin) {
			Section section = new Section();
			section.updateSection(idSection, titleSection, descriptionSection);
		} else {
			response.sendRedirect("index");
		}
		

	}

}
