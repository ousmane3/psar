package cFormule;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface de gestion des formules
 * 
 * */
public interface IFormules {
	/**
	 * description : renvoie la formule à la position i et une chaine vide si 
	 * la formule n existe pas.
	 * 
	 *  @param i : position de la formule
	 *  @return IFormule: la formule ou null sinon
	 * 
	 * */
	public IFormule get_formule(int i);
	
	public void add_formule(IFormule formule);
	
	/**
	 * description: renvoie le nombre des formules
	 * @return int : le nombre des formules
	 * 
	 * */
	public int nb_formule();
	/**
	 * description: enregistre un ensemble des formules
	 * @return vrai si tout s'est correctement passé, false sinon
	 * @param path : chemin d'enregistrement comportant le nom du fichier
	 * */
		public boolean enregistrer_formules(String path)throws IOException ;
		
	/**
	 * description: charge un ensemble des formules dans l'application
	 * @return vrai si l'on peut charger du fichier, faux sinon
	 * @param path :chemin de chargement comprennant le nom du fichier
	 * */
		public boolean charger_formules(String path);
		
		
	/**
	 * Obtenir toutes les formules
	 * @return liste des formules
	 * */
		
		public ArrayList<IFormule> getFormules();
		
	/**
	 * donne la chanie à fournir à l'analyseur(lance localement l'analyse syntaxique)
	 * @return liste des formules
	 * */		
		
		public String pour_evaluation();

}
