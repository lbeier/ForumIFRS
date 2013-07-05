package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Comment;

public class DeleteCommentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteCommentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        int idUSer = (Integer) session.getAttribute("idUser");
        int idComment = Integer.parseInt(request.getParameter("id"));
        boolean canModifyComment = new Comment().canUserModifyComment(idUSer, idComment);

        if(canModifyComment) {
            Comment comment = new Comment();
            comment.deleteComment(idComment);
        } else {
            response.sendRedirect("index");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
