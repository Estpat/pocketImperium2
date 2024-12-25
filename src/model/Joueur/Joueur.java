package model.Joueur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.Cards.*;
import model.Joueur.CardCollection.*;
import model.Ships.Couleur;
import model.Ships.Vaisseau;
import model.ShipsCollection.*;

public abstract class Joueur {
	private int IDJoueur;
	private int nombrePoints = 0;
	private Main main;
	private Flotte flotte;
	private Reserve reserve;
	private HashMap<Integer, SectorCard> secteurOccupé;
	
	public Joueur(int id) {
		this.IDJoueur = id;
        this.main = new Main();
        this.flotte = new Flotte();
        this.reserve = new Reserve();
        this.secteurOccupé = new HashMap<>();
	}
	
	public int getNombrePoints() {
		return nombrePoints;
	}
	public void setNombrePoints(int nombrePoints) {
		this.nombrePoints += nombrePoints;
	}
	public void setCouleurVaisseaux(Couleur C) {
		for(Vaisseau V: flotte.getVaisseauxDeLaFlotte())
			V.setCouleur(C);
	}
	public void compterPoints() {
		int points = 0;
		for(SectorCard secteur: secteurOccupé.values())
			points += secteur.getTotalLevel();
		this.setNombrePoints(points);
	}
	public void choisirSecteur(int idSecteur, SectorCard secteur) {
		secteurOccupé.put(idSecteur, secteur);
	}
	public abstract boolean vouloirExécuterCommande();
	public abstract void choisirOrdre(ArrayList<CommandCard> listeDeCartes);
	
	public void jouer() {
		
	}
}
