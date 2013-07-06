package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Comment;
import Model.Thread;

public class EditCommentController extends ApplicationController {
	private static final long serialVersionUID = 1L;

	public EditCommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUser = getIdUserLoggedIn(request);
		int idComment = Integer.parseInt(request.getParameter("id"));
		boolean canEditThread = new Comment().canUserModifyComment(idUser, idComment);

		if(canEditThread) {
			Comment comment = new Comment().findById(idComment);
			int idThread = comment.getThread().getIdThread();
			Thread thread = new Thread().findById(idThread);
			
			request.setAttribute("thread", thread);
			request.setAttribute("comment", comment);
			render("editComment", request, response);
		} else {
			redirect("index", response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUser = getIdUserLoggedIn(request);
		String messageComment = String.valueOf(request.getParameter("messageComment"));
		int idComment = Integer.parseInt(request.getParameter("id"));
		boolean canEditThread = new Comment().canUserModifyComment(idUser, idComment);

		if(canEditThread) {
			Comment comment = new Comment();			
			comment.updateComment(idComment, messageComment);
			int idThread = comment.findById(idComment).getThread().getIdThread();
			redirect("exibeTopico?id="+idThread, response);
		} else {
			redirect("index", response);
		}
	}
}