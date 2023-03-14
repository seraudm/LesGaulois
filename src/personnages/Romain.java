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
	
	public int getForce() {
		return force;
	}
	
	private String prendreParole() {
		return "Le romain " + this.nom + ":";
	}

	public void parler(String texte) {
		System.out.println(prendreParole()+"«"+ texte + "»");
	}

	//	public void recevoirCoup(int forceCoup) {
	//		assert force>0;
	//		int forcedebut = force;
	//		force -= forceCoup;
	//		if (force > 0) {
	//			parler("Aie");
	//		} else {
	//			parler("J'abandonne...");
	//		}
	//		assert forcedebut>force;
	//		
	//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
		 	parler("Aïe");
		 } else {
		 	equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		 }
		
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (forceCoup>resistanceEquipement) {
			forceCoup -= resistanceEquipement;
		} else {
			forceCoup = 0;
		}
		
		return forceCoup;
	}

	private void messageEquipement(Equipement equipement) {
		System.out.println("Le soldat " + this.nom + " s'equipe avec un " + equipement);
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
			}
			else {
				this.messageEquipement(equipement);
				equipements[1] = equipement;
				nbEquipement ++;
			}
			break;
		}
		default :{
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
