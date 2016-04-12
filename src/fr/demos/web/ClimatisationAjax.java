package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.FileClimatisation;
import fr.demos.data.SQLClimatisationDAO;

/**
 * Servlet implementation class ClimatisationAjax
 */
@WebServlet("/ClimatisationAjax")
public class ClimatisationAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClimatisationAjax() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClimatisationDAO dao;
		PrintWriter out = response.getWriter();
		try {
			dao = new SQLClimatisationDAO("jdbc/applicilm");
			int nb = dao.nombreClimatisations("");

			out.println(" Il y a " + nb + " climatiseurs enregistrés");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
