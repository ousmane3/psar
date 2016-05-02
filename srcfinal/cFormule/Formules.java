package cFormule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Formules implements IFormules {
	
	private ArrayList<IFormule> formules;
	private OutputStreamWriter wr;
	
	public ArrayList<IFormule> getFormules() {
		return formules;
	}


	public Formules()
	{
		formules = new ArrayList<IFormule> ();
	}

	public IFormule get_formule(int i) {
		// TODO Auto-generated method stub
		assert i < this.formules.size();
		return this.formules.get(i);
	}

	public void add_formule(IFormule formule) {
		// TODO Auto-generated method stub
		this.formules.add(formule);
	}

	public int nb_formule() {
		// TODO Auto-generated method stub
		return formules.size();
	}

	public boolean enregistrer_formules(String path) throws IOException {
		// TODO Auto-generated method stub
		try {
				wr = new OutputStreamWriter(new FileOutputStream(path));
				for(IFormule f : this.formules)
				{
					try {
						wr.write(f.getFormule()+"\n");
						wr.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						return false;
					}
				}
	
				wr.close();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	public boolean charger_formules(String path) {
		// TODO Auto-generated method stub
		Scanner sc;
		try {
			sc = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}
		while (sc.hasNextLine())
		{
		    String s = sc.nextLine();
		   IFormule f  = new Formule(s);
		   this.add_formule(f);
		}
		sc.close();
		return true;
	}


	public String pour_evaluation() {
		// TODO Auto-generated method stub
		String chaine ="";
		for(IFormule f : formules)
		{			
			if(f.isSyntOk())
				chaine +=":"+f.arbreToString();
		}
		return chaine;
	}

}
