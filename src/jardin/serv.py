#!/usr/bin/env python
# coding: utf-8

import socket
from socket import *
from psar_python import *

socket = socket(AF_INET, SOCK_STREAM)
socket.bind(('', 15555))

while True:	
	socket.listen(5)
	client, address = socket.accept()
	print "{} connected".format( address )
	response = client.recv(2000)
	if response != "":
		mon_jardin=[]
		resultat=response.split(":")  
	        for i in resultat:
	        	j=i.split(",")
	        	a=int(j[0])
	        	b=int(j[1])
	        	fleur=((a,b),j[2],j[3],j[4],j[5])
	        	mon_jardin.append(fleur)
		print ("--------------------------------------------")
		print mon_jardin
	    	mon_interp_formul= j_interp_formul(mon_jardin)
	        print ("--------environnement bien construit---------------")
		f1 = F1_Atom('Rose',[Cons_term("r",[])])
		f2 = F1_Forall("x",F1_Atom("Rose",[Var_term("x")]))
	        lrt = [mon_interp_formul(f1),mon_interp_formul(f2)]
	        print ("--------Evaluation reussi---------------")
	        print lrt
	        if lrt[1]==False:
				client.send ("NOK")
				client.close()
	       	else:
	       		client.send("OK")
	       		client.close()
socket.close()


