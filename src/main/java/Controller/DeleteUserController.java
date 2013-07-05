package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.User;

public class DeleteUserController extends ApplicationController {
    private static final long serialVersionUID = 1L;

    public DeleteUserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int idUser = getIdUserLoggedIn(request);
		int idUserDelete = Integer.parseInt(request.getParameter("id"));
        boolean canModifyUser = new User().canModifyUser(idUser, idUserDelete);

        if(canModifyUser) {
            User user = new User();
            user.deleteUser(idUserDelete);			
        }
        if(idUser == idUserDelete) {
        	logout(request);
        }
        
        response.sendRedirect("index");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}

}