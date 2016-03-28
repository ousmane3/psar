/**
 * 
 */
package jardin;


import java.util.ArrayList;

/**
 * @author Ousmane3
 *
 */
public interface IJardin {
	
	public boolean ajouter_Fleur(IFleur fleur);
	public boolean supprimer_Fleur(IFleur fleur);
	public boolean deplacer_Fleur(IFleur fleur,Coordonnees coordonnees);
	public String get_Jardin();
	public void sauvegarder_Jardin();
	public String charger_Jardin();
	public int get_NbFleur();
	public ArrayList<Coordonnees> get_PlaceVide();
	public ArrayList<Coordonnees> get_PlaceOccuper();
	public IFleur get_Fleur(int x,int y);
	public boolean est_entre(IFleur fleurGauche,IFleur fleurCentre,IFleur fleurDroite);
	public boolean a_lest(IFleur fleur);
	public boolean a_louest(IFleur fleur);
	public boolean au_sud(IFleur fleur);
	public boolean au_nord(IFleur fleur);
	public boolean a_l_est_de(IFleur fleurEst,IFleur fleur);
	public boolean a_l_ouest_de(IFleur fleurOuest,IFleur fleur);
	public boolean au_sud_de(IFleur fleurSud,IFleur fleur);
	public boolean au_nord_de(IFleur fleurNord,IFleur fleur);
	public boolean meme_latitude(IFleur fleur1,IFleur fleur2);
	public boolean meme_longitude(IFleur fleur1,IFleur fleur2);

}
