package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Cette classe permet de gérer les flottes : on rappelle 
 * qu'une flotte représente l'ensemble des vaisseaux situés
 * dans un même hexagone
 */

public class Flotte {
	
	 private final List<Vaisseau> vaisseaux; // Liste des vaisseaux dans la flotte
	 private final ShipColor couleur;
	 
	// Constructeur
	    public Flotte(ShipColor couleur) {
	        this.couleur = couleur;
	        this.vaisseaux = new ArrayList<>();
	    }
	    
	 // Ajoute des vaisseaux à la flotte
	    public void ajouterVaisseaux(List<Vaisseau> nouveauxVaisseaux) {
	        for (Vaisseau vaisseau : nouveauxVaisseaux) {
	            if (!vaisseau.getCouleur().equals(this.couleur)) {
	                throw new IllegalArgumentException("Impossible d'ajouter un vaisseau d'une couleur différente.");
	            }
	        }
	        vaisseaux.addAll(nouveauxVaisseaux);
	    }

	    // Retire un certain nombre de vaisseaux de la flotte
	    public List<Vaisseau> retirerVaisseaux(int quantity) {
	        if (quantity > vaisseaux.size()) {
	            throw new IllegalArgumentException("Pas assez de vaisseaux dans la flotte.");
	        }

	        List<Vaisseau> removedShips = new ArrayList<>();
	        for (int i = 0; i < quantity; i++) {
	            removedShips.add(vaisseaux.remove(0));
	        }
	        return removedShips;
	    }
	    
	 // Retourne le nombre de vaisseaux dans la flotte
	    public int getTaille() {
	        return vaisseaux.size();
	    }

	    // Affiche la flotte
	    public void afficherFlotte() {
	        System.out.println("Flotte de " + couleur + " : " + getTaille() + " vaisseaux.");
	    }
	    

}
