package metier.liu.projet2024;

public class Bibliotheque {
	private int idB;
	private String emplacement;

	public Bibliotheque(int idB, String emplacement) {
		super();
		this.idB = idB;
		this.emplacement = emplacement;
	}

	public int getidB() {
		return idB;
	}

	public void setidB(int idB) {
		this.idB = idB;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	@Override
	public String toString() {
		return idB + " - " + emplacement;
	}
}
