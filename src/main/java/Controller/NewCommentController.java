package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Comment;
import Model.Thread;
import Model.User;

public class NewCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewCommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idThread = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("idThread", idThread);
		RequestDispatcher rs = request.getRequestDispatcher("newComment.jsp");
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idUser = (Integer) session.getAttribute("idUser");		
		String messageComment = request.getParameter("messageComment");
		int idThread = Integer.parseInt(request.getParameter("idThread"));
		Comment comment = new Comment();
		User user = new User();
		Thread thread = new Thread();

		comment.setMessageComment(messageComment);
		comment.setThread(thread.findById(idThread));
		comment.setUser(user.findById(idUser));
		comment.insertNewComment(comment);
		
		response.sendRedirect("exibeTopico?id="+idThread);
	}

}