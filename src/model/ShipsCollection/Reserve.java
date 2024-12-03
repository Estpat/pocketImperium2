package model.ShipsCollection;

import java.util.ArrayList;
import java.util.List;
import model.Ships.*;

public class Reserve {
	private List<Vaisseau> vaisseauxDeLaReserve;

	public Reserve() {
		vaisseauxDeLaReserve = new ArrayList<Vaisseau>();
	}
	public void ajouterVaisseau(Vaisseau v) {
		vaisseauxDeLaReserve.add(v);
	}
	public Vaisseau retirerVaisseau() {
		Vaisseau v = vaisseauxDeLaReserve.getFirst();
		vaisseauxDeLaReserve.remove(v);
		return v;
	}

}
