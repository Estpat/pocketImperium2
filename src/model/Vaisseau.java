package model;

public class Vaisseau {
	
	private final ShipColor couleur;
	
	
	// constructeur

	public Vaisseau(ShipColor couleur) {
		super();
		this.couleur = couleur;
	}
	
	// Getter pour la couleur
    public ShipColor getCouleur() {
        return couleur;
    }
	
    @Override
    public String toString() {
        return "Vaisseau{" +
                "couleur=" + couleur +
                '}';
    }
    
	

}
