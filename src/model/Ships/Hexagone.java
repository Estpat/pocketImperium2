package model.Ships;

import java.util.ArrayList;
import java.util.List;

public class Hexagone {
	private Système systeme;
	private List<Vaisseau> vaisseaux;
	private static int nombreHexagones = 0;
	private final int IDHexagone;
	private boolean estDemi;

	public Hexagone() {
		vaisseaux = new ArrayList<Vaisseau>();
		IDHexagone = ++nombreHexagones;
	}
	public void examinerHexagone() {
		
	}
	public int getNombreVaisseauxMax() {
		if(systeme != null)
			return systeme.getNiveau().ordinal() + 1;	//retourne le niveau du système + 1
		return 1;
	}
	public int getTotalLevel() {
		if (systeme != null)
			return systeme.getNiveau().ordinal();	//Retourne la valeur en entier du niveau du système contenu dans l'hexagone(s'il y en a un)
		return 0;
	}

}
