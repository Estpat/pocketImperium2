package model.Ships;

import java.util.ArrayList;
import java.util.List;

public class Hexagone {
	private Système système;
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
		return système.getNiveau().ordinal() + 1;	//retourne le niveau du système + 1
	}

}
