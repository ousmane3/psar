/**
 * 
 */
package jardin;

/**
 * @author Ousmane3
 *
 */
public class Fleur implements IFleur {
	
	private Taille taille;
	private Couleur couleur;
	private Espece espece;
	private Nom nomfleur;
	
	public  Fleur(Taille t,Couleur c,Espece e,Nom n) {
		// TODO Auto-generated constructor stub
		this.setTaille(t);
		this.setCouleur(c);
		this.setEspece(e);
		this.setNomfleur(n);
	}
	
	/* (non-Javadoc)
	 * @see jardin.IFleur#rose()
	 */
	@Override
	public boolean rose() {
		// TODO Auto-generated method stub
		
		return (this.getEspece()==Espece.values()[0]);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#paquerette()
	 */
	@Override
	public boolean paquerette() {
		// TODO Auto-generated method stub
		return (this.getEspece()==Espece.values()[1]);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#tulipe()
	 */
	@Override
	public boolean tulipe() {
		// TODO Auto-generated method stub
		return (this.getEspece()==Espece.values()[2]);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#est_Grand()
	 */
	@Override
	public boolean est_Grand() {
		// TODO Auto-generated method stub
		return (this.getTaille()==Taille.grand);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#est_Moyen()
	 */
	@Override
	public boolean est_Moyen() {
		// TODO Auto-generated method stub
		return (this.getTaille()==Taille.moyen);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#est_Petit()
	 */
	@Override
	public boolean est_Petit() {
		// TODO Auto-generated method stub
		return (this.getTaille()==Taille.petit);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#est_Rouge()
	 */
	@Override
	public boolean est_Rouge() {
		// TODO Auto-generated method stub
		return (this.getCouleur()==Couleur.values()[1]);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#est_Rose()
	 */
	@Override
	public boolean est_rose() {
		// TODO Auto-generated method stub
		return (this.getCouleur()==Couleur.values()[0]);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#est_Blanche()
	 */
	@Override
	public boolean est_blanc() {
		// TODO Auto-generated method stub
		return  (this.getCouleur()==Couleur.values()[2]);
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#plus_Petit_Que(jardin.IFleur)
	 */
	@Override
	public boolean plus_petit_que(IFleur fleur) {
		// TODO Auto-generated method stub
		Taille t =this.getTaille();
		Taille t1=fleur.get_Taille();
		switch (t) {
		case grand:
			return false;
		case moyen:
			if(t1==Taille.grand) return true;
			else return false;
		case petit:
			if(t1==Taille.petit) return false;
			else return true;
		default:
			break;
		}
		return false;
		
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#plus_Grand_Que(jardin.IFleur)
	 */
	@Override
	public boolean plus_grand_que(IFleur fleur) {
		// TODO Auto-generated method stub
		Taille t =this.getTaille();
		Taille t1=fleur.get_Taille();
		switch (t) {
		case grand:
			if(t1==Taille.grand) return false;
			else return true;
		case moyen:
			if(t1==Taille.grand|| t1==Taille.moyen) return false;
			else return true;
		case petit:
			return false;
		default:
			break;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#meme_Taille_Que(jardin.IFleur)
	 */
	@Override
	public boolean meme_taille_que(IFleur fleur) {
		// TODO Auto-generated method stub
		return (this.getTaille()==fleur.get_Taille());
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#meme_Couleur_Que(jardin.IFleur)
	 */
	@Override
	public boolean meme_couleur_que(IFleur fleur) {
		// TODO Auto-generated method stub
		return (this.getCouleur()==fleur.get_Couleur());
	}

	/* (non-Javadoc)
	 * @see jardin.IFleur#egale(jardin.IFleur)
	 */
	@Override
	public boolean egal(IFleur fleur) {
		// TODO Auto-generated method stub
		return (this.get_Taille()==fleur.get_Taille())
				&& (this.getNomfleur()==fleur.get_Nom())
				&& (this.getCouleur()==fleur.get_Couleur())
				&& (this.getEspece()==fleur.get_Espece());
	}


	/* (non-Javadoc)
	 * @see jardin.IFleur#fleur_toString()
	 */
	@Override
	public String fleur_toString() {
		// TODO Auto-generated method stub
		String result="";
		String resultat="";
		String dernier="";
		
		result+=""+this.getEspece();
	//	result=result.replaceFirst("", "\'");
	//	dernier=dernier.replaceFirst("", "\'");
		
		resultat+= result.concat(dernier);
		
		result="";dernier="";
		result+=this.getTaille().toString();
		result=result.replaceFirst("", ",");
		//dernier=dernier.replaceFirst("", "\'");
		resultat+=result.concat(dernier);
		
		result="";dernier="";
		result+=this.getCouleur().toString();
		result=result.replaceFirst("", ",");
		//dernier=dernier.replaceFirst("", "\'");
		resultat+=result.concat(dernier);

		result="";dernier="";
		
		if(this.getNomfleur()==Nom.values()[20]){
			
			resultat+=",".concat(this.getNomfleur().toString());
		}else {
		result=result.replaceFirst("", ",");
		result+=this.getNomfleur().toString();
	//	dernier=dernier.replaceFirst("", "");
		resultat+=result.concat(dernier);
		}
		
		return resultat;
		
		/*return  
				this.getEspece().toString()+
				","+this.getTaille().toString()+
				","+this.getCouleur().toString()+
				","+this.getNomfleur().toString();*/
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

	@Override
	public Taille get_Taille() {
		// TODO Auto-generated method stub
		return taille;
	}

	@Override
	public Couleur get_Couleur() {
		// TODO Auto-generated method stub
		return couleur;
	}

	@Override
	public Nom get_Nom() {
		// TODO Auto-generated method stub
		return nomfleur;
	}

	@Override
	public Espece get_Espece() {
		// TODO Auto-generated method stub
		return espece;
	}


}
