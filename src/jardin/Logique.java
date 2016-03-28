/**
 * 
 */
package jardin;

/**
 * @author Ousmane3
 *
 */
public class Logique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IJardin monJardin =new Jardin();
		
		IFleur uneFleur =new Fleur(Taille.values()[0], Couleur.values()[0], Espece.values()[0], Nom.values()[0]);
		IFleur uneDeuxiemeFleur =new Fleur(Taille.values()[1], Couleur.values()[1], Espece.values()[1], Nom.values()[1]);
 		IFleur unetroisiemeFleur =new Fleur(Taille.values()[2], Couleur.values()[2], Espece.values()[2], Nom.values()[20]);
		
	
		monJardin.ajouter_Fleur(uneFleur);
		monJardin.ajouter_Fleur(uneDeuxiemeFleur);
		monJardin.ajouter_Fleur(unetroisiemeFleur);
		System.out.println(monJardin.get_Jardin());
		monJardin.sauvegarder_Jardin();
		/*System.out.println("\nImpression du jardin :\n"+monJardin.imprimer_Jardin());
		System.out.println(uneDeuxiemeFleur.plus_Grand_Que(unetroisiemeFleur));
		
		
		
		
			
		
		//monJardin.supprimer_Fleur(uneFleur);
		
		System.out.println(monJardin.get_Jardin());
		
		 Coordonnees c=new Coordonnees(4, 1,false);
		 monJardin.deplacer_Fleur(uneFleur, c);
		 
		 Coordonnees c1=new Coordonnees(5, 2,false);
		 monJardin.deplacer_Fleur(uneDeuxiemeFleur, c1);
		 
		 Coordonnees c2=new Coordonnees(-5, 2,false);
		 monJardin.deplacer_Fleur(unetroisiemeFleur, c2);
		System.out.println(monJardin.get_Jardin());
		System.out.println(monJardin.est_Entre(unetroisiemeFleur, uneFleur,uneDeuxiemeFleur));
		System.out.println(monJardin.meme_Longitude(uneDeuxiemeFleur, uneFleur));

			System.out.println("Nbfleur: "+monJardin.get_NbFleur()+"\n");
	    Coordonnees c=new Coordonnees(4, 1,false);
	   
		monJardin.sauvegarder_Jardin();
		System.out.println(monJardin.est_Entre(uneDeuxiemeFleur, uneFleur,unetroisiemeFleur));

	//	monJardin.imprimer_Jardin();
	System.out.println("deplacement: "+monJardin.deplacer_Fleur(uneDeuxiemeFleur, c));
		monJardin.get_Jardin();
	//	System.out.println(monJardin.get_PlaceOccuper().get(0).toString());*/
	}

}
