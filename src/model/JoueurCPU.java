package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Classe représentant un joueur CPU qui utilise une stratégie de planification.
 */
public class JoueurCPU extends Joueur {
    private PlanificationStrategy strategy;  // La stratégie de planification

    public JoueurCPU(String nom, PlanificationStrategy strategy) {
        super(nom);
        this.strategy = strategy;
    }

    @Override
    public void planification() {
        System.out.println("Phase de planification pour le joueur CPU " + getName() + " :");
        strategy.planifier(this);  // Appelle la stratégie pour planifier les commandes
    }

    @Override
    public int choisirNombreVaisseaux(Hexagone hexagone, int vaisseauxDisponibles) {
        Random random = new Random();
        return random.nextInt(vaisseauxDisponibles + 1);  // Le CPU choisit un nombre aléatoire de vaisseaux.
    }

    // Permet de changer la stratégie du joueur
    public void setStrategy(PlanificationStrategy strategy) {
        this.strategy = strategy;
    }

	@Override
	protected ShipColor getCouleur() {
		// TODO Auto-generated method stub
		return null;
	}
}
