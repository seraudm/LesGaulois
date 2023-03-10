package personnages;

public class Chef {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	
	public Chef(String nom, int force, Village village) {
		super();
		this.nom = nom;
		this.force = force;
		this.village = village;
		village.setChef(this);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"«"+ texte + "»");
	}
	
	private String prendreParole() {
		return "Le chef " + this.nom + ":";
	}
	
	public void frapper(Romain romain) {
		System.out.println(this.nom + "envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(this.force / 3);
	}
}
