package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Thread;

public class DeleteThreadController extends ApplicationController {
    private static final long serialVersionUID = 1L;

    public DeleteThreadController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUSer = getIdUserLoggedIn(request);
        int idThread = Integer.parseInt(request.getParameter("id"));
        boolean canEditThread = new Thread().canUserModifyThread(idUSer, idThread);

        if(canEditThread) {
            Thread thread = new Thread();
            int idSection = thread.findById(idThread).getSection().getIdSection();
            thread.deleteThread(idThread);
        	redirect("exibeSecao?id="+idSection, response);
        } else {
            response.sendRedirect("index");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
}