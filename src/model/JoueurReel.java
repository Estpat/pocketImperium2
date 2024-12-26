package model;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe représentant un joueur réel.
 */
public class JoueurReel extends Joueur {

    public JoueurReel(String nom) {
        super(nom);
    }

    @Override
    public void planification() {
        System.out.println("Phase de planification pour le joueur " + getName() + " :");
        Scanner scanner = new Scanner(System.in);
        List<CommandCard> cartesRestantes = new LinkedList<>(getMainCartes());

        for (int i = 1; i <= cartesRestantes.size(); i++) {
            System.out.println("Choisissez la commande n°" + i + " à exécuter :");
            for (int j = 0; j < cartesRestantes.size(); j++) {
                System.out.println((j + 1) + ". " + cartesRestantes.get(j).getNom());
            }

            int choix = scanner.nextInt() - 1;
            if (choix >= 0 && choix < cartesRestantes.size()) {
                getPilePlanification().add(cartesRestantes.get(choix));
                cartesRestantes.remove(choix);
            } else {
                System.out.println("Choix invalide !");
                i--; // Refaire ce tour de choix
            }
        }

        System.out.println("Planification terminée !");
    }

    @Override
    public int choisirNombreVaisseaux(Hexagone hexagone, int vaisseauxDisponibles) {
        // Logic to choose how many ships to deploy based on game situation.
        return 0; // To be implemented.
    }

	@Override
	protected ShipColor getCouleur() {
		// TODO Auto-generated method stub
		return null;
	}
}
