package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Thread;

public class EditThreadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditThreadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		int idThread = Integer.parseInt(request.getParameter("id"));
		boolean canEditThread = new Thread().canUserModifyThread(idUSer, idThread);

		if(canEditThread) {
			Thread thread = new Thread().findById(idThread);
			request.setAttribute("thread", thread);
			RequestDispatcher rs = request.getRequestDispatcher("editThread.jsp");
			rs.forward(request, response);
		} else {
			response.sendRedirect("index");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int idUSer = (Integer) session.getAttribute("idUser");
		String titleThread = String.valueOf(request.getParameter("titleThread"));
		String messageThread = String.valueOf(request.getParameter("messageThread"));
		int idThread = Integer.parseInt(request.getParameter("id"));
		boolean canEditThread = new Thread().canUserModifyThread(idUSer, idThread);
		
		if(canEditThread) {
			Thread thread = new Thread();
			thread.updateThread(idThread, titleThread, messageThread);
		} else {
			response.sendRedirect("index");
		}
		

	}

}
