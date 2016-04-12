package fr.demos.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.demos.formation.Climatisation;

public class FileClimatisation implements ClimatisationDAO {
	private String nomFile;
	public FileClimatisation(String nomFile){
		this.nomFile= nomFile;
	}

	@Override
	public void sauve(Climatisation cl) throws Exception {
		// TODO Auto-generated method stub
		List<Climatisation> listClimatiseurs = new ArrayList<Climatisation>();
		try {
			listClimatiseurs = this.rechercheTout();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		listClimatiseurs.add(cl);

		try (ObjectOutputStream ois = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(nomFile)));) {
			ois.writeObject(listClimatiseurs);
			ois.flush();

		}
		this.rechercheTout();
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		ArrayList<Climatisation> listClimatiseurs = null;

		try (ObjectInputStream oos = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(nomFile)));) {
			listClimatiseurs = (ArrayList<Climatisation>) oos.readObject();

		}
		return listClimatiseurs;
		/*
		 * catch (EOFException e) { System.out.println( "fin fichier");
		 * 
		 * } catch (IOException e) { e.printStackTrace();
		 * System.out.println(e.getMessage());
		 * 
		 * } catch (ClassNotFoundException e) {
		 * System.out.println(e.getMessage());
		 * 
		 * }
		 */

	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombreClimatisations(String critere){
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
