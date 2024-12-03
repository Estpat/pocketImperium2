package model.Cards.SpecificCards;

import model.Cards.CommandCard;
import model.Cards.NiveauDePriorité;

public class Explore extends CommandCard{
	private boolean estVisible = false;
	private NiveauDePriorité niveauDePriorité;
	private String nom;
	
	public Explore() {
		super("Explore", NiveauDePriorité.DEUX);
	}

}
