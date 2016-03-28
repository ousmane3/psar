package cFormule;


import cAnalyseur.Analyseur;
import cAnalyseur.GenerateurAnalyseurTokenManager;
import cAnalyseur.IAnalyseur;
import cAnalyseur.ParseException;

public class Formule implements IFormule{

	private boolean retourAnalyse;
	private String postAnalyse;
	static IAnalyseur  analyseur= new Analyseur(new GenerateurAnalyseurTokenManager(null));


	@Override
	public boolean analyser(String pourAnalyse) {
		// TODO Auto-generated method stub	
		Object[] result;
		
		try {
			/*appel à l analyseur syntaxique*/
			result = analyseur.analyser(pourAnalyse);
			retourAnalyse = (boolean)result[0];
			postAnalyse = (String)result[1];		
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return retourAnalyse;
		
	}
	
	public Formule(){
		this.retourAnalyse = false;
		this.postAnalyse="";
	}

	@Override
	public String get_formule() {
		// TODO Auto-generated method stub
		return postAnalyse;
	}

}
