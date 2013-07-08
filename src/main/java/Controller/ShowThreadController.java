package Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Framework.ApplicationController;
import Model.Comment;
import Model.Section;
import Model.Thread;
import Model.Thread_Tag;

public class ShowThreadController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public ShowThreadController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idThread = Integer.parseInt(request.getParameter("id"));
		Thread thread = new Thread().findById(idThread);
		int numbersOfVisualizations = thread.getNumbersOfVisualizations();
		thread.updateThread(idThread, (numbersOfVisualizations+1));
		int idSection = thread.getSection().getIdSection();
		Section section = new Section().findById(idSection);
		List<Comment> comments = new Comment().findAllByThread(idThread);
		List<Thread_Tag> tags = new Thread_Tag().findAllTagsById(idThread); 
		int idUSer = getIdUserLoggedIn(request);
		boolean canEditThread = new Thread().canUserModifyThread(idUSer, idThread);
		boolean isAdmin = isLoggedUserAdmin(request);

		request.setAttribute("isAdmin", isAdmin);
		request.setAttribute("canEditThread", canEditThread);
		request.setAttribute("idUSer", idUSer);
		request.setAttribute("thread", thread);
		request.setAttribute("comments", comments);
		request.setAttribute("section", section);
		request.setAttribute("tags", tags);
		
		render("showThread", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}
}