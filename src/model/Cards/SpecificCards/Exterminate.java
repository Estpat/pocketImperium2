package model.Cards.SpecificCards;

import model.Cards.CommandCard;
import model.Cards.NiveauDePriorité;

public class Exterminate extends CommandCard{
	private boolean estVisible = false;
	private NiveauDePriorité niveauDePriorité;
	private String nom;

	public Exterminate() {
		super("Exterminate", NiveauDePriorité.TROIS);
	}

}
