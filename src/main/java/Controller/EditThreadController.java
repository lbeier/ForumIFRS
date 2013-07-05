package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Thread;

public class EditThreadController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public EditThreadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUser = getIdUserLoggedIn(request);
		int idThread = Integer.parseInt(request.getParameter("id"));
		boolean canEditThread = new Thread().canUserModifyThread(idUser, idThread);

		if(canEditThread) {
			Thread thread = new Thread().findById(idThread);
			request.setAttribute("thread", thread);
			render("editThread", request, response);
		} else {
			redirect("index", response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUser = getIdUserLoggedIn(request);
		String titleThread = String.valueOf(request.getParameter("titleThread"));
		String messageThread = String.valueOf(request.getParameter("messageThread"));
		int idThread = Integer.parseInt(request.getParameter("id"));
		boolean canEditThread = new Thread().canUserModifyThread(idUser, idThread);
		
		if(canEditThread) {
			Thread thread = new Thread();
			thread.updateThread(idThread, titleThread, messageThread);
			redirect("exibeTopico?id="+idThread, response);
		} else {
			redirect("index", response);
		}		
	}
}
