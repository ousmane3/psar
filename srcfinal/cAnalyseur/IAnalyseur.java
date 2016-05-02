package cAnalyseur;





public interface IAnalyseur {
	
	/**
	 * analyse syntaxiquement une chaine de caractere fournit en param
	 * @param pourAnalyse
	 * 			chaine à analyser
	 * @throws ParseException
	 * @return Object: -Bolean true ou false
	 * 				   -la chaine representant l'arbre construit
	 * */
	public Object[] analyser(String pourAnalyse) throws ParseException;
}
