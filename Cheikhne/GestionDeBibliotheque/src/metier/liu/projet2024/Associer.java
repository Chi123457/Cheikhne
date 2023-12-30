package metier.liu.projet2024;

public class Associer {
	private int idB;
	private int idAuteur;
	
	public Associer(int idB, int idAuteur) {
		super();
		this.idB = idB;
		this.idAuteur = idAuteur;
	}

	
	public int getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}

	@Override
	public String toString() {
		return "Associer [idB=" + idB + ", idAuteur=" + idAuteur + "]";
	}

	public String getIdB() {
		// TODO Auto-generated method stub
		return null;
	}

}
