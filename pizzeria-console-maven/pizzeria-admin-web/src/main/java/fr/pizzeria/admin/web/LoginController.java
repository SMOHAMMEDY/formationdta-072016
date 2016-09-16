package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class LoginController extends HttpServlet{

	// le get pour appeler le formulaire
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(req, resp);
	}


	// le post pour récupéré login et mdp
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String eMail = req.getParameter("mail");
		String pwd = req.getParameter("pwd");

		if(eMail.equals("admin@pizzeria.fr") && pwd.equals("admin")) {
			req.getSession().setAttribute("email", eMail);
			resp.sendRedirect(req.getContextPath() + "/pizzas/list");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
