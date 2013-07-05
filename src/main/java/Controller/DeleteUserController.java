package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;

public class DeleteUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteUserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = ((HttpServletRequest) request).getSession();
		int idUser = (Integer) session.getAttribute("idUser");
		int idUserDelete = Integer.parseInt(request.getParameter("id"));
        boolean canModifyUser = new User().canModifyUser(idUser, idUserDelete);

        if(canModifyUser) {
            User user = new User();
            user.deleteUser(idUserDelete);
			response.sendRedirect("index");
        } else {
			response.sendRedirect("index");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}