/**
 * 
 */
package model.Cards;

/**
 * 
 */
public class CommandCard {

	private boolean estVisible = false;
	private NiveauDePriorité niveauDePriorité;
	private String nom;
	
	public CommandCard(String name, NiveauDePriorité niveau) {
		this.nom = name;
		this.niveauDePriorité = niveau;
	}
	@Override
	public String toString() {
		return "CommandCard [estVisible=" + estVisible + ", niveauDePriorité=" + niveauDePriorité + ", nom=" + nom
				+ "]";
	}
	public boolean isEstVisible() {
		return estVisible;
	}
	public NiveauDePriorité getNiveauDePriorité() {
		return niveauDePriorité;
	}
	public String getNom() {
		return nom;
	}
	public boolean equals(Object obj) {
		if(obj instanceof CommandCard){
			CommandCard C = (CommandCard) obj;
			return C.nom == nom && C.niveauDePriorité == niveauDePriorité;
		}
		return false;
	}
	
	public void exécuterCommande(int quantite) {
		
	}

}
