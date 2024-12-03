package model.Ships;

public class Système {
	private CouleurSystème couleur;
	private Niveau niveau;
	private boolean estOccupé = false;

	public Système(CouleurSystème c, Niveau n) {
		couleur = c;
		niveau = n;
	}
	public CouleurSystème getCouleur() {
		return couleur;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public boolean getOccupation() {
		return estOccupé;
	}
	public void changerOccupation() {
		estOccupé = !estOccupé; //Permet de changer la valeur du booléen
	}
}
