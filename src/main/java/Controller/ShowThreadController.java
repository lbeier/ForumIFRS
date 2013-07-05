package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;

import Model.Comment;
import Model.Thread;
import Model.User;

public class ShowThreadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowThreadController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idThread = Integer.parseInt(request.getParameter("id"));
		Thread thread = new Thread().findById(idThread);
		List<Comment> comments = new Comment().findAllByThread(idThread);
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		boolean canEditThread = new Thread().canUserModifyThread(idUSer, idThread);
		boolean isAdmin = new User().isUserAdmin(idUSer);

		request.setAttribute("isAdmin", isAdmin);
		request.setAttribute("canEditThread", canEditThread);
		request.setAttribute("idUSer", idUSer);
		request.setAttribute("thread", thread);
		request.setAttribute("comments", comments);
		RequestDispatcher rs = request.getRequestDispatcher("showThread.jsp");
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

}
