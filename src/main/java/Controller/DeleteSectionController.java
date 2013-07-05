package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Section;

public class DeleteSectionController extends ApplicationController {
    private static final long serialVersionUID = 1L;

    public DeleteSectionController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idSection = Integer.parseInt(request.getParameter("id"));
        boolean isAdmin = isLoggedUserAdmin(request);

        if(isAdmin) {
            Section section = new Section();
            section.deleteSection(idSection);
        }
        
        redirect("index", response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
}
