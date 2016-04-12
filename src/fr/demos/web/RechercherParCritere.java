package fr.demos.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.SQLClimatisationDAO;
import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class RechercherParCritere
 */
@WebServlet("/RechercherParCritere")
public class RechercherParCritere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercherParCritere() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/RechercherClimatisation.jsp");
		List<Climatisation> listR = new ArrayList<Climatisation>();
			try {
				SQLClimatisationDAO f2 = new SQLClimatisationDAO("jdbc/applicilm");
				String critere = request.getParameter("critere");
				listR = f2.recherche(critere);
				request.setAttribute("listClimatiseurs", listR);
				rd = request.getRequestDispatcher("/AfficherClimatisation");

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("Erreur", e.getMessage());
			}

		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
