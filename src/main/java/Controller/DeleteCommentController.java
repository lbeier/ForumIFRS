package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Comment;

public class DeleteCommentController extends ApplicationController {
    private static final long serialVersionUID = 1L;

    public DeleteCommentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUSer = getIdUserLoggedIn(request);
        int idComment = Integer.parseInt(request.getParameter("id"));
        boolean canModifyComment = new Comment().canUserModifyComment(idUSer, idComment);

        if(canModifyComment) {
            Comment comment = new Comment();
            int idThread  = comment.findById(idComment).getThread().getIdThread();
            comment.deleteComment(idComment);
        	redirect("exibeTopico?id="+idThread, response);
        } else {
        	redirect("index", response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
}