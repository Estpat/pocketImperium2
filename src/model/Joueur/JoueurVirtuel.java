package model.Joueur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import model.Cards.*;
import model.Joueur.CardCollection.*;
import model.ShipsCollection.*;

public class JoueurVirtuel extends Joueur implements Strategy{
	
	private int IDJoueur;
	private int nombrePoints = 0;
	private Main main;
	private Flotte flotte;
	private Reserve reserve;
	private HashMap<Integer, SectorCard> secteurOccupé;
	
	public JoueurVirtuel(int id) {
		super(id);
	}
	public enum Strategy{
		DROP, TAKE, NONE
	}
	@Override
	public boolean vouloirExécuterCommande() {
		return new Random().nextBoolean();
	}
	public void choisirOrdre(ArrayList<CommandCard> listeDeCartes) {
		for(int i=0; i<3; i++) {
			main.addCarte(listeDeCartes.getFirst());
			Collections.shuffle(main.getCartesDeLaMain());		//Permet de mélanger le contenu de la main de façon aléatoire
		}
	}
	


}
