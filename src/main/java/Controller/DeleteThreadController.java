package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Thread;

public class DeleteThreadController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteThreadController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        int idUSer = (Integer) session.getAttribute("idUser");
        int idThread = Integer.parseInt(request.getParameter("id"));
        boolean canEditThread = new Thread().canUserModifyThread(idUSer, idThread);

        if(canEditThread) {
            Thread thread = new Thread();
            thread.deleteThread(idThread);
        } else {
            response.sendRedirect("index");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
