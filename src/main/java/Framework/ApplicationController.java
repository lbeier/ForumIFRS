package Framework;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;

public class ApplicationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Renderiza uma view.
	 * @param string
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void render(String string, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Render");
		RequestDispatcher rs = request.getRequestDispatcher(string+".jsp");
		rs.forward(request, response);
	}
	
	/**
	 * Redireciona para algum caminho.
	 * @param string
	 * @param response
	 * @throws IOException
	 */
	public void redirect(String string, HttpServletResponse response) throws IOException {
		System.out.println("Redirect");
        response.sendRedirect(string);
	}
	
	/**
	 * Retorna o id do usuário atualmente logado.
	 * @param request
	 * @return idUser
	 */
	public int getIdUserLoggedIn(HttpServletRequest request) {
		int idUser = (Integer) request.getSession().getAttribute("idUser");
		System.out.println("getIdUserLoggedIn");
		return idUser;
	}
	
	/**
	 * Retorna se o usuário logado é admin ou não.
	 * @param request
	 * @return boolean
	 */
	public boolean isLoggedUserAdmin(HttpServletRequest request) {
		int id = getIdUserLoggedIn(request);
		User user = new User();
		boolean isAdmin = user.isUserAdmin(id);
		System.out.println("isLoggedUserAdmin");
		return isAdmin;
	}
	
	/**
	 * Destrói a sessão.
	 * @param request
	 */
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
}
