package model.Cards;

import java.util.HashMap;

import model.Ships.Hexagone;

public class SectorCard {

	private boolean estOccupé = false;
	private HashMap<Integer, Hexagone> hexagones;
	
	public SectorCard() {
		hexagones = new HashMap<Integer, Hexagone>();
	}
	
	public boolean getOccupation() {
		return this.estOccupé;
	}
	public void setOccupation() {
		this.estOccupé = true;
	}
	public void marquerSecteur() {
		
	}

	public int getTotalLevel() {
		int level = 0;
		for(Hexagone h: hexagones.values())
			level += h.getTotalLevel();
		return 0;
	}

}
