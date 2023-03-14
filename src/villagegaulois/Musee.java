package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipementDonne) {
		if (nbTrophee < 200) {
			this.trophees[nbTrophee] = new Trophee(gaulois, equipementDonne);
		} else {
			System.out.println("Le musée est déjà plein !");
		}
	}
	
	
}
