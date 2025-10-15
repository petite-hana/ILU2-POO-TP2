package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.printf("Je suis désolé %s mais il faut être un habitant de notre village pour commercer ici.\n", nomVendeur);
			return;
		}

		System.out.printf("Bonjour %s, je vais regarder si je peux vous trouver un étal.\n", nomVendeur);
		if (!controlPrendreEtal.resteEtals()) {
			System.out.printf("Désolée %s, je n'ai plus d'étal qui ne soit pas déjà occupé.\n", nomVendeur);
			return;
		}

		installerVendeur(nomVendeur);
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\nIl me faudrait quelques renseignements :");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");

		int etal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (etal != -1) {
			System.out.printf("Le vendeur %s s'est installé à l'étal n°%d\n", nomVendeur, etal + 1);
		}
	}
}
