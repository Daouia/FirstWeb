package fr.demos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.formation.Climatisation;

public class SQLClimatisationDAO implements ClimatisationDAO {
	private DataSource ds = null;

	/**
	 * 
	 */
	String nomSQL;// "jdbc/applicilm";

	public SQLClimatisationDAO(String nomSQL) throws Exception {
		// recherche dans l'annuaire d'une pool d connexion
		this.nomSQL = nomSQL;
		Context context = new InitialContext();
		ds = (DataSource) context.lookup(nomSQL);
	}

	@Override
	public void sauve(Climatisation cl) throws Exception {
		// TODO Auto-generated method stub
		// pon demande une connexion au pool
		Connection cx = ds.getConnection();
		// preparation de la requete sql
		PreparedStatement psmt = cx.prepareStatement("insert into DataClimatiseurs values (?,?,?,?,?)");
		psmt.setString(1, cl.getNomAppareil());
		psmt.setDouble(2, cl.getTemperature());
		psmt.setDouble(3, cl.getPression());
		psmt.setDouble(4, cl.getTauxHumidité());
		psmt.setTimestamp(5, new Timestamp(cl.getDate().getTime()));
		psmt.executeUpdate();
		cx.close();

	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		Connection cx = ds.getConnection();
		PreparedStatement psmt = cx.prepareStatement("select * from DataClimatiseurs");
		java.sql.ResultSet rs = psmt.executeQuery();
		ArrayList<Climatisation> liste = new ArrayList<>();
		while (rs.next()) {
			String nomAppareil = rs.getString(1);
			double temperature = rs.getDouble(2);
			double pression = rs.getDouble(3);
			double tauxHumidite = rs.getDouble(4);
			Timestamp date = rs.getTimestamp(5);
			Climatisation cl = new Climatisation(temperature, pression, tauxHumidite, nomAppareil);
			liste.add(cl);

		}
		return liste;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		Connection cx = ds.getConnection();
		PreparedStatement psmt = cx
				.prepareStatement("select nomAppareil from DataClimatiseurs where nomAppareil = ?");
		psmt.setString(1, critere);
		java.sql.ResultSet rs = psmt.executeQuery();
		List<Climatisation> liste = new ArrayList<>();
		while (rs.next()) {
			// if(rs.getString(1).equals(critere)){
			String nomAppareil = rs.getString(1);
			double temperature = rs.getDouble(2);
			double pression = rs.getDouble(3);
			double tauxHumidite = rs.getDouble(4);
			Timestamp date = rs.getTimestamp(5);
			Climatisation cl = new Climatisation(temperature, pression, tauxHumidite, nomAppareil);
			liste.add(cl);

			// }
		}
		return liste;
	}

	@Override
	public int nombreClimatisations(String critere) {

		List<Climatisation> listClimatiseurs = null;
		try {
			listClimatiseurs = this.rechercheTout();
		} catch (Exception e) {
			listClimatiseurs = new ArrayList<Climatisation>();
			System.out.println(e.getMessage());
		}
		return listClimatiseurs.size();

	}

}
