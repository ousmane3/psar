from psar_python import *

var_termes =["tv","tw","tx","ty","tz"]
cons_termes = ["ta","tb","tc","td","te","tf","tg","th","ti","tj","tk","tl","tm","tn","to","tp","tq","tr","ts","tt"] 
operateur_bin = ["or","ad","ip","bp"]
op_fleur_bin = ["ed","od","nd","sd","ma","mo","pp","pg","mt","eq"]
op_fleur_un = ["no","rs","bl","rg","pa","tu","ro","ae","ao","an","as","ep","eg","em"]

def create_formule(chaine):
	operateur = chaine[0:2]	
	subchaine =""
	terme =""
	subchaineL = ""
	subchaineR = ""
	parenthese = 0	
	if(operateur in var_termes):
		return Var_term(operateur[1])
	if(operateur in cons_termes):
		return Cons_term(operateur[1],[])
	if (operateur == "fl") :		
		terme = chaine[4]		
		subchaine = chaine[7:len(chaine)-1]
		return F1_Forall(terme,create_formule(subchaine))		
	if (operateur == "ex") :
		terme = chaine[4]
		subchaine = chaine[7:len(chaine)-1]
		return F1_Exists(terme,create_formule(subchaine))
	if (operateur in operateur_bin) :		
		i = 2
		while (i < len(chaine)):
			if (chaine[i] == "("):
				parenthese +=1
			if(chaine[i]== ")"):
				parenthese -=1
			if(parenthese == 0):
				break
			i+=1
		subchaineL = chaine[3:i]
		subchaineR = chaine[i+2:len(chaine)-1]
		if(operateur == "or"):
			return F1_Or(create_formule(subchaineL),create_formule(subchaineR))
		if(operateur == "ad"):
			return F1_And(create_formule(subchaineL),create_formule(subchaineR))
		if(operateur == "ip"):
			return F1_Impl(create_formule(subchaineL),create_formule(subchaineR))
	if (operateur == "no"):
		subchaine = chaine[3:len(chaine)-1]
		return F1_Neg(create_formule(subchaine))
	if(operateur in op_fleur_un):
		subchaine = chaine[3:5]
		if (operateur == "rs"):		
			return  F1_Atom("est_rose",[create_formule(subchaine)])
		if (operateur == "bl"):				
			return  F1_Atom("est_blanc",[create_formule(subchaine)])
		if (operateur == "rg"):			
			return  F1_Atom("est_rouge",[create_formule(subchaine)])
		if (operateur == "pa"):			
			return  F1_Atom("Paquerette",[create_formule(subchaine)])
		if (operateur == "tu"):			
			return  F1_Atom("Tulipe",[create_formule(subchaine)])	
		#Rose()
		if (operateur == "ro"):			
			return  F1_Atom("Rose",[create_formule(subchaine)])
		if (operateur == "ae"):			
			return  F1_Atom("a_l_est",[create_formule(subchaine)])
		if (operateur == "ao"):			
			return  F1_Atom("a_l_ouest",[create_formule(subchaine)])
		if (operateur == "an"):			
			return  F1_Atom("au_nord",[create_formule(subchaine)])	
		if (operateur == "as"):			
			return  F1_Atom("au_sud",[create_formule(subchaine)])
		if (operateur == "ep"):			
			return  F1_Atom("est_petit",[create_formule(subchaine)])
		if (operateur == "eg"):			
			return  F1_Atom("est_grand",[create_formule(subchaine)])
		if (operateur == "em"):			
			return  F1_Atom("est_moyen",[create_formule(subchaine)])	
	if (operateur in op_fleur_bin):
		subchaineL = chaine[3:5]
		subchaineR = chaine[7:9]
		if(operateur == "ed"):
			return F1_Atom("a_l_est_de",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "od"):
			return F1_Atom("a_l_ouest_de",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "nd"):
			return F1_Atom("au_nord_de",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "sd"):
			return F1_Atom("au_sud_de",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "ma"):
			return F1_Atom("meme_latitude",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "mo"):
			return F1_Atom("meme_longitude",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "pp"):			
			return F1_Atom("plus_petit_que",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "pg"):			
			return F1_Atom("plus_grand_que",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "mt"):
			return F1_Atom("meme_taille_que",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "mc"):
			return F1_Atom("meme_couleur_que",[create_formule(subchaineL),create_formule(subchaineR)])
		if(operateur == "eq"):
			return F1_Atom("egal",[create_formule(subchaineL),create_formule(subchaineR)])		
	if(operateur == "en"):
		subchaine = chaine[3:5]
		subchaineL = chaine[8-10]
		subchaineR = chaine[12-14]
		return F1_Atom("est_entre",[create_formule(subchaine),create_formule(subchaineL),create_formule(subchaineR)])


				
			

