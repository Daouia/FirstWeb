package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficheEntete
 */
@WebServlet("/AfficheEntete")
public class AfficheEntete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheEntete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		Enumeration<String> nomsEntete2 = request.getHeaderNames();
		
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Afficher Entetes</title>");
			out.println("</head>");
			out.println("<body>");
			while(nomsEntete2.hasMoreElements()){
				String name = nomsEntete2.nextElement();
				out.println("nom :" +name+", valeur : "+request.getHeader(name));
				out.println("<br>");
			}
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
