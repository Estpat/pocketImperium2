package model;

import java.util.*;

/**
 * Classe pour représenter un hexagone dans la grille de jeu.
 */
public class Hexagone {
    private String id; // Identifiant unique de l'hexagone (ex : "A1", "B2")
    private Systeme systeme; // Système contenu dans cet hexagone (null si aucun)
    private Joueur contrôleur; // Joueur qui contrôle cet hexagone
    private int q; // Coordonnée Q dans la grille hexagonale
    private int r; // Coordonnée R dans la grille hexagonale
    private List<Hexagone> voisins; // Hexagones adjacents
    private boolean estDemiHexagone; // Indique si cet hexagone est un demi-hexagone
    private final List<Vaisseau> vaisseaux; // Nombre de vaisseaux présents sur l'hexagone

    // Constructeur
    public Hexagone(String id, int q, int r, boolean estDemiHexagone) {
        this.id = id;
        this.q = q;
        this.r = r;
        this.voisins = new ArrayList<>();
        this.estDemiHexagone = estDemiHexagone;
        this.vaisseaux = new ArrayList<>();
    }

    // Getter et setter pour l'identifiant
    public String getId() {
        return id;
    }

    // Gestion du système
    public Systeme getSystemes() {
        return systeme;
    }

    public void setSysteme(Systeme système) {
        this.systeme = système;
    }

    // Gestion du contrôleur
    public Joueur getContrôleur() {
        return contrôleur;
    }

    public void setContrôleur(Joueur contrôleur) {
        this.contrôleur = contrôleur;
    }

    // Coordonnées dans la grille
    public int getQ() {
        return q;
    }

    public int getR() {
        return r;
    }

    // Gestion des voisins
    public List<Hexagone> getVoisins() {
        return voisins;
    }

    public void ajouterVoisin(Hexagone voisin) {
        voisins.add(voisin);
    }

    // Vérifie si l'hexagone est un hexagone de système
    public boolean estHexagoneDeSystème() {
        return systeme != null;
    }

    // Vérifie si l'hexagone est un demi-hexagone
    public boolean estDemiHexagone() {
        return estDemiHexagone;
    }

    // Calcul de la distance à un autre hexagone
    public int calculerDistance(Hexagone autre) {
        int dq = Math.abs(this.q - autre.q);
        int dr = Math.abs(this.r - autre.r);
        int ds = Math.abs((-this.q - this.r) - (-autre.q - autre.r));
        return Math.max(dq, Math.max(dr, ds));
    }

    // Méthode pour interdire l'accès aux demi-hexagones
    public boolean estAccessible() {
        return !estDemiHexagone;
    }
    
    // Méthode pour gérer l'ajout de vaisseaux dans un hexagone
    public void ajouterVaisseaux(int nombre, ShipColor couleur) {
        for (int i = 0; i < nombre; i++) {
            vaisseaux.add(new Vaisseau(couleur));
        }
    }
    
    // Méthode pour gérer la suppression de vaisseaux dans un hexagone
    public List<Vaisseau> retirerVaisseaux(int nombre) {
        List<Vaisseau> vaisseauxRetires = new ArrayList<>();
        for (int i = 0; i < nombre && !vaisseaux.isEmpty(); i++) {
            vaisseauxRetires.add(vaisseaux.remove(0));
        }
        return vaisseauxRetires;
    }
    
    // Méthode pour déplacer des vaisseaux vers un autre hexagone
    

    // Méthode pour obtenir le nombre de vaisseaux présents
    public int getNombreVaisseaux() {
        return vaisseaux.size();
    }

    // Méthode pour calculer la capacité de maintien des vaisseaux
    public int getCapaciteMaintien() {
        // Un hexagone peut maintenir 1 vaisseau de base plus 1 pour chaque niveau de système
        int capacité = 1; // 1 vaisseau de base
        if (this.systeme != null) {
            capacité += this.systeme.getNiveau().value(); // Ajoute le niveau du système
        }
        return capacité;
    }

 

 
   
}
