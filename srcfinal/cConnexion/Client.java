package cConnexion;
import jardin.Jardin;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*import cFormule.Formule;
import cFormule.Formules;
import cFormule.IFormule;
import cFormule.IFormules;*/


public class Client {
	static byte[] recuConnexion = new byte[2];
	static String receiveConnexion;
	private static Socket socket;
	private OutputStreamWriter socketSender;
	private InputStream socketReceiver;
	
	public Client()
	{		
	}
	
	public boolean seConnecter()
	{
		  try 
		  {
			socket = new Socket(InetAddress.getLocalHost(),15555);
			socketSender = new OutputStreamWriter(socket.getOutputStream());
			socketReceiver = socket.getInputStream();
			
			return true;
			
		  } 
		  catch (UnknownHostException e)
		  {
			// TODO Auto-generated catch block
			System.out.println("connexion impossible ");					
		  }
		  catch (IOException e)
		  {
			// TODO Auto-generated catch block
			System.out.println("connexion impossible ");
			
		  } 
		return false;		
	}
	
   public void envoyerJardin(String jardin)
   {	  	 
	      	/*envoi du jardin */	
	  	 	try
	  	 	{	
	  	 		//socketSender.write("jd");	
	  	 		socketSender.flush();
	  			socketSender.write(jardin);
	  			socketSender.flush();
	  		}
	  	 	catch (IOException e)
	  	 	{
	  			// TODO Auto-generated catch block
	  			System.out.println("erreur d'envoi du jardin ");
	  		}		   
   }
   
   public void envoyerFormule(String formule)
   {
 	 	try
 	 	{
  	 		//socketSender.write("fm");	
  	 		socketSender.flush(); 
  	 		System.out.println("fm");
 			socketSender.write(formule);
 			socketSender.flush();
 			System.out.println(formule);
 		}
 	 	catch (IOException e)
 	 	{
 			// TODO Auto-generated catch block
 			System.out.println("erreur d'envoi de la formule ");
 		}	   
   }
   public String recevoirReponse()
   {
	 	try
	 	{ 	 		
	 		socketReceiver.read(recuConnexion);	 		
			return new String(recuConnexion);
		}
	 	catch (IOException e)
	 	{
			// TODO Auto-generated catch block
			System.out.println("erreur reception formule ");
		}
	   return null;
	   
   }
 public boolean seDeconnecter()
 {
	 try {
		socketSender.write("close");
		socketSender.flush();
		socketSender.close();
		socketReceiver.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
	}
	 return false;
 }


}


