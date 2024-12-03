package model.Joueur;

import java.util.HashMap;

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
	
	public JoeurReel(String name) {
		super();
		this.setNom(name);
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
