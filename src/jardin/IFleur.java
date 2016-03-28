/**
 * 
 */
package jardin;

/**
 * @author Ousmane3
 * 
 * Vendredi 18 Mars 2016
 * 
 * V1.0
 *
 *interface fleur qui contient toute les methodes d'une fleur
 */
public interface IFleur {
	public boolean rose();
	public boolean paquerette();
	public boolean tulipe();
	public boolean est_Grand();
	public boolean est_Moyen();
	public boolean est_Petit();
	public boolean est_Rouge();
	public boolean est_rose();
	public boolean est_blanc();
	public boolean plus_petit_que( IFleur fleur);
	public boolean plus_grand_que(IFleur fleur);
	public boolean meme_taille_que(IFleur fleur);
	public boolean meme_couleur_que(IFleur fleur);
	public boolean egal(IFleur fleur);
	public String fleur_toString();	
	public Taille get_Taille();
	public Couleur get_Couleur();
	public Nom get_Nom();
	public Espece get_Espece();
}
