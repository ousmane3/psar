/**
 * 
 */
package jardin;

/**
 * @author Ousmane3
 *
 */
public class Fleur {
	
	private Taille taille;
	private Couleur couleur;
	private Espece espece;
	private Nom nomfleur;
	
	public  Fleur(Espece e,Taille t,Couleur c,Nom n) {
		// TODO Auto-generated constructor stub
		this.setTaille(t);
		this.setCouleur(c);
		this.setEspece(e);
		this.setNomfleur(n);
	}
	
	/*
	 * methode pour afficher les caracteristiques d'une fleur en chaine de caractère
	 */
	public String fleur_toString() {
		// TODO Auto-generated method stub
		String result="";
		String resultat="";
		String dernier="";
		
		result+=""+this.getEspece();		
		resultat+= result.concat(dernier);
		
		result="";dernier="";
		result+=this.getTaille().toString();
		result=result.replaceFirst("", ",");
		resultat+=result.concat(dernier);
		
		result="";dernier="";
		result+=this.getCouleur().toString();
		result=result.replaceFirst("", ",");
		resultat+=result.concat(dernier);

		result="";dernier="";
		
		if(this.getNomfleur()==Nom.values()[20]){
			
			resultat+=",".concat(this.getNomfleur().toString());
		}else {
		result=result.replaceFirst("", ",");
		result+=this.getNomfleur().toString();
		resultat+=result.concat(dernier);
		}
		
		return resultat;
	}
	
	/*
	 * permet de comparer deux fleurs
	 * renvoi true si elles sont égale,false sinon
	 */
	public boolean egal(Fleur fleur) {
		// TODO Auto-generated method stub
		return (this.getTaille()==fleur.getTaille())
				&& (this.getNomfleur()==fleur.getNomfleur())
				&& (this.getCouleur()==fleur.getCouleur())
				&& (this.getEspece()==fleur.getEspece());
	}
	public Espece getEspece() {
		return espece;
	}

	public void setEspece(Espece espece) {
		this.espece = espece;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}

	public Nom getNomfleur() {
		return nomfleur;
	}

	public void setNomfleur(Nom nomfleur) {
		this.nomfleur = nomfleur;
	}

	

}
