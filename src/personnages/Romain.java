package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		assert force>=0;
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
		assert force>0;
		int forcedebut = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert forcedebut>force;
		
	}
	
	private void messageEquipement(Equipement equipement) {
		System.out.println("Le soldat " + this.nom + " s'equipe avec un " + equipement);
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
			case 0:{
				this.messageEquipement(equipement);
				equipements[0] = equipement;
				nbEquipement ++;	
				break;
				} 
			case 1:{
				if (equipement == equipements[0]) {
					System.out.println("Le soldat Minus possede deja un " + equipement);
					break;
				}
				else {
					this.messageEquipement(equipement);
					equipements[1] = equipement;
					nbEquipement ++;
					break;
				}
			}
			case 2:{
				System.out.println("Le soldat Minus est deja bien protege !");
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		minus.parler("Les gogo les gogo les gaulois");
		minus.recevoirCoup(4);
		minus.recevoirCoup(7);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
