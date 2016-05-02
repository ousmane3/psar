package cFormule;

/**
 * 
 * @version Contrat d'appel des fonctions de la classe formule
 * */

public interface IFormule {

	/**
	 * Analyse syntaxiquement la formule	 
	 * @return boolean:true si la formule est bien formée et false sinon
	 * et la chaine représentant la formule à envoyer ou null si false
	 */
	public void analyser();	
	
	/**
	 * renvoie la formule en chaine de caractère
	 * @return String : retourne la chaine correspondant à la formule
	 */

	public String getFormule();
	/**
	 * modifier la formule
	 * @return void
	 * @param: la chaine à remplacer
	 */

	public void setFormule(String formule);
	/**
	 * renvoie vraie si la formule est correcte dans le jardin
	 * */
	public boolean isCorrect();
	
	/**
	 * renvoie vrai si la formule est syntaxiquement correcte
	 * */
	
	public boolean isSyntOk();
	/**
	 * description: renvoie l arbre en chaine de caractère si l analyse syntaxique est correcte
	 * @return l arbre en chaine de caractère
	 * */
	
	public String arbreToString();
	
	/**
	 * resultat obtenu après analyse 
	 * */
	public void setCorrect(boolean correct);
}	


	
