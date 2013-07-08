package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Section;
import Model.Tag;
import Model.Thread;
import Model.User;

public class NewThreadController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public NewThreadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idSection = Integer.parseInt(request.getParameter("idSection"));
		String titleSection = new Section().findById(idSection).getTitleSection();
		request.setAttribute("idSection", idSection);
		request.setAttribute("titleSection", titleSection);
		
		render("newThread", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUser = getIdUserLoggedIn(request);
		String titleThread = request.getParameter("titleThread");
		String messageThread = request.getParameter("messageThread");
		int idSection = Integer.parseInt(request.getParameter("idSection"));
		String[] tags = request.getParameter("tagsThread").split(",");
		
		Thread thread = new Thread();
		User user = new User();
		Section section = new Section();

		thread.setTitleThread(titleThread);
		thread.setMessageThread(messageThread);		
		thread.setUser(user.findById(idUser));
		thread.setSection(section.findById(idSection));

		int idThread = thread.insertNewThread(thread);
		new Tag().createListOfTags(tags, idThread);

		response.sendRedirect("exibeTopico?id="+idThread);
	}
}