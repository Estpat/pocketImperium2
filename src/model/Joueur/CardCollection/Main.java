package model.Joueur.CardCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cards.CommandCard;

public class Main {
	private List<CommandCard> cartesDeLaMain;
	
	public Main() {
		cartesDeLaMain = new ArrayList<CommandCard>();
	}
	/*
	 * Cette méthode permet de prendre une carte (carte qu'on aura retiré de la pile) pour la ranger dans la main
	 */
	public CommandCard prendreCarte(CommandCard c) {
		return c;
	}
	/*
	 * Cette méthode permet de révéler la carte à joueur par le joueur
	 */
	public CommandCard revelerCarte() {
		return cartesDeLaMain.getFirst();
	}
	/*
	 * Cette méthode permet d'ajouter dans la main une carte de commande à un index précis( pratique lors du choix de l'ordre par le joueur)
	 */
	public void addCarte(CommandCard c) {
		int index = new Scanner(System.in).nextInt();
		while((index != 1) && (index != 2) && (index != 3)) {
			System.out.println("Veuillez choisir une position entre 1, 2 et 3 ");
			index = new Scanner(System.in).nextInt();
		}
		cartesDeLaMain.add(index-1, c); 
	}
	public List<CommandCard> getCartesDeLaMain(){
		return cartesDeLaMain;
	}
	/*
	 * Cette méthode permet de retirer la carte que le joueur vient de jouer de sa main
	 */
	public void removeCard() {
		cartesDeLaMain.remove(cartesDeLaMain.getFirst());
	}

}
