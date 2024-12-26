package model;

import java.io.Serializable;
import java.util.*;

/**
 * Classe abstraite représentant un joueur.
 */
public abstract class Joueur implements Serializable {
    private String nom;
    private List<CommandCard> mainCartes;
    private List<CommandCard> pilePlanification;
    private List<Hexagone> hexagonesContrôlés;
    private int points;
    private int flottesRestantes;
    private boolean aGagne;

    public Joueur(String nom) {
        this.nom = nom;
        this.mainCartes = new LinkedList<>();
        this.pilePlanification = new LinkedList<>();
        this.hexagonesContrôlés = new LinkedList<>();
        this.points = 0;
        this.flottesRestantes = 15; // Par exemple
        this.aGagne = false;
    }

    // Getters et méthodes communes
    public String getName() {
        return nom;
    }

    public List<CommandCard> getMainCartes() {
        return mainCartes;
    }

    public List<CommandCard> getPilePlanification() {
        return pilePlanification;
    }

    public List<Hexagone> getHexagonesContrôlés() {
        return hexagonesContrôlés;
    }

    public void ajouterCarte(CommandCard carte) {
        mainCartes.add(carte);
    }

    public void ajouterHexagone(Hexagone hexagone) {
        hexagonesContrôlés.add(hexagone);
    }

    public void retirerHexagone(Hexagone hexagone) {
        hexagonesContrôlés.remove(hexagone);
    }

    public abstract int choisirNombreVaisseaux(Hexagone hexagone, int vaisseauxDisponibles);

    public int getPoints() {
        return points;
    }

    public void ajouterPoints(int points) {
        this.points += points;
    }

    public boolean toutesLesFlottesEliminees() {
        return flottesRestantes <= 0;
    }

    public void setAGagne(boolean aGagne) {
        this.aGagne = aGagne;
    }

    public boolean aGagne() {
        return aGagne;
    }

    /**
     * Méthode pour gérer le déploiement initial des vaisseaux.
     *
     * @param joueurs  Liste des joueurs.
     * @param secteurs Liste des secteurs disponibles.
     */
    public static void deploiementInitial(List<Joueur> joueurs, List<Secteur> secteurs) {
        System.out.println("Début du déploiement initial des vaisseaux.");
        
        // Première phase : dans le sens des aiguilles d'une montre
        for (Joueur joueur : joueurs) {
            placerVaisseaux(joueur, secteurs, 2);
        }

        // Deuxième phase : dans le sens inverse des aiguilles d'une montre
        List<Joueur> joueursInverse = new ArrayList<>(joueurs);
        Collections.reverse(joueursInverse);

        for (Joueur joueur : joueursInverse) {
            placerVaisseaux(joueur, secteurs, 2);
        }
    }

    /**
     * Place un nombre spécifié de vaisseaux pour un joueur.
     *
     * @param joueur   Le joueur plaçant les vaisseaux.
     * @param secteurs Liste des secteurs disponibles.
     * @param nbVaisseaux Nombre de vaisseaux à placer.
     */
    private static void placerVaisseaux(Joueur joueur, List<Secteur> secteurs, int nbVaisseaux) {
        for (int i = 0; i < nbVaisseaux; i++) {
            Secteur secteurChoisi = null;
            Systeme systemeChoisi = null;

            // Rechercher un secteur inoccupé contenant un système de niveau I inoccupé
            for (Secteur secteur : secteurs) {
                if (!secteur.estOccupe()) {
                    systemeChoisi = secteur.getSystemeLibre(SystemLevel.LEVEL_1);
                    if (systemeChoisi != null && systemeChoisi.getContrôleur() == null) {
                        secteurChoisi = secteur;
                        break;
                    }
                }
            }

            if (secteurChoisi != null && systemeChoisi != null) {
                // Placer les vaisseaux
                systemeChoisi.setContrôleur(joueur);
               
                joueur.flottesRestantes -= 1; // Réduire les flottes disponibles
                System.out.println(joueur.getName() + " a placé des vaisseaux sur " + systemeChoisi.getNom());
            } else {
                System.out.println("Aucun emplacement disponible pour " + joueur.getName());
            }
        }
    }

	public void planification() {
		// TODO Auto-generated method stub
		
	}

	protected abstract ShipColor getCouleur();
}
