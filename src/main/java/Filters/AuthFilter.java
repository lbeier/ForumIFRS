package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();
		String userAuth = (String) session.getAttribute("userAuth");
		
		if(userAuth != null && userAuth.equals("true")) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("/login");
			rs.forward(request, response);
		}
	}

	public void destroy() {};
}