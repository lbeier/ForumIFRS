package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.ApplicationController;
import Model.Tag;
import Model.Thread;
import Model.Thread_Tag;

public class ShowTagController extends ApplicationController {
	private static final long serialVersionUID = 1L;
       
    public ShowTagController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idTag = Integer.parseInt(request.getParameter("id"));
		List<Thread_Tag> threads = new Thread_Tag().findAllThreadssById(idTag); 
		Tag tag = new Tag().findById(idTag);
		
		request.setAttribute("threads", threads);
		request.setAttribute("tag", tag);
		
		render("showTag", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

}
