package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbvillageois=0;
	
	
	
	public Village(String nom, int nbvillageoismax) {
		super();
		this.nom = nom;
		this.villageois = new Gaulois[nbvillageoismax] ;
		
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbvillageois] = gaulois;
		nbvillageois = nbvillageois + 1;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}
	
	public String getNom() {
		return nom;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du legendaire " + chef.getNom() + " vivent les legendaires gaulois:");
		for (int i=0; i<nbvillageois;i++) {
			System.out.println("- " + villageois[i].getNom());
		}
		
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des irreductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		// Erreur due à l'appel d'un index en dehors du tableau
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Le resultat retourne est null car il n'y a pas de deuxieme gaulois dans le village
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
		
		
	}
}
