package model.Partie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Partie.Partie;
import model.Cards.SectorCard;
import model.Joueur.Joueur;
import model.Joueur.CardCollection.Pile;

public class Partie implements Serializable{
	private static Partie partie;
	
	private List<Joueur> ListJoueur;
	private EtatDeLaPartie etatDeLaPartie;
	private TypeDePartie typeDePartie;
	private Pile pile;
	private HashMap<Integer, SectorCard> plateau;
	private Joueur activePlayer;
	
	///////////////////////////////CONTRUCTEUR/////////////////////////////////////////////

	private Partie() {
		pile = new Pile(); 
		ListJoueur = new ArrayList<Joueur>();
		plateau = new HashMap<Integer, SectorCard>();
		etatDeLaPartie = EtatDeLaPartie.CREATING;
	}
	public static Partie getPartie() {
		if (partie == null) {
            partie = new Partie();
            return partie;
        } else
            return partie;
	}
	
	///////////////////////GETTERS////AND///SETTERS///////////////////////////////////
	
	public List<Joueur> getListJoueur() {
		return ListJoueur;
	}
	public void setListJoueur(List<Joueur> listJoueur) {
		ListJoueur = listJoueur;
	}
	public EtatDeLaPartie getEtatDeLaPartie() {
		return etatDeLaPartie;
	}
	public void setEtatDeLaPartie(EtatDeLaPartie etatDeLaPartie) {
		this.etatDeLaPartie = etatDeLaPartie;
	}
	public TypeDePartie getTypeDePartie() {
		return typeDePartie;
	}
	public void setTypeDePartie(TypeDePartie typeDePartie) {
		this.typeDePartie = typeDePartie;
	}
	public Pile getPile() {
		return pile;
	}
	public void setPile(Pile pile) {
		this.pile = pile;
	}
	public HashMap<Integer, SectorCard> getPlateau() {
		return plateau;
	}
	public void setPlateau(HashMap<Integer, SectorCard> plateau) {
		this.plateau = plateau;
	}
	public Joueur getActivePlayer() {
		return activePlayer;
	}
	public void setActivePlayer(Joueur activePlayer) {
		this.activePlayer = activePlayer;
	}

}
