#!/usr/bin/env python
# coding: utf-8

import socket
import gc
from socket import *
from psar_python import *
from formule import *
socket = socket(AF_INET, SOCK_STREAM)
socket.bind(('', 15555))

formules =[]

mon_interp_formul
while True:	

		socket.listen(2)
		client, address = socket.accept()
		print "{} connected".format( address )

		#on attend le jardin
		jardin = client.recv(65535)
		if jardin != "":
			mon_jardin=[]
			resultat=jardin.split(":")  
	        	for i in resultat:
	        		j=i.split(",")
	        		a=int(j[0])
	        		b=int(j[1])
	        		fleur=((a,b),j[2],j[3],j[4],j[5])
	        		mon_jardin.append(fleur)
			print mon_jardin	
	    		mon_interp_formul= j_interp_formul(mon_jardin)

		#on attend les formules
		
			chaineFormule=client.recv(65535)
			chaineFormule.strip
			while(chaineFormule != "close"):			
				if chaineFormule != "":
					formule = create_formule(chaineFormule)	

					try:	      	
						lrt = mon_interp_formul(formule)
						if(lrt==True):
							resultat ="ok"
							client.send("ok")
						else : 
							resultat ="no"
							client.send("no")
					except ValueError:
						resultat ="ror"
						client.send("ro")				
						pass				

					print resultat
				chaineFormule=client.recv(65535)
				chaineFormule.strip				
	
			client.close() 	     
socket.close()	
