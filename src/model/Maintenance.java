package model;

import java.util.List;
import java.util.Map;


public class Maintenance {
	/**
     * Effectue la maintenance des vaisseaux dans tous les hexagones.
     * @param hexagones Liste des hexagones du jeu.
     * @param reserves  Map associant chaque couleur de vaisseau à sa réserve correspondante.
     */
	
    public static void effectuerMaintenance(List<Hexagone> hexagones, Map<ShipColor, Reserve> reserves) {
        for (Hexagone hexagone : hexagones) {
            int capaciteMax = hexagone.getCapaciteMaintien(); // Capacité maximale de l'hexagone
            int surplus = hexagone.getNombreVaisseaux() - capaciteMax;

            if (surplus > 0) {
                // Retirer les vaisseaux excédentaires
                List<Vaisseau> vaisseauxExcedentaires = hexagone.retirerVaisseaux(surplus);

                // Renvoyer les vaisseaux excédentaires à leur réserve respective
                for (Vaisseau vaisseau : vaisseauxExcedentaires) {
                    ShipColor couleur = vaisseau.getCouleur(); // Obtenir la couleur du vaisseau
                    Reserve reserve = reserves.get(couleur);

                    if (reserve != null) {
                        try {
                            reserve.returnShip(vaisseau);
                        } catch (IllegalStateException e) {
                            System.out.println("La réserve " + couleur + " est pleine. Impossible de renvoyer un vaisseau.");
                        }
                    }
                }
            }
        }
    }

	public Maintenance() {
		super();
	}

}
