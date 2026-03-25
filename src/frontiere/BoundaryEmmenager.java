package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue Druide " + nomVisiteur + ".\n");
		question.append("Quelle est votre force ?\n");
		int forceDruide = Clavier.entrerEntier(question.toString());
		
		int effetPotionMax;
		int effetPotionMin;
		
		do	{
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez?\n");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez?\n");
			
			if (effetPotionMax < effetPotionMin ) {
				System.err.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			}
		} while (effetPotionMax < effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);

	}
	
	
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue villageois " + nomVisiteur + ".\n");
		question.append("Quelle est votre force? \n");
		int force = Clavier.entrerEntier(question.toString());
		
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
