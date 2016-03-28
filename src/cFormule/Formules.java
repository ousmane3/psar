package cFormule;

import java.util.ArrayList;

public class Formules implements IFormules{
	ArrayList <String> formules;
	
	public Formules(){
		formules = new ArrayList<String>();
	}
	@Override
	public boolean add_formules(String formule) {
		// TODO Auto-generated method stub
		formules.add(formule);
		return false;
	}

	@Override
	public String get_formules() {
		// TODO Auto-generated method stub
		/*construction d'un tableau python de formules en string */
		return null;
	}

}
