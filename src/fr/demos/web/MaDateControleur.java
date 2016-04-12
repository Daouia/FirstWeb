package fr.demos.web;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Timer;

import fr.demos.formation.Climatisation;




/**
 * Servlet implementation class AfficherDate
 */
@WebServlet("/MaDateControleur")
public class MaDateControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaDateControleur() {
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

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("'On est le 'dd/MM/yyyy ' et il est ' H 'heures et 'mm' minutes et ' ss 'secondes' ");
		
		Climatisation clim1 = new Climatisation(37,1013,0,"214");
		
		
		request.setAttribute("dateDuJour", sdf.format(d));
		request.setAttribute("clim1", clim1);
		RequestDispatcher rd = request.getRequestDispatcher("/madateView.jsp");// dispatch
																				// la
																				// requete
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
