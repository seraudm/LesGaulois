package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	private String prendreParole() {
		return "Le gaulois " + this.nom + ":";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"«"+ texte + "»");
	}
	
	public void frapper(Romain romain) {
		System.out.println(this.nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(this.force * this.effetPotion / 3);
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		asterix.parler("Je suis un gaulois");
		System.out.println(asterix.prendreParole());
		Romain minus = new Romain("Minus", 10);
		asterix.boirePotion(4);
		asterix.frapper(minus);
	}
}
