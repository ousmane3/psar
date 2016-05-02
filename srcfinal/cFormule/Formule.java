package cFormule;

import cAnalyseur.Analyseur;
import cAnalyseur.GenerateurAnalyseurTokenManager;
import cAnalyseur.IAnalyseur;
import cAnalyseur.ParseException;

public class Formule implements IFormule {
	private String formule;//formule en chaine
	private boolean syntOk; //resultat de l'analyse syntaxique
	private boolean correct; //est vrai par rappor au jardin

	private String arbre;
	
	/**
	 * Analyse une chaine
	 * @param chaine : la formuleule à analyser
	 * @return boolean:true si la formuleule est bien formuleée et false sinon
	 * @Override
	 * */
	
	public void analyser() {
		// TODO Auto-generated method stub
		 IAnalyseur analyseur = new Analyseur(new GenerateurAnalyseurTokenManager(null));//analyseur syntaxique
		try{
			Object[]resultat = analyseur.analyser(this.formule);
			this.syntOk=(Boolean) resultat[0]; 
			this.arbre  = (String)resultat[1];
			
		}
		catch (ParseException e){
			syntOk =correct= false;
		}
		
	}
	/**
	 * renvoie la formuleule si elle est syntaxiquement correcte
	 * @return String : retourne la chaine correspondant à la formuleule
	 * 	@Override 
	 *
	 **/
	
	public String getFormule() {
		// TODO Auto-generated method stub
		return this.formule;
	}
	
	/*constructeur */
	public Formule()
	{
		syntOk =correct= false;
		this.formule =this.arbre ="";
	}
	public Formule(String formule){
		syntOk=correct= false;
		this.formule =formule;
		this.arbre = "";
	}
	
	public boolean isCorrect() {
		return correct;
	}

	public void setFormule(String formule) {
		// TODO Auto-generated method stub
		this.formule = formule;
	}
	public boolean isSyntOk() {
		return syntOk;
	}
	public String arbreToString() {
		// TODO Auto-generated method stub
		return arbre;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}


}
