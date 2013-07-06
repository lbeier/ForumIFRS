package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Section;
import Model.Thread;

public class ShowSectionController extends ApplicationController {
    private static final long serialVersionUID = 1L;

    public ShowSectionController() {
        super();      
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idSection = Integer.parseInt(request.getParameter("id"));
        List<Thread> threads = new Thread().findAllBySection(idSection);
        boolean isAdmin = isLoggedUserAdmin(request);
        Section section = new Section().findById(idSection);

        request.setAttribute("isAdmin", isAdmin);
        request.setAttribute("threads", threads);
        request.setAttribute("section", section);
        
        render("showSection", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
}