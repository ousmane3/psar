package jardin;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.InetAddress;

import java.net.Socket;

import java.net.UnknownHostException;
import java.io.OutputStreamWriter;


public class Client {

    
	public static void main(String[] zero) {

        

    Socket socket;
	OutputStreamWriter ow;
	InputStreamReader ir;
	IJardin monJardin;
	
	int i=0;
	String result ="";
	
        try {

        

             socket = new Socket(InetAddress.getLocalHost(),15555); 
             monJardin=new Jardin();
            
            IFleur uneFleur =new Fleur(Taille.values()[0], Couleur.values()[0], Espece.values()[0], Nom.values()[17]);
     		IFleur uneDeuxiemeFleur =new Fleur(Taille.values()[1], Couleur.values()[1], Espece.values()[1], Nom.values()[1]);
     		IFleur unetroisiemeFleur =new Fleur(Taille.values()[2], Couleur.values()[2], Espece.values()[2], Nom.values()[16]);
     		IFleur unequatriemeFleur =new Fleur(Taille.values()[1], Couleur.values()[0], Espece.values()[2], Nom.values()[17]);
     		IFleur unecinqFleur =new Fleur(Taille.values()[2], Couleur.values()[1], Espece.values()[1], Nom.values()[1]);
     		IFleur unesixFleur =new Fleur(Taille.values()[2], Couleur.values()[1], Espece.values()[2], Nom.values()[14]);
     		IFleur uneseptFleur =new Fleur(Taille.values()[1], Couleur.values()[0], Espece.values()[2], Nom.values()[10]);

     		monJardin.ajouter_Fleur(uneFleur);
     		monJardin.ajouter_Fleur(uneDeuxiemeFleur);
     		monJardin.ajouter_Fleur(unetroisiemeFleur);
     		monJardin.ajouter_Fleur(unequatriemeFleur);
     		
     		monJardin.ajouter_Fleur(unecinqFleur);
     		monJardin.ajouter_Fleur(unesixFleur);
     		monJardin.ajouter_Fleur(uneseptFleur);
     		
			 ow=new OutputStreamWriter(socket.getOutputStream());
			 ir=new InputStreamReader(socket.getInputStream());
			 ow.write(monJardin.get_Jardin());
			 ow.flush();
			 while((i=ir.read())!=-1){
				 result+=(char)i;
			 }
	
			 if(result.compareTo("OK")==0){
				 System.out.println("Resultat: True");
			 }else
				 System.out.println("Resultat: False");
			 ow.close();
             socket.close();


        }catch (UnknownHostException e) {

            

           System.out.println("impossible de se connecter");

        }catch (IOException e) {

            

        	System.out.println("serveur indisponible");
        }

    }


}


