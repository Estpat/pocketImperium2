package model.Joueur.CardCollection;
import java.util.ArrayList;
import java.util.List;

import model.Cards.CommandCard;

public class Main {
	private List<CommandCard> cartesDeLaMain;
	
	public Main() {
		cartesDeLaMain = new ArrayList<CommandCard>();
	}
	public CommandCard prendreCarte(CommandCard c) {
		return c;
	}
	public void choisirOrdre() {
		
	}
	public CommandCard révélerCarte() {
		return cartesDeLaMain.getFirst();
	}

}
