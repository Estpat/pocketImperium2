package model;
/**
 * Classe abstraite pour gérer les cartes de commande
 * Il s'agit d'une classe mère dont hériteront les classes
 * <ul>
 * <li>
 * Expand</li>
 * <li>Extend</li>
 *  <li>Exterminate</li>
 *  </ul>
 */

public abstract class CommandCard {
	private String nom; // Nom de la carte
    private Joueur joueur; // Joueur qui possède cette carte

    // Constructeur
    public CommandCard(String nom, Joueur joueur) {
        this.nom = nom;
        this.joueur = joueur;
    }

    // Getter pour le nom de la carte
    public String getNom() {
        return nom;
    }

    // Getter pour le joueur
    public Joueur getJoueur() {
        return joueur;
    }

    // Méthode abstraite pour exécuter l'effet de la carte
    public abstract void executerCommande();
	
	
	
}
