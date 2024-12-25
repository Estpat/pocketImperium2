package model.Joueur.CardCollection;

import java.util.ArrayList;
import java.util.List;

import model.Cards.CommandCard;
import model.Cards.SpecificCards.Expand;
import model.Cards.SpecificCards.Explore;
import model.Cards.SpecificCards.Exterminate;

public class Pile {
	private List<CommandCard> cartesDeLaPile;
	
	public Pile() {
		cartesDeLaPile = new ArrayList<CommandCard>();
		remplirPile();
	}
	public CommandCard retirerCarte() {
		return cartesDeLaPile.getFirst();
	}
	public void remplirPile() {
		////////Permet de rajouter 3 triplets de CommandCard dans la pile//////
		for(int i=0; i<3; i++) {
			cartesDeLaPile.add(new Expand());
			cartesDeLaPile.add(new Explore());
			cartesDeLaPile.add(new Exterminate());
		}
	}

}
