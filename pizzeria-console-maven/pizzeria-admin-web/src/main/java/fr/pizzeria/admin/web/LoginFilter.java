package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns={"/*"},description = "Request timer filter") // remplace la supression du web.xml
public class LoginFilter implements Filter{

	private FilterConfig config = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		config.getServletContext().log("LoginFilter initialized");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	// type réel type declaré
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse)response;
		
	
		// Verifier si il y a une session en cour
		// si oui il ya session
			Object emailAuth = httpReq.getSession().getAttribute("email");
			if(emailAuth != null || httpReq.getRequestURI().contains("/login")){
				chain.doFilter(request, response);
			}
			// si le login est pas bon
			else {
				httpResp.sendRedirect(httpReq.getContextPath() + "/login");
			}
			
	}

	@Override
	public void destroy() {
	
	}
	
}
	
