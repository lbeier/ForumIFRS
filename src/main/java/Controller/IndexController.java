package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Section;

public class IndexController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Section section = new Section();
		List<Section> sections = section.findAll();

		boolean isAdmin = isLoggedUserAdmin(request);
		request.setAttribute("sections", sections);
		request.setAttribute("isAdmin", isAdmin);

		render("app", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}
}