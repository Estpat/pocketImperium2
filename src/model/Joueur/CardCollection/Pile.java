package model.Joueur.CardCollection;

import java.util.ArrayList;
import java.util.List;

import model.Cards.CommandCard;

public class Pile {
	private List<CommandCard> cartesDeLaPile;
	
	public Pile() {
		cartesDeLaPile = new ArrayList<CommandCard>();
	}
	public CommandCard retirerCarte() {
		return cartesDeLaPile.getFirst();
	}
	public void déposerCarte(CommandCard c) {
		cartesDeLaPile.add(c);
	}

}
