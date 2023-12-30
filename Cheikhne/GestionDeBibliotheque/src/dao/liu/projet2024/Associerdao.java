package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet2024.DbConnection;
import metier.liu.projet2024.Associer;
import metier.liu.projet2024.Bibliotheque;

public class Associerdao implements dao<Associer> {
	private Connection conn;
	public Associerdao() {
		try {
			conn = DbConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Associer get( int idB, int idAuteur) {
		Associer association = null;
		String requet = "SELECT * FROM Associer WHERE idbibliotheque = "+idB+" AND idAuteur = "+idAuteur;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				association = new Associer(idB, idAuteur);
				System.out.println(association.toString());
				System.out.println();
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return association;
	}

	@Override
	public Associer get(long id) {
		Associer associer = null;
		String requet = "SELECT * FROM Associer  WHERE idAuteur = " + (int) id;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				int idBibliotheque = rs.getInt("idBibliotheque");
				int idAuteur = rs.getInt("idAuteur");
				associer = new Associer(idBibliotheque, idAuteur);
				System.out.println(associer.toString());
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return associer;
	}

	@Override
	public List<Associer> getAll() {
		
		Associer associer = null;
		ArrayList<Associer> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM Associer";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int idB = rs.getInt("idB");
					int idAuteur = rs.getInt("idAuteur");
					associer = new Associer(idB, idAuteur);
					arrayList.add(associer);
					System.out.println(associer.toString());
				} while (rs.next());
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public void save(Associer t) {
		String requet = "INSERT INTO Associer(idB, idAuteur) VALUES("+t.getIdB()+", '"+t.getIdAuteur()+"')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tAssociation enregistree !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Associer t, String[] params) {

	}
		
		
	

	@Override
	public void delete(Associer t) {
		String requet = "DELETE FROM Associer WHERE idBibliotheque = " + t.getIdB() + "AND idAuteur = " + t.getIdAuteur();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tAssociation supprimee !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}
		}
		
		public static void main(String[] args) {
			Associerdao associerdao =new Associerdao();
			//Associerdao associerdao = new Associer (2,3);
		    //assdao.save(ass8);
			associerdao.getAll();
			//associerdao.get(2);
		}

		@Override
		public Bibliotheque getByID(long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}