package fr.demos.web;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import fr.demos.data.FileClimatisation;
import fr.demos.data.SQLClimatisationDAO;
import fr.demos.formation.Climatisation;

@WebServlet("/ControleurClimatisationSerialisation")
public class ControleurClimatisationSerialisation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ControleurClimatisationSerialisation() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/AfficherClimatisation.jsp");
		// FileClimatisation f = new FileClimatisation("DataClimatiseurs");
		List<Climatisation> listClimatiseurs = null;
		try {
			SQLClimatisationDAO fSql = new SQLClimatisationDAO("jdbc/applicilm");
			listClimatiseurs = fSql.rechercheTout();
			request.setAttribute("listClimatiseurs", listClimatiseurs);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Erreur", e.getMessage());
		}

		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
