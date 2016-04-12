package fr.demos.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Connexion() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd1 = request.getRequestDispatcher("/ConnexionNom.jsp");
		rd1.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd2 = null;
		HttpSession session = request.getSession();

		String action = request.getParameter("connecter");
		if (action != null && action.equals("Connecter")) {
			String nomUtilisateur = request.getParameter("nomUtilisateur");
			if (nomUtilisateur == null || nomUtilisateur.equals("")) {
				request.setAttribute("nomUE", "Saisir identifiant");
				rd2 = request.getRequestDispatcher("/ConnexionNom.jsp");
			} else {
				nomUtilisateur = nomUtilisateur.trim();
				session.setAttribute("nomU", nomUtilisateur);
				rd2 = request.getRequestDispatcher("/SaisieClimatisation.jsp");
			}
		} else {
			rd2 = request.getRequestDispatcher("/ConnexionNom.jsp");
		}

		String nomU = (String) session.getAttribute("nomU");
		rd2.forward(request, response);
	}

}
