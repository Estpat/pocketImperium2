package model;

import java.util.ArrayList;
import java.util.List;

public class Reserve {
	
	private final List<Vaisseau> vaisseaux; // Liste des vaisseaux dans la réserve
    private final ShipColor couleur; // La couleur des vaisseaux de cette réserve
    private static final int LIMITE_VAISSEAUX = 15; // nombre max de vaisseaux dans la réserve
    
    
    // constructeur
	public Reserve(ShipColor couleur) {
		super();
		this.vaisseaux = new ArrayList<>();
		this.couleur = couleur;
		// initialisation avec 15 vaisseaux
		for (int i = 0; i < LIMITE_VAISSEAUX; i++) {
            vaisseaux.add(new Vaisseau(couleur));
        }
		
	}
	
	// Vérifie si la réserve a assez de vaisseaux
    public boolean hasSufficientShips(int quantity) {
        return vaisseaux.size() >= quantity;
    }

    // Retire un certain nombre de vaisseaux de la réserve
    public List<Vaisseau> retrieveShips(int quantity) {
        if (!hasSufficientShips(quantity)) {
            throw new IllegalArgumentException("Pas assez de vaisseaux dans la réserve.");
        }

        List<Vaisseau> shipsToDeploy = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            shipsToDeploy.add(vaisseaux.remove(0));
        }
        return shipsToDeploy;
    }
    
 // Remet un vaisseau dans la réserve (ex : en cas de destruction)
    public void returnShip(Vaisseau vaisseau) {
        if (vaisseaux.size() >= LIMITE_VAISSEAUX) {
            throw new IllegalStateException("La réserve est pleine. Impossible de renvoyer le vaisseau.");
        }
        vaisseaux.add(vaisseau);
    }
    
 // Getter pour connaître le nombre de vaisseaux restants
    public int getRemainingShips() {
        return vaisseaux.size();
    }

    // Affiche l'état de la réserve
    public void afficherReserve() {
        System.out.println("Réserve de " + couleur + " : " + getRemainingShips() + " vaisseaux restants.");
    }
	

}
