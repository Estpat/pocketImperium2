package model;

import java.util.*;

/**
 * Classe pour gérer la disposition des secteurs sur l'aire de jeu.
 */
public class DispositionSecteurs {
    private Secteur[][] grille; // Grille 3x3 pour les secteurs
    private Secteur triPrime; // Secteur central "Tri-Prime"
    private List<Secteur> secteursSansBande; // Secteurs sans bande bleue
    private List<Secteur> secteursAvecBande; // Secteurs avec bande bleue
    private Reserve reserve;

    // Constructeur
    public DispositionSecteurs() {
        this.grille = new Secteur[3][3];
        this.secteursSansBande = new ArrayList<>();
        this.secteursAvecBande = new ArrayList<>();
        this.triPrime = new Secteur("Tri-Prime", true);                                                
    }

    /**
     * Initialise la disposition des secteurs selon les règles du jeu.
     */
    public void initialiserDisposition() {
        // Initialisation des secteurs
        this.triPrime = creerSecteurCentral(); // Secteur central
        for (int i = 0; i < 2; i++) {
            secteursSansBande.add(creerSecteurNonCentral("Secteur Sans Bande " + (i + 1)));
        }
        for (int i = 0; i < 6; i++) {
            secteursAvecBande.add(creerSecteurNonCentral("Secteur Avec Bande " + (i + 1)));
        }

        // Placement de Tri-Prime au centre
        grille[1][1] = triPrime;

        // Mélanger les secteurs
        Collections.shuffle(secteursSansBande);
        Collections.shuffle(secteursAvecBande);

        // Placement des secteurs sans bande et avec bande
        grille[1][0] = secteursSansBande.remove(0); // À gauche de Tri-Prime
        grille[1][2] = secteursSansBande.remove(0); // À droite de Tri-Prime

        grille[0][0] = secteursAvecBande.remove(0); // Haut-gauche
        grille[0][1] = secteursAvecBande.remove(0); // Haut-centre
        grille[0][2] = secteursAvecBande.remove(0); // Haut-droite
        grille[2][0] = secteursAvecBande.remove(0); // Bas-gauche
        grille[2][1] = secteursAvecBande.remove(0); // Bas-centre
        grille[2][2] = secteursAvecBande.remove(0); // Bas-droite

        // Vérifier et ajuster les orientations des secteurs avec bande
        ajusterOrientationDesBandes();    
        associerVoisins();
    }

    /**
     * Crée le secteur central "Tri-Prime".
     *
     * @return Secteur central contenant un hexagone complet avec un système de niveau 3.
     */
    private Secteur creerSecteurCentral() {
        Secteur triPrime = new Secteur("Tri-Prime", true);
        Hexagone hexagoneCentral = new Hexagone("HexCentral", 0, 0, false);
        Systeme systemeTriPrime = new Systeme(SystemLevel.LEVEL_3, "Tri-Prime");
        hexagoneCentral.setSysteme(systemeTriPrime);
        triPrime.ajouterHexagone(hexagoneCentral);
        return triPrime;
    }

    /**
     * Crée un secteur non central avec la disposition spécifique des hexagones.
     *
     * @param nom Nom du secteur.
     * @return Secteur avec 5 hexagones complets et 4 demi-hexagones.
     */
    private Secteur creerSecteurNonCentral(String nom) {
        Secteur secteur = new Secteur(nom, false);

        // Création des systèmes
        Systeme systeme1 = new Systeme(SystemLevel.LEVEL_1, nom + " Système 1");
        Systeme systeme2 = new Systeme(SystemLevel.LEVEL_1, nom + " Système 2");
        Systeme systeme3 = new Systeme(SystemLevel.LEVEL_2, nom + " Système 3");

        // Création des hexagones complets
        Hexagone hex1 = new Hexagone(nom + " Hex1", 0, 0, false);
        hex1.setSysteme(systeme1);

        Hexagone hex2 = new Hexagone(nom + " Hex2", 1, 0, false);
        hex2.setSysteme(systeme2);

        Hexagone hex3 = new Hexagone(nom + " Hex3", 0, 1, false);
        hex3.setSysteme(systeme3);

        Hexagone hex4 = new Hexagone(nom + " Hex4", -1, 1, false);
        Hexagone hex5 = new Hexagone(nom + " Hex5", -1, 0, false);

        // Ajout des hexagones au secteur
        secteur.ajouterHexagone(hex1);
        secteur.ajouterHexagone(hex2);
        secteur.ajouterHexagone(hex3);
        secteur.ajouterHexagone(hex4);
        secteur.ajouterHexagone(hex5);

        // Création des demi-hexagones
        secteur.ajouterHexagone(new Hexagone(nom + " DemiHex1", 2, 0, true));
        secteur.ajouterHexagone(new Hexagone(nom + " DemiHex2", 0, 2, true));
        secteur.ajouterHexagone(new Hexagone(nom + " DemiHex3", -2, 0, true));
        secteur.ajouterHexagone(new Hexagone(nom + " DemiHex4", 0, -2, true));

        return secteur;
    }

    /**
     * Assure que les bords avec une bande bleue des secteurs sont orientés vers l'extérieur.
     */
    private void ajusterOrientationDesBandes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Secteur secteur = grille[i][j];
                if (secteur != null && secteursAvecBande.contains(secteur)) {
                    // Les bords extérieurs de la grille (indices 0 ou 2) doivent avoir les bandes bleues
                    boolean estSurBordExterne = (i == 0 || i == 2 || j == 0 || j == 2);
                    secteur.orienterBandesVersExterieur(estSurBordExterne);
                }
            }
        }
    }

    /**
     * Affiche la disposition des secteurs pour visualisation.
     */
    public void afficherDisposition() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grille[i][j] != null) {
                    System.out.print(grille[i][j].getNom() + "\t");
                } else {
                    System.out.print("Vide\t");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Met à jour les relations entre les hexagones pour gérer leurs voisins.
     */
    public void associerVoisins() {
        // Liste des directions possibles pour les voisins dans une grille hexagonale
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {-1, 1}
        };

        // Parcourir chaque secteur
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Secteur secteur = grille[i][j];
                if (secteur == null) continue;

                // Parcourir chaque hexagone dans le secteur
                for (Hexagone hexagone : secteur.getHexagones()) {
                    int q = hexagone.getQ();
                    int r = hexagone.getR();

                    // Trouver les hexagones voisins
                    for (int[] direction : directions) {
                        int voisinQ = q + direction[0];
                        int voisinR = r + direction[1];

                        // Rechercher un hexagone avec ces coordonnées
                        Hexagone voisin = trouverHexagone(voisinQ, voisinR);
                        if (voisin != null) {
                            hexagone.ajouterVoisin(voisin);
                        }
                    }
                }
            }
        }
    }

    /**
     * Recherche un hexagone avec les coordonnées données dans tous les secteurs.
     * 
     * @param q La coordonnée Q de l'hexagone.
     * @param r La coordonnée R de l'hexagone.
     * @return L'hexagone correspondant, ou null s'il n'est pas trouvé.
     */
    private Hexagone trouverHexagone(int q, int r) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Secteur secteur = grille[i][j];
                if (secteur == null) continue;

                for (Hexagone hexagone : secteur.getHexagones()) {
                    if (hexagone.getQ() == q && hexagone.getR() == r) {
                        return hexagone;
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Récupère tous les secteurs dans la disposition.
     */
    public List<Secteur> getTousLesSecteurs() {
        List<Secteur> secteurs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grille[i][j] != null) {
                    secteurs.add(grille[i][j]);
                }
            }
        }
        return secteurs;
    }
    

}
