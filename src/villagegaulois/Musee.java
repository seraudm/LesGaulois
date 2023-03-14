package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

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
			instruction += "\"" + trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement() + "\";";
		}
		instruction += "\"" + trophees[nbTrophee-1].getGaulois().getNom() + "\", \"" + trophees[nbTrophee-1].getEquipement() + "\"]";
		return instruction;
	}
	

}
