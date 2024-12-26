package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Secteur {
		private String nom; // Nom du secteur (ex : "Secteur Nord", "Central")
	    private List<Hexagone> hexagones; // Liste des hexagones du secteur
	    private boolean estCentral; // Indique si ce secteur est le secteur central
	    private boolean bandesOrientéesExtérieur; // Orientation des bandes bleues
	    private Joueur contrôleur; // Joueur contrôlant ce secteur
	    private int valeur;
	    private List<Systeme> systemes; // Liste des systèmes dans ce secteur
	    private boolean occupe; // Indique si le secteur est entièrement occupé
	    // Constructeur
	    public Secteur(String nom, boolean estCentral) {
	        this.nom = nom;
	        this.hexagones = new ArrayList<>();
	        this.estCentral = estCentral;
	        this.bandesOrientéesExtérieur = false; // Par défaut, les bandes ne sont pas orientées
	        this.systemes = systemes;
	        this.occupe = false;
	    }

	    // Gestion du nom
	    public String getNom() {
	        return nom;
	    }

	    // Gestion des hexagones
	    public List<Hexagone> getHexagones() {
	        return hexagones;
	    }

	    public void ajouterHexagone(Hexagone hexagone) {
	        hexagones.add(hexagone);
	    }
	    
	 // Orientation des bandes bleues
	    public void orienterBandesVersExterieur(boolean orienter) {
	        this.bandesOrientéesExtérieur = orienter;
	    }

	    public boolean sontBandesOrientéesExtérieur() {
	        return bandesOrientéesExtérieur;
	    }

	    // Distribution aléatoire des systèmes dans le secteur
	    public void distribuerSystèmes() {
	        if (estCentral) {
	            // Secteur central : un seul système de niveau 3
	            if (hexagones.size() > 0) {
	                Hexagone hexagoneCentral = hexagones.get(0);
	                hexagoneCentral.setSysteme(new Systeme(SystemLevel.LEVEL_3, "Tri-Prime"));
	            }
	        } else {
	            // Autres secteurs : 2 systèmes de niveau 1 et 1 système de niveau 2
	            List<Hexagone> hexagonesDisponibles = new ArrayList<>(hexagones);
	            Collections.shuffle(hexagonesDisponibles);

	            // Assigner deux systèmes de niveau 1
	            for (int i = 0; i < 2; i++) {
	                Hexagone hex = hexagonesDisponibles.remove(0);
	                hex.setSysteme(new Systeme(SystemLevel.LEVEL_1, null));
	            }

	            // Assigner un système de niveau 2
	            if (!hexagonesDisponibles.isEmpty()) {
	                Hexagone hex = hexagonesDisponibles.remove(0);
	                hex.setSysteme(new Systeme(SystemLevel.LEVEL_2, null));
	            }
	        }
	    }

	    // Vérifie si le secteur contient des hexagones contrôlés par un joueur donné
	    public boolean estContrôléPar(Joueur joueur) {
	        return hexagones.stream().anyMatch(h -> h.getContrôleur() != null && h.getContrôleur().equals(joueur));
	    }
	    
	 // Vérifie si un secteur est occupé (au moins un hexagone contient un système ou est contrôlé)
	    public boolean estOccupe() {
	        return hexagones.stream().anyMatch(h -> h.getSystemes() != null || h.getContrôleur() != null);
	    }
	    
	    // Gestion du contrôleur
	    public Joueur getContrôleur() {
	        return contrôleur;
	    }

	    public void setContrôleur(Joueur contrôleur) {
	        this.contrôleur = contrôleur;
	    }

	 // Appliquer un doublement de la valeur pour le décompte final
	    public int valeurFinale() {
	        return "Tri-Prime".equals(nom) ? 2 * valeur : valeur;
	    }

	    /**
	     * Renvoie un système de niveau donné qui n'a pas de contrôleur.
	     *
	     * @param niveau Le niveau du système recherché.
	     * @return Un système libre du niveau spécifié, ou null si aucun n'est disponible.
	     */
	    public Systeme getSystemeLibre(SystemLevel niveau) {
	        for (Systeme systeme : systemes) {
	            if (systeme.getNiveau() == niveau && systeme.getContrôleur() == null) {
	                return systeme;
	            }
	        }
	        return null;
	    }
		
 
}
