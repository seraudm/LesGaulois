package personnages;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide" + this.nom +"et ma potion peut aller d'une force de" + this.effetPotionMin + "�" + this.effetPotionMax + ".");
		
	}
	
	public String getNom() {
		return nom;
	}
	
	private String prendreParole() {
		return "Le druide " + this.nom +":";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"«"+ texte + "»");
	}
}
