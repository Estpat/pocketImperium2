package model.Joueur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.Cards.CommandCard;
import model.Cards.SectorCard;
import model.Joueur.CardCollection.*;
import model.ShipsCollection.*;

public class JoeurReel extends Joueur {
	private String nom;
	private int IDJoueur;
	private int nombrePoints = 0;
	private Main main;
	private Flotte flotte;
	private Reserve reserve;
	private HashMap<Integer, SectorCard> secteurOccupé;
	
	public JoeurReel(String name, int id) {
		super(id);
		this.setNom(name);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean vouloirExécuterCommande() {
		System.out.println("Voulez-vous exécuter cette commande? O|o(Oui) N|n(Non)");
		char choix = new Scanner(System.in).next().charAt(0);
		if ((choix == 'O')||(choix == 'o'))
			return true;
		if ((choix == 'N')||(choix == 'n'))
			return false;
		else
			return vouloirExécuterCommande();
	}
	public void choisirOrdre(ArrayList<CommandCard> listeDeCartes) {
		for (int i=0; i<3; i++) {
			CommandCard carte = listeDeCartes.getFirst();
			listeDeCartes.removeFirst();
			System.out.println("Choississez la position de la carte" + carte);
			main.addCarte(carte);
		}
	}
	
}
