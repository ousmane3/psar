package cFormule;

public interface IFormule {
	
	/*give the string compatible expression of a formula for the module*/
	public String get_formule();	
	/*analyze a string to check if it's correct syntactically : this method return true or false*/
	public boolean analyser(String pourAnalyser);	

}
