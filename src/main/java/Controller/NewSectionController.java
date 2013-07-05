package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Section;

public class NewSectionController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public NewSectionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isAdmin = isLoggedUserAdmin(request);

		if(isAdmin) {
			render("newSection", request, response);
		} else {
			redirect("index", response);
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

		redirect("exibeSecao?id="+idSection, response);
	}
}