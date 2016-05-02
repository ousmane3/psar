/**
 * 
 */
package jardin;

/**
 * @author Ousmane3
 *
 */
public class Coordonnees {
	
	private int x;
	private int y;
	private boolean estOccuper;
	
	public Coordonnees(int x,int y,boolean occupe){
		this.x=x;
		this.y=y;
		this.estOccuper=occupe;
				
	};
	public Coordonnees(int x,int y){
		this.x=x;
		this.y=y;
		this.estOccuper=true;
	}
	public boolean est_Libre(int x,int y){
		if ( (this.getX()==x) && (this.getY()==y)){
			return this.estOccuper;
		}
		return false;
			
	}

	public String  toString(){
		return this.getX()+","+this.getY();
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isEstOcuuper() {
		return estOccuper;
	}
	public void setEstOcuuper(boolean estOcuuper) {
		this.estOccuper = estOcuuper;
	}
	
	//redefinir la méthode equals 
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Coordonnees))
			return false;
		
		Coordonnees s = (Coordonnees)obj;
			return (s.getX() == this.getX())&& (s.getY()==this.getY());
		
	}

}
