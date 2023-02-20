package personnages;

public class Romain {
	private String nom;
	private int force;
	
	
	
	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}



	public String getNom() {
		return nom;
	}
	
	private String prendreParole() {
		return "Le romain " + this.nom + ":";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"«"+ texte + "»");
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}

	}
}
