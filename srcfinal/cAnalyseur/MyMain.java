package cAnalyseur;

import java.io.FileInputStream;
import java.io.IOException;

public class MyMain {

	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		GenerateurAnalyseurTokenManager tm = new GenerateurAnalyseurTokenManager(null);
		IAnalyseur a= new Analyseur(tm);
		//InputStreamLiner ln= new InputStreamLiner(new FileInputStream("BDtestTrue.txt"));
		String exempleTest = "";
		Object[] ob;
//		while((exempleTest=ln.readLineUnix())!=null)

//		{
			ob = a.analyser("Rose(x)⇒Rose(b)");	
			System.out.println(" resultat: "+ ob[0]+"\t"+ob[1]);
//		}
	}

}
