package model.Cards.SpecificCards;

import model.Cards.CommandCard;
import model.Cards.NiveauDePriorité;

public class Expand extends CommandCard{
	private boolean estVisible = false;
	private NiveauDePriorité niveauDePriorité;
	private String nom;

	public Expand() {
		super("Expand", NiveauDePriorité.UN);
	}

}
