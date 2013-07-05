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

public class EditCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCommentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		int idComment = Integer.parseInt(request.getParameter("id"));
		boolean canEditThread = new Comment().canUserModifyComment(idUSer, idComment);

		if(canEditThread) {
			Comment comment = new Comment().findById(idComment);
			request.setAttribute("comment", comment);
			RequestDispatcher rs = request.getRequestDispatcher("editComment.jsp");
			rs.forward(request, response);
		} else {
			response.sendRedirect("index");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		String messageComment = String.valueOf(request.getParameter("messageComment"));
		int idComment = Integer.parseInt(request.getParameter("id"));
		boolean canEditThread = new Comment().canUserModifyComment(idUSer, idComment);
		
		if(canEditThread) {
			Comment comment = new Comment();
			comment.updateComment(idComment, messageComment);
		} else {
			response.sendRedirect("index");
		}
		

	}

}
