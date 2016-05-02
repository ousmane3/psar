package cAnalyseur;


/**
 * @author Jean-Marc Katuitshi
 * classe etend la classe generateur d'analyseur et implante l'interface IAnalyseur
 * 
 * */

public class Analyseur extends  GenerateurAnalyseur implements IAnalyseur{

	public Analyseur(GenerateurAnalyseurTokenManager tm) {
		super(tm);
		// TODO Auto-generated constructor stub
		/*nothing to be done*/
	}

	
	public Object[] analyser(String pourAnalyse) throws ParseException {
		// TODO Auto-generated method stub
		Object[] retour =super.check(pourAnalyse);
		 if((Boolean)retour[0])
		 {
			 	
			 	retour[1]=valueTree(super.root);			 
		 }
		 return retour;
			 
		
	}
	/**
	 * @return la chaine repprésentant l'arbre
	 * @param nd prend un noeud et à l'initial il prend le noeud root
	 * fonction recursive qui balaye chaque noeud afin d'y inserer la valeur correspondante
	 * 
	 * */
	static String parenthese = "";
	static boolean first = true;
	private String valueTree(SimpleNode nd)
	{
		String value =nd.toString();
		String pereReel = nd.toString();
		String pereValue = "";
		String currentNodeValue ="";		
		int nbfils = nd.jjtGetNumChildren(); //nombre des fils
	
		String rightp = "";
		if(value.compareTo("alternative1")==0
			|value.compareTo("alternative2")==0
			||value.compareTo("UNARY")==0
			||value.compareTo("quantificateur")==0
			||value.compareTo("FORMULE")==0
		  )
		{
			
			if(nbfils==1)return valueTree((SimpleNode)nd.jjtGetChild(0));//rien a faire pour les unary...
			else value ="";
		}		
		SimpleNode pere =null;
		SimpleNode currentNode =null;
		String[] operateur ={"ad","or","ip","bp"};
		
		int i;
		
		if(nbfils==0)
		try{return "t"+nd.value.toString();}// Si On atteint le noeud variable()|constante()	
		catch(java.lang.NullPointerException e)
		{
			return nd.toString();
		}
		
		//cas nombre de fils=2 avec no au debut
		
		if(nbfils ==2)
		{
			
			pere = (SimpleNode)nd.jjtGetChild(0);
			pereValue = pere.toString();
			if(pereValue.compareTo("no")==0 && (!pereReel.contains("quantificateur")))
			{
				
				currentNode = (SimpleNode)nd.jjtGetChild(1);
				currentNodeValue = valueTree(currentNode);
				pereValue+="("+currentNodeValue+")";
				return pereValue;
			}
		}
		
		//cas du type Unary()operateur()Unary()	
		if(nbfils==3 && (pereReel.contains("FORMULE"))) 		
		{
			
			boolean yes = false;
			pere = (SimpleNode)nd.jjtGetChild(1);
			pereValue = pere.jjtGetChild(0).toString();				
			for(String s: operateur)
			{
				if(s.compareTo(pereValue)==0)
					{
						yes = true;// nous sommes bien dans ce cas
						break;
					}
			}
			if(yes)
			{
				
				value = pereValue+"("+valueTree((SimpleNode)nd.jjtGetChild(0))+")"
							+"("+valueTree((SimpleNode)nd.jjtGetChild(2))+")";
				return value;
			}			
		}
		//cas: quantificateur()* (predicat()|formule())
		pere =(SimpleNode)nd.jjtGetChild(0);
		pereValue = pere.toString(); 
		if(pereValue.contains("quantificateur")) 
		{	
						
			pereValue = valueTree(pere);
			
			value ="";
			for(i = 1; i < nbfils;i++){	
				
				currentNode = (SimpleNode)nd.jjtGetChild(i);								
				value += valueTree(currentNode);			
							
			}			
			pereValue +="("+value+")"+parenthese;
			parenthese ="";			
			return pereValue;
		}
		
		//cas quantificateur()
		
		if(pereReel.compareTo("quantificateur")==0)
		{
			
			pere = (SimpleNode)nd.jjtGetChild(0);
			pereValue = valueTree(pere);
			
			for(i = 1; i < nbfils; i++)
			{
				currentNode = (SimpleNode)nd.jjtGetChild(i);				
				value +="("+ valueTree(currentNode);			
				parenthese +=")";				
			}
			
			pereValue += value;
			return pereValue;
		}
		//cas alternative2
		if (nbfils > 3)
		{		
			pere =(SimpleNode)nd.jjtGetChild(1);//le pere est forcément l'element 1
			pereValue = valueTree(pere);			
			//on veut imbriquer les operateurs
			for(i =0; i < nbfils; i+=2)
			{
				
				if((i!=0) && (i!= nbfils-1)){value+="(";rightp+=")";}//ne pas mettre d ouvrant et de fermant
				if(i!= nbfils-1)//au dernier tour ne pas ajouter l operateur!!
					value += pereValue+"(";
				else value +="(";
				currentNode = (SimpleNode)nd.jjtGetChild(i);				
				value += valueTree(currentNode)+")";
			}
			value +=rightp;			
			return value;
		}			
			for(i=0;i<nbfils;i++)
				value += "("+valueTree((SimpleNode)nd.jjtGetChild(i))+")";

		return value;
		
		
	}

}
