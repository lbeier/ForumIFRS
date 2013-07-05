package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Section;
import Model.Thread;
import Model.User;

public class NewThreadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewThreadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idSection = Integer.parseInt(request.getParameter("idSection"));
		request.setAttribute("idSection", idSection);
		RequestDispatcher rs = request.getRequestDispatcher("newThread.jsp");
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idUser = (Integer) session.getAttribute("idUser");
		String titleThread = request.getParameter("titleThread");
		String messageThread = request.getParameter("messageThread");
		int idSection = Integer.parseInt(request.getParameter("idSection"));

		Thread thread = new Thread();
		User user = new User();
		Section section = new Section();

		thread.setTitleThread(titleThread);
		thread.setMessageThread(messageThread);		
		thread.setUser(user.findById(idUser));
		thread.setSection(section.findById(idSection));

		int idThread = thread.insertNewThread(thread);

		response.sendRedirect("exibeTopico?id="+idThread);
	}

}