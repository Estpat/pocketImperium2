package model;

import java.util.Collections;

public class StrategieAleatoire implements PlanificationStrategy {

    @Override
    public void planifier(JoueurCPU joueur) {
        // Mélange des cartes de commande et les ajoute à la pile de planification
        Collections.shuffle(joueur.getMainCartes());
        joueur.getPilePlanification().addAll(joueur.getMainCartes());
    }
}
