package model.Ships;

public class Vaisseau {
	private Couleur couleur;
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public Hexagone getHexagone() {
		return hexagone;
	}
	public void setHexagone(Hexagone hexagone) {
		this.hexagone = hexagone;
	}
	private Hexagone hexagone;
	
	public Vaisseau(Couleur c) {
		couleur = c;
		hexagone = new Hexagone();
	}
	public void déplacer(int idHex) {
		
	}

}
