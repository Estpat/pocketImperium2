package model;
/**
 * Classe représentant un système dans un hexagone.
 */
public class Systeme {
	 private SystemLevel niveau; // Niveau du système (I, II, III)
	    private String nom; // Nom spécifique (par exemple "Tri-Prime" pour LEVEL_3)
	    private Joueur contrôleur; // Joueur contrôlant ce système

	    // Constructeur
	    public Systeme(SystemLevel niveau, String nom) {
	        this.niveau = niveau;
	        this.nom = nom;
	    }

	    // Gestion du niveau
	    public SystemLevel getNiveau() {
	        return niveau;
	    }

	    // Gestion du nom
	    public String getNom() {
	        return nom;
	    }

	    // Gestion du contrôleur
	    public Joueur getContrôleur() {
	        return contrôleur;
	    }

	    public void setContrôleur(Joueur contrôleur) {
	        this.contrôleur = contrôleur;
	    }

	    // Vérifie si un joueur contrôle ce système
	    public boolean estContrôléPar(Joueur joueur) {
	        return contrôleur != null && contrôleur.equals(joueur);
	    }
    
}
