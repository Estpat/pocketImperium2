package model.Joueur;

import java.util.HashMap;

import model.Cards.SectorCard;
import model.Joueur.CardCollection.*;
import model.ShipsCollection.*;

public class Joueur {
	private int IDJoueur;
	private int nombrePoints = 0;
	private Main main;
	private Flotte flotte;
	private Reserve reserve;
	private HashMap<Integer, SectorCard> secteurOccupé;
	
	public Joueur() {
		main = new Main();
	}
	
	public int getNombrePoints() {
		return nombrePoints;
	}
	public void setNombrePoints(int nombrePoints) {
		this.nombrePoints = nombrePoints;
	}
	public void choisirCouleurVaisseaux() {
		
	}
	public int compterPoints() {
		int points = 0;
		return points;
	}
	public void choisirSecteur() {
		
	}
	public boolean vouloirExécuterCommande() {
		return false;
	}
	public void jouer() {
		
	}
}
