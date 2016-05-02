/**
 * 
 */
package jardin;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Ousmane3
 *
 */
public class Jardin {

	
	private HashMap<Coordonnees, Fleur> jardin;
		
	
	
	
	/*
	 * creation du jardin
	 * *********************************
	 */
	public Jardin() {
		// TODO Auto-generated method stub
		jardin=new HashMap<Coordonnees,Fleur>();
	}

	/*
	 * ajout d'une fleur dans le jardin
	 * cette fleur sera placé à la prochaine place libre du jardin 
	 */
	public void ajouter_Fleur(int x,int y,Fleur fleur) {
		// TODO Auto-generated method stub
		Coordonnees c=new Coordonnees(x, y);
		this.jardin.put(c, fleur);
	}
		

	/*
	 * suppression d'une fleur dans le jardin 
	 * *********************************************
	 */
	public boolean supprimer_Fleur(Fleur fleur) {
		// TODO Auto-generated method stub
		
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			
			if(this.getEnv().get(c).egal(fleur)){
				this.jardin.put(c, null);
				c.setEstOcuuper(false);
				return true;
			}
			
		}
		return false;
	}

	/*
	 * deplace une fleur d'un point vers un autre
	 * ***********************************************
	 */
	public boolean deplacer_Fleur(Fleur fleur, Coordonnees coordonnees) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			
			if(this.getEnv().get(c)!=null && this.getEnv().get(c).egal(fleur)){
				this.jardin.put(c, null);
				c.setEstOcuuper(false);
				
				this.jardin.put(coordonnees, fleur);
				coordonnees.setEstOcuuper(true);
				return true;
			}
			
		}
		return false;
	}

	/*
	 * recupere le jardin encours en chaine de caractère
	 */
	public String get_Jardin() {
		// TODO Auto-generated method stub
		
		Iterator<Coordonnees> keySetIt=this.getEnv().keySet().iterator();
		String resultat="";
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			
			if(c.isEstOcuuper()){
				resultat+=c.toString()+","+this.getEnv().get(c).fleur_toString()+":";
			}
			
		}
		if(!resultat.isEmpty())resultat=resultat.substring(0,resultat.length()-1);
		return resultat;
	}

	/*
	 * enregistre un jarin dans le repertoire
	 * **************************************
	 */
	public void sauvegarder_Jardin() {
		// TODO Auto-generated method stub
		try {
	
			FileWriter fw=new FileWriter("jardin");
			
			fw.write(this.get_Jardin());
			fw.flush();
			fw.close();
			System.out.println("sauvegarde du jardin reussi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("sauvegarde du jardin a �chou�e");
		}
		
	}

	/*
	 * cherche dans le repertoire un jardin et l'affiche 
	 * ************************************************
	 */
	@SuppressWarnings("resource")
	public String charger_Jardin() {
		// TODO Auto-generated method stub
		FileReader fr;
		BufferedReader br;
		String s,resultat="";
		
		try {
			fr = new FileReader("jardin");
			br=new BufferedReader(fr);
		while((s=br.readLine())!=null){
			resultat+=s+"\n";	
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("imprimerJardin: "+e.getMessage());
		}
		
			
		return resultat;
	}

	/*
	 * renvoi le nombre de fleur dans le jardin
	 */
	public int get_NbFleur() {
		// TODO Auto-generated method stub
		
		Iterator<Coordonnees> keySetIt=this.getEnv().keySet().iterator();
		int resultat=0;
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			if(this.getEnv().get(c)!=null)
				resultat+=1;
			
		}
		return resultat;
	
	
	}
	
	/*
	 * renvoi la liste des places vides du jardin
	 */
	public ArrayList<Coordonnees> get_PlaceVide() {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.getEnv().keySet().iterator();
		
		ArrayList<Coordonnees> resultat=new ArrayList<Coordonnees>();
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			if(this.getEnv().get(c)==null)
				resultat.add(c);
			
		}
		return resultat;
	}

	/*
	 * renvoi la liste des places occuper du jardin
	 */
	public ArrayList<Coordonnees> get_PlaceOccuper() {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.getEnv().keySet().iterator();
		
		ArrayList<Coordonnees> resultat=new ArrayList<Coordonnees>();
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			if(this.getEnv().get(c)!=null)
				resultat.add(c);
			
		}
		return resultat;
	}
	/*
	 * supprimer tous le jardin
	 */
    public void suppAll(){
    	this.jardin.clear();
    }
	
	
	public HashMap<Coordonnees, Fleur> getEnv() {
		return jardin;
	}

	public void setEnv(HashMap<Coordonnees, Fleur> env) {
		this.jardin = env;
	}
	
	public Fleur getFleur(Coordonnees c)
	{
		if(this.jardin.containsKey(c))
			return this.jardin.get(c);
		return null;
	}
	public Coordonnees getCoordonnes(int x, int y)
	{
		Iterator<Coordonnees> keySetIt=this.getEnv().keySet().iterator();
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			if((c.getX() == x) &&(c.getY() == y) )
				return c;			
		}
		
		return null;
	}

}
