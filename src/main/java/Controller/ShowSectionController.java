package Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Thread;
import Model.User;

public class ShowSectionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShowSectionController() {
        super();      
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        int idUSer = (Integer) session.getAttribute("idUser");
        int idSection = Integer.parseInt(request.getParameter("id"));
        List<Thread> threads = new Thread().findAllBySection(idSection);
        boolean isAdmin = new User().isUserAdmin(idUSer);

        request.setAttribute("isAdmin", isAdmin);
        request.setAttribute("threads", threads);
        request.setAttribute("idSection", idSection);
        RequestDispatcher rs = request.getRequestDispatcher("showSection.jsp");
        rs.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}

}
