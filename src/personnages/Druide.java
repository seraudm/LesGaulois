package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide" + this.nom +"et ma potion peut aller d'une force de" + this.effetPotionMin + "à" + this.effetPotionMax + ".");
		
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
	public void preparerPotion() {
		Random objet = new Random();
		while (forcePotion < this.effetPotionMin) {
			forcePotion = objet.nextInt(this.effetPotionMax + 1);
		}
		if (forcePotion > 7) {
			parler("J'ai prepare une super potion de force" + Integer.toString(this.forcePotion));
		} else {
			parler("Je n'ai pas trouve tous les ingredients, ma potion est seulement de force" + Integer.toString(this.forcePotion));
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
		
	}
}
