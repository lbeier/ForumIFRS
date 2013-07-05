package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Section;

public class EditSectionController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public EditSectionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idSection = Integer.parseInt(request.getParameter("id"));
		boolean isAdmin = isLoggedUserAdmin(request);

		if(isAdmin) {
			Section section = new Section().findById(idSection);
			request.setAttribute("section", section);
			render("editSection", request, response);
		} else {
			redirect("index", response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titleSection = String.valueOf(request.getParameter("titleSection"));
		String descriptionSection = String.valueOf(request.getParameter("descriptionSection"));
		int idSection = Integer.parseInt(request.getParameter("idSection"));
		boolean isAdmin = isLoggedUserAdmin(request);

		if(isAdmin) {
			Section section = new Section();
			section.updateSection(idSection, titleSection, descriptionSection);
			redirect("exibeSecao?id="+idSection, response);
		} else {
			redirect("index", response);
		}	
	}
}