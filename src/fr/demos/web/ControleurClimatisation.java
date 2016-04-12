package fr.demos.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.data.FileClimatisation;
import fr.demos.data.SQLClimatisationDAO;
import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class ControleurClimatisation
 */
@WebServlet("/ControleurClimatisation")
public class ControleurClimatisation extends HttpServlet {
	// List<Climatisation> listClimatiseurs = new ArrayList<Climatisation>();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleurClimatisation() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		RequestDispatcher rd1 = request.getRequestDispatcher("/SaisieClimatisation.jsp");
		rd1.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd3 = null;
		String action2 = request.getParameter("ajouter");
		if (action2 != null && action2.equals("Ajouter")) {
			rd3 = request.getRequestDispatcher("/SaisieClimatisation.jsp");
			rd3.forward(request, response);
		}
		String action3 = request.getParameter("liste");
		if (action3 != null && action3.equals("Liste")) {
			rd3 = request.getRequestDispatcher("/ControleurClimatisationSerialisation");
			rd3.forward(request, response);
		}
		String action4 = request.getParameter("deconnexion");
		if (action4 != null && action4.equals("Deconnexion")) {
			session.invalidate();
			rd3 = request.getRequestDispatcher("/Connexion");
			rd3.forward(request, response);
		}
		File file = new File("DataClimatiseurs");
		String action5 = request.getParameter("vider");
		if (action5 != null && action5.equals("Vider")) {
			if(file.exists()){
				file.delete();
				rd3 = request.getRequestDispatcher("/ControleurClimatisationSerialisation");
				rd3.forward(request, response);
			}
			
			
		}
		String action6 = request.getParameter("rechercher");
		if (action6 != null && action6.equals("Rechercher")) {
			rd3 = request.getRequestDispatcher("/RechercherClimatisation.jsp");
			rd3.forward(request, response);
		}
		
		String action7 = request.getParameter("rechercherc");
		if (action7 != null && action7.equals("Rechercherc")) {
			List<Climatisation> listR = new ArrayList<Climatisation>();
			try {
				SQLClimatisationDAO f2 = new SQLClimatisationDAO("jdbc/applicilm");
				String critere = request.getParameter("critere");
				listR = f2.recherche(critere);
				request.setAttribute("listClimatiseurs", listR);
				rd3 = request.getRequestDispatcher("/AfficherClimatisation.jsp");

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("Erreur", e.getMessage());
			}
			
			rd3.forward(request, response);

		}
		

		boolean erreur = false;
		String action = request.getParameter("enregistrer");
		if (action != null && action.equals("Enregistrer")) {
			String nomAppareil = request.getParameter("nomAppareil");
			String temperatureS = request.getParameter("temperature");
			String pressionS = request.getParameter("pression");
			String tauxHumiditéS = request.getParameter("tauxHumidité");
			request.setAttribute("temp", temperatureS);
			request.setAttribute("pre", pressionS);
			request.setAttribute("taux", tauxHumiditéS);
			request.setAttribute("nom", nomAppareil);

			double temperature = 0, pression = 0, tauxHumidité = 0;
			try {
				temperature = Double.parseDouble(temperatureS);

			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("tempE", "incorecte");

			}
			try {

				pression = Double.parseDouble(pressionS);

			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("preE", "incorecte");

			}
			try {

				tauxHumidité = Double.parseDouble(tauxHumiditéS);

			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("tauxE", "incorecte");

			}
			if (nomAppareil == null || nomAppareil.equals("")) {
				request.setAttribute("nomE", "Saisir le nom de cet appareil");
				erreur = true;
			}
			if (pression <= 0) {
				erreur = true;
				request.setAttribute("preE", "incorecte");
			}
			if (tauxHumidité > 100 || tauxHumidité < 0) {
				erreur = true;
				request.setAttribute("tauxE", "incorecte");
			}
			if (!erreur) {
				Climatisation climatiseur = new Climatisation(temperature, pression, tauxHumidité, nomAppareil);
				List<Climatisation> listClimatiseurs = new ArrayList<Climatisation>();
				try{
					SQLClimatisationDAO f2 = new SQLClimatisationDAO("jdbc/applicilm");
					f2.sauve(climatiseur);
					listClimatiseurs = f2.rechercheTout();
					request.setAttribute("listClimatiseurs", listClimatiseurs);
					rd3 = request.getRequestDispatcher("/AfficherClimatisation.jsp");
				}catch(Exception e){
					e.printStackTrace();
					request.setAttribute("Erreur", e.getMessage());
				}
				/*FileClimatisation f = new FileClimatisation("DataClimatiseurs");
				try {
					f.sauve(climatiseur);
					listClimatiseurs = f.rechercheTout();
					request.setAttribute("listClimatiseurs", listClimatiseurs);
					rd3 = request.getRequestDispatcher("/AfficherClimatisation.jsp");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("Erreur", e.getMessage());
				}
				*/
			} else {

				rd3 = request.getRequestDispatcher("/SaisieClimatisation.jsp");
			}
			rd3.forward(request, response);

		}

	}

}
