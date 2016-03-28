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
public class Jardin implements IJardin {

	private HashMap<Coordonnees, IFleur> jardin;
		
	/* (non-Javadoc)
	 * @see jardin.IJardin#initialiser_Jardin()
	 * initialisation du jardin 
	 * lire le contenu du fichier placeDuJardin et
	 * les ajouter dans coordonnes
	 */
	public Jardin() {
		// TODO Auto-generated method stub
		jardin=new HashMap<Coordonnees,IFleur>();
		FileReader fr;
		BufferedReader br;
		String s,tab[];
		int x;
		int y;
		try {
			fr = new FileReader("placeDuJardin");
			br=new BufferedReader(fr);
			while((s=br.readLine())!=null){
				
				tab=s.split(",");
				x=new Integer(tab[0]);
				y=new Integer(tab[1]);	
				Coordonnees c=new Coordonnees(x, y,false);
				jardin.put(c, null);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur d'ouverture du fichier"+e.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see jardin.IJardin#ajouter_Fleur(jardin.IFleur)
	 */
	@Override
	public boolean ajouter_Fleur(IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			
			if(this.getEnv().get(c)==null){
				this.jardin.put(c, fleur);
				c.setEstOcuuper(true);
				return true;
			}
			
		}
		return false;

		}
		

	/* (non-Javadoc)
	 * @see jardin.IJardin#supprimer_Fleur(jardin.IFleur)
	 * on parcours pour chercher la fleur
	 */
	@Override
	public boolean supprimer_Fleur(IFleur fleur) {
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

	/* (non-Javadoc)
	 * @see jardin.IJardin#deplacer_Fleur(jardin.IFleur, jardin.Coordonnees)
	 */
	@Override
	public boolean deplacer_Fleur(IFleur fleur, Coordonnees coordonnees) {
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

	/* (non-Javadoc)
	 * @see jardin.IJardin#get_Jardin()
	 */
	@Override
	public String get_Jardin() {
		// TODO Auto-generated method stub
		
		Iterator<Coordonnees> keySetIt=this.getEnv().keySet().iterator();
		String resultat="";
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			
			if(c.isEstOcuuper()){
				resultat+=c.toString()+","+this.getEnv().get(c).fleur_toString()+":";
			}
			/*if(c.isEstOcuuper()){
				resultat+=c.toString()+","+this.getEnv().get(c).fleur_toString();
			}else{
				resultat+=c.toString();
			}
			resultat+=":";*/
			
		}
		resultat=resultat.substring(0,resultat.length()-1);
		return resultat;
	}

	/* (non-Javadoc)
	 * @see jardin.IJardin#sauvegarder_Jardin()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see jardin.IJardin#imprimer_Jardin()
	 */
	@SuppressWarnings("resource")
	@Override
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

	/* (non-Javadoc)
	 * @see jardin.IJardin#get_NbFleur()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see jardin.IJardin#get_PlaceVide()
	 * on cherche les places o� il n'ya pas de fleur
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see jardin.IJardin#get_PlaceOccuper()
	 */
	@Override
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

	
	@Override
	public IFleur get_Fleur(int x,int y) {
		
			Coordonnees c=new Coordonnees(x, y);
			return this.getEnv().get(c);
		
	}

	public HashMap<Coordonnees, IFleur> getEnv() {
		return jardin;
	}

	public void setEnv(HashMap<Coordonnees, IFleur> env) {
		this.jardin = env;
	}

	@Override
	public boolean est_entre(IFleur fleurGauche,  IFleur fleurCentre, IFleur fleurDroite) {
		// TODO Auto-generated method stub
		
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		int xCentre=-10;
		int xGauche=-10;
		int xDroite=-10;
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			IFleur f=this.getEnv().get(c);
		
			if(f!=null){
				if(f.egal(fleurCentre)){
					xCentre=c.getX();
				}else
				if(f.egal(fleurGauche)){
					xGauche=c.getX();
				}else if(f.egal(fleurDroite)){
					xDroite=c.getX();
				}
			}
			if( ((xCentre>xGauche) && (xCentre< xDroite))|| ( (xCentre<xGauche)&&(xCentre>xDroite)))
				return true;
			
		}
		return false;
	}

	@Override
	public boolean a_lest(IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();

		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			IFleur f=this.getEnv().get(c);
			if(f!=null && f.egal(fleur)){
				return c.getX()>0;
			}
		}
		return false;
	}

	@Override
	public boolean a_louest(IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();

		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			IFleur f=this.getEnv().get(c);
			if(f!=null && f.egal(fleur)){
				return c.getX()<0;
			}
		}
		return false;
	}

	@Override
	public boolean au_sud(IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();

		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			IFleur f=this.getEnv().get(c);
			if(f!=null && f.egal(fleur)){
				return c.getY()<0;
			}
		}
		return false;
	}

	@Override
	public boolean au_nord(IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();

		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			IFleur f=this.getEnv().get(c);
			if(f!=null && f.egal(fleur)){
				return c.getY()>0;
			}
		}
		return false;
	}

	@Override
	public boolean a_l_est_de(IFleur fleurEst,IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
int xEst=-10;
int xOuest=-10;
		while(keySetIt.hasNext()){
			
			Coordonnees c=keySetIt.next();
			IFleur f=this.getEnv().get(c);
			
			if(f!=null && f.egal(fleur)){
				xOuest=c.getX();
			}else if (f!=null && f.egal(fleurEst)){
				xEst=c.getX();
			}
			if(xEst!=-10 && xOuest!=-10){
				return xEst>xOuest;
			}
		}
		return false;
	}

	@Override
	public boolean a_l_ouest_de(IFleur fleurOuset,IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		int xEst=-10;
		int xOuest=-10;
				while(keySetIt.hasNext()){
					
					Coordonnees c=keySetIt.next();
					IFleur f=this.getEnv().get(c);
					
					if(f!=null && f.egal(fleurOuset)){
						xOuest=c.getX();
					}else if (f!=null && f.egal(fleur)){
						xEst=c.getX();
					}
					if(xEst!=-10 && xOuest!=-10){
						return xOuest<xEst;
					}
				}
				return false;
	}

	@Override
	public boolean au_sud_de(IFleur fleurSud,IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		int ySud=-10;
		int yNord=-10;
				while(keySetIt.hasNext()){
					
					Coordonnees c=keySetIt.next();
					IFleur f=this.getEnv().get(c);
					
					if(f!=null && f.egal(fleurSud)){
						ySud=c.getY();
					}else if (f!=null && f.egal(fleur)){
						yNord=c.getY();
					}
					if(yNord!=-10 && ySud!=-10){
						return ySud<yNord;
					}
				}
				return false;
	}

	@Override
	public boolean au_nord_de(IFleur fleurNord,IFleur fleur) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		int ySud=-10;
		int yNord=-10;
				while(keySetIt.hasNext()){
					
					Coordonnees c=keySetIt.next();
					IFleur f=this.getEnv().get(c);
					
					if(f!=null && f.egal(fleurNord)){
						yNord=c.getY();
					}else if (f!=null && f.egal(fleur)){
						ySud=c.getY();
					}
					if(yNord!=-10 && ySud!=-10){
						return yNord>ySud;
					}
				}
				return false;
	}

	@Override
	public boolean meme_latitude(IFleur fleur1,IFleur fleur2) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		int xf1=-10;
		int xf2=-10;
	
				while(keySetIt.hasNext()){
					
					Coordonnees c=keySetIt.next();
					IFleur f=this.getEnv().get(c);
					
					if(f!=null && f.egal(fleur1)){
						xf1=c.getX();
					}else if (f!=null && f.egal(fleur2)){
						xf2=c.getX();
					}
					if(xf1!=-10 && xf2!=-10){
						return xf1==xf2;
					}
				}
				return false;
	}

	@Override
	public boolean meme_longitude(IFleur fleur1,IFleur fleur2) {
		// TODO Auto-generated method stub
		Iterator<Coordonnees> keySetIt=this.jardin.keySet().iterator();
		int xf1=-10;
		int yf1=-10;
		int xf2=-10;
		int yf2=-10;
				while(keySetIt.hasNext()){
					
					Coordonnees c=keySetIt.next();
					IFleur f=this.getEnv().get(c);
					
					if(f!=null && f.egal(fleur1)){
						yf1=c.getY();
						xf1=c.getX();
					}else if (f!=null && f.egal(fleur2)){
						yf2=c.getY();
						xf2=c.getX();
					}
					if(xf1!=-10 && xf2!=-10){
						return yf1==yf2;
					}
				}
				return false;
	}

	
}
