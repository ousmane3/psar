package cAnalyseur;




public class Analyseur extends  GenerateurAnalyseur implements IAnalyseur{

	public Analyseur(GenerateurAnalyseurTokenManager tm) {
		super(tm);
		// TODO Auto-generated constructor stub
		/*nothing to be done*/
	}

	@Override
	public Object[] analyser(String pourAnalyse) throws ParseException {
		// TODO Auto-generated method stub
		Object[] retour =super.check(pourAnalyse);
		 if((Boolean)retour[0])
		 {
			  
			 	retour[1]=valueTree(super.root);
			 // retour[1]=super.root.toString();
			  
			 
		 }
		 return retour;
			 
		
	}
	private String valueTree(SimpleNode nd)
	{
		
		String value =nd.toString();
		String pereValue = "";
		
		if(value.compareTo("alternative1")==0
			||value.compareTo("alternative1")==0
			||value.compareTo("UNARY")==0
		  )
			return valueTree((SimpleNode)nd.jjtGetChild(0));//rien a faire pour les unary...
		
	
		int nbfils = nd.jjtGetNumChildren(); //nombre des fils
		SimpleNode pere =null;
		SimpleNode currentNode =null;
		
		int i;
		if(nbfils==0)
		try{return nd.value.toString();}// Si On atteint le noeud variable()|constante()	
		catch(java.lang.NullPointerException e){}
			
	//	if(nbfils >= 3)// l operateur est tjrs au milieu
		//{
			//value += valueTree((SimpleNode)nd.jjtGetChild(1)) ;
			//for(i = 0; i < nbfils; i+=2 )
			//{
			//	value +="("+valueTree((SimpleNode)nd.jjtGetChild(i))+")" ;
			//	value +=((i+1) < nbfils)?"("+valueTree((SimpleNode)nd.jjtGetChild(i))+")":"";
			//}
		//}
		//else // l operateur commencera tjrs en premier
		//{
			for(i = 0; i < nbfils; i++ )
			{
				pere =((SimpleNode)nd.jjtGetChild(i));
				pereValue = (pere.toString().compareTo("UNARY")==0)?"":pereValue;// celui  qui n'est pas Unary est le pere des autres
				if(!pereValue.isEmpty())break;
			}
			value +=pereValue;
			for(i = 0; i < nbfils; i++ )
			{
				currentNode = (SimpleNode)nd.jjtGetChild(i);
				if(currentNode.toString().compareTo(pereValue)!=0)
					value +="("+valueTree(currentNode)+")";  
			}
			pereValue =(pereValue.isEmpty())?value:pereValue+"("+value+")";
			

		return pereValue;
	}

}
