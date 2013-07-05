package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Comment;
import Model.Section;
import Model.Thread;
import Model.User;

public class DeleteSectionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteSectionController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        int idUSer = (Integer) session.getAttribute("idUser");
        int idSection = Integer.parseInt(request.getParameter("id"));
        boolean isAdmin = new User().isUserAdmin(idUSer);

        if(isAdmin) {
            Section section = new Section();
            section.deleteSection(idSection);
        } else {
            response.sendRedirect("index");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
