package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipementDonne) {
		if (nbTrophee < 200) {
			this.trophees[nbTrophee] = new Trophee(gaulois, equipementDonne);
			nbTrophee++;
		} else {
			System.out.println("Le musée est déjà plein !");
		}
	}
	
	public String extraireInstructionsCaml() {
		String instruction = "let musee = [";
		for (int i=0; i<nbTrophee-1 ; i++) {
			instruction += "\"" + trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement() + "\"; ";
		}
		if (nbTrophee > 0) {
			instruction += "\"" + trophees[nbTrophee-1].getGaulois().getNom() + "\", \"" + trophees[nbTrophee-1].getEquipement() + "\"]";
		}
		return instruction;
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 50);
		Romain minus = new Romain("Minus", 1);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		Romain machin = new Romain("Machin", 1);
		machin.sEquiper(Equipement.CASQUE);
		machin.sEquiper(Equipement.BOUCLIER);
		machin.sEquiper(Equipement.BOUCLIER);
		asterix.frapper(machin);
		asterix.frapper(minus);
		Musee musee = new Musee();
		asterix.faireUneDonnation(musee);
		System.out.println(musee.extraireInstructionsCaml());
	}

}
