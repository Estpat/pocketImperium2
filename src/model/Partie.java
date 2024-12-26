package model;


public class Partie {
    
	public static void main(String[] args) {
        // Création d'une instance de DispositionSecteurs
        DispositionSecteurs disposition = new DispositionSecteurs();
        
        // Initialisation des secteurs avec la disposition
        disposition.initialiserDisposition();
        
        // Association des voisins entre les hexagones
        disposition.associerVoisins();

        // Affichage de la disposition des secteurs pour vérifier
        System.out.println("Disposition des secteurs :");
        disposition.afficherDisposition();

        // Affichage des voisins pour chaque hexagone dans chaque secteur
        System.out.println("\nVoisins des hexagones dans chaque secteur :");
        for (Secteur secteur : disposition.getTousLesSecteurs()) {
            System.out.println("\nSecteur : " + secteur.getNom());
            for (Hexagone hexagone : secteur.getHexagones()) {
                System.out.print("Hexagone " + hexagone.getId() + " (" + hexagone.getQ() + ", " + hexagone.getR() + ")");
                System.out.print(" -> Voisins : ");
                for (Hexagone voisin : hexagone.getVoisins()) {
                    System.out.print(voisin.getId() + " ");
                }
                System.out.println();
            }
        }
        
        
    }
	
	
}
