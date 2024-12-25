package model.ShipsCollection;

import java.util.ArrayList;
import java.util.List;
import model.Ships.*;

public class Flotte {
	private List<Vaisseau> vaisseauxDeLaFlotte;

	public List<Vaisseau> getVaisseauxDeLaFlotte() {
		return vaisseauxDeLaFlotte;
	}
	public void setVaisseauxDeLaFlotte(List<Vaisseau> vaisseauxDeLaFlotte) {
		this.vaisseauxDeLaFlotte = vaisseauxDeLaFlotte;
	}
	public Flotte() {
		vaisseauxDeLaFlotte = new ArrayList<Vaisseau>();
	}
	public void ajouterVaisseau(Vaisseau v) {
		vaisseauxDeLaFlotte.add(v);
	}
	public Vaisseau retirerVaisseau() {
		Vaisseau v = vaisseauxDeLaFlotte.getFirst();
		vaisseauxDeLaFlotte.remove(v);
		return v;
	}

}
