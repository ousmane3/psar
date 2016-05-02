package GrahiqueDuJardin;

import jardin.Coordonnees;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import jardin.Couleur;
import jardin.Espece;
import jardin.Fleur;
import jardin.Jardin;
import jardin.Nom;
import jardin.Taille;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import cConnexion.Client;
import cFormule.Formule;
import cFormule.Formules;
import cFormule.IFormule;
import cFormule.IFormules;


/**
 *
 * @author Ousmane3
 */
public class FenetreJardin extends JFrame implements ActionListener{    
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar = new JMenuBar();
    private JMenu Fichier = new JMenu("Fichier");    
    private JMenu aide = new JMenu("A propos");
    
    
    private JMenuItem Ouvrir = new JMenuItem("Ouvrir");
    private JMenuItem Fermer = new JMenuItem("Fermer");
    private JMenuItem Sauvegarder = new JMenuItem("Sauvegarder");
    private JMenuItem apropos = new JMenuItem("A propos");
    private JMenuItem aides = new JMenuItem("?");
    
    private JMenuItem saveJ;
    private JMenuItem loadJ;
    private JMenuItem saveF;
    private JMenuItem loadF;
	
	
   private String nomFleur[]={"None","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"};
   private boolean[] avalaibleNomFLeur;
   private int nbimageParFleur = 9;
   private ImageIcon fleursRose[]=new ImageIcon[nbimageParFleur]; /* rose */
   private ImageIcon fleursTulipe[]=new ImageIcon[nbimageParFleur]; /* tulipe */
   private ImageIcon fleursPaquerette[]=new ImageIcon[nbimageParFleur]; /* paquerettes */
   private ImageIcon blanc;
   
   private JLabel [][] mesFleurs;	/* tableau de jlabel qui contient les fleurs*/ 
   private JLabel labelNomFleurs;	/* le label pour la combo des nom des fleurs*/
   private JLabel jCurrentLabel;	/* label pour avoir l'image courante ppour le deplacement */
   private int jCurrentLabelX;
   private int jCurrentLabelY;
   
   private JLabel enterLabel;		/* label sur lequel on est actu */
   private int enterLabelX;
   private int enterLabelY;
  
   private JPanel [][] panelFleurs; /* tableau de panel du jardin */
   private JPanel panelEspece;		/* panel pour les especes*/
   private JPanel ptaille; 		/* panel pour la taille */
   private JPanel panelNomFleurs;	/* panel pour les noms */
   private JPanel pCouleur;			/* panel pour les couleurs*/
   private JPanel pentete;			/* panel d'entete */
   private JPanel panelBouton;		/* panel pour les boutons */
   private JPanel panelCentre;		/* panel pour le centre */
   private JPanel panelJardin;		/* panel contenant le jardin */
   private JPanel panelFormule;		/* panel pour les formules */
   
   
   
   /* les radioboutons pour les especes  de fleur */
   private JRadioButton rbRose;
   private JRadioButton rbtulipe;
   private JRadioButton rbpaquerette;
   /* les radioboutons pour les tailles de fleur */
   private JRadioButton rbpetite;
   private JRadioButton rbmoyen;
   private JRadioButton rbgrande;
   /* les radioboutons pour les couleuirs de fleur */
   private JRadioButton rbcouleurRose;
   private JRadioButton rbcouleurRouge;
   private JRadioButton rbcouleurBlanche;
     
   private int espece,couleur,taille;
   private int nom=0;
   
   boolean oneKeyPresse=false;
   boolean jardinHasChanged = false; // signale si le jardin a été modifié
   private int nbligne;
   private int nbcolone;
    
    

   private JButton btnEvaluer ;
   private JButton btnAjouter;
   private JButton btnEffacer;
      
   private JComboBox<String> combNOmFleur;
  
    
   private Jardin jardin; 
   private Fleur  uneFleur;
   
   //pour l'echange avec le serveur 
    Client connexion ;
    
    //creatoin de mon tableau de fleurs
    public void chargementDesFleurs(){
    	
    	blanc = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/blanc.png");
        fleursRose[0]=new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseBlancheGrande.jpg");
        fleursRose[1]=new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseBlancheMoyenne.jpg");
        fleursRose[2]=new  ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseBlanchePetite.jpg");
        
        fleursRose[3]=new  ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseRoseGrande.jpg");
        fleursRose[4]=new  ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseRoseMoyenne.jpg");
        fleursRose[5]=new  ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseRosePetite.jpg");
        
        fleursRose[6]=new  ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseRougeGrande.jpg");
        fleursRose[7]=new  ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseRougeMoyenne.jpg");
        fleursRose[8]=new  ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/roseRougePetite.jpg");
        
       
       
        fleursPaquerette[0] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteBlancheGrande.jpg"); // attention à la manière d'aller chercher ce fichier (ceci peut fonctionner ou pas selon l'emplacement du fichier) : 
        fleursPaquerette[1]= new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteBlancheMoyenne.jpg");                    
        fleursPaquerette[2] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteBlanchePetite.jpg");
        
        fleursPaquerette[3] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteRoseGrande.jpg"); // attention à la manière d'aller chercher ce fichier (ceci peut fonctionner ou pas selon l'emplacement du fichier) : 
        fleursPaquerette[4]= new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteRoseMoyenne.jpg");                    
        fleursPaquerette[5] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteRosePetite.jpg");
        
        fleursPaquerette[6] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteRougeGrande.jpg"); // attention à la manière d'aller chercher ce fichier (ceci peut fonctionner ou pas selon l'emplacement du fichier) : 
        fleursPaquerette[7]= new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteRougeMoyenne.jpg");                    
        fleursPaquerette[8] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/paqueretteRougePetite.jpg");
        
        fleursTulipe[0] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeBlancheGrande.jpg"); // attention à la manière d'aller chercher ce fichier (ceci peut fonctionner ou pas selon l'emplacement du fichier) : 
        fleursTulipe[1] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeBlancheMoyenne.jpg");
        fleursTulipe[2] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeBlanchePetite.jpg");
        
        fleursTulipe[3] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeRoseGrande.jpg"); // attention à la manière d'aller chercher ce fichier (ceci peut fonctionner ou pas selon l'emplacement du fichier) : 
        fleursTulipe[4] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeRoseMoyenne.jpg");
        fleursTulipe[5] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeRosePetite.jpg");
        
        fleursTulipe[6] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeRougeGrande.jpg"); // attention à la manière d'aller chercher ce fichier (ceci peut fonctionner ou pas selon l'emplacement du fichier) : 
        fleursTulipe[7] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeRougeMoyenne.jpg");
        fleursTulipe[8] = new ImageIcon("/home/jean-marc/workspace/projetPSAR/src/GrahiqueDuJardin/images/tulipeRougePetite.jpg");
        
            
    }
    
    /*
     * cree le menu 
     */
    public void creationMenu(){
    	
    	Fichier.setMnemonic('F');
    	aide.setMnemonic('A');
    	this.Fichier.add(Ouvrir);
    	this.Fichier.add(Sauvegarder);
    	this.Fichier.add(Fermer);
    	
    	this.aide.add(apropos);
    	this.aide.add(aides);
    	
    	/*jardin*/
    	saveJ = new JMenuItem("Sauvegarder Jardin");
    	loadJ = new JMenuItem("Charger Jardin");
    	
    	/*formules*/
    	saveF = new JMenuItem("Sauvegarder Formules");
    	loadF = new JMenuItem("Charger Formules");
    	
        saveJ.addActionListener((java.awt.event.ActionEvent evt) -> {
            saveJActionPerformed(evt);
         });
        loadJ.addActionListener((java.awt.event.ActionEvent evt) -> {
            loadJActionPerformed(evt);
         }); 
    	
        saveF.addActionListener((java.awt.event.ActionEvent evt) -> {
            saveFActionPerformed(evt);
         });
        loadF.addActionListener((java.awt.event.ActionEvent evt) -> {
            loadFActionPerformed(evt);
         }); 
        
        this.Fichier.add(saveJ);
        this.Fichier.add(loadJ);
        
        this.Fichier.add(saveF);
        this.Fichier.add(loadF);
        
    	this.menuBar.add(Fichier);    	
    	this.menuBar.add(aide);
        
       	this.Ouvrir.addActionListener(this);
       	this.Fermer.addActionListener(this);
       	this.Sauvegarder.addActionListener(this);
       	
       	this.setJMenuBar(menuBar);
    }
    /*
     * creation du jardin 
     */
    public FenetreJardin(int ligne,int colone)
    {
    	
         super("logique du 1er ordre");
         
        
        /**************Gestion espace formule******************/
         
         zoneSaisie = new JTextField[10];   
         zSelect = new JCheckBox[zoneSaisie.length];         
         resultSaisie = new JLabel[zoneSaisie.length];
         hasBeenModified = new boolean[zoneSaisie.length];
         zoneFormule = new JPanel();
         formule = new Formule[zoneSaisie.length];
         
         GFormule =  new JPanel();
         zoneButton = new JPanel();
         
         zoneButton = new JPanel();
         jLauncher = new JButton[btnOperations.length];

         zoneLauncher = new JPanel();
         zoneLauncher.setPreferredSize(new Dimension(450, 35));
         zoneLauncher.setMaximumSize(zoneLauncher.getPreferredSize());
         zoneLauncher.setMinimumSize(zoneLauncher.getPreferredSize());
         zoneLauncher.setLayout(new FlowLayout(FlowLayout.TRAILING));
         zoneLauncher.setLayout(new FlowLayout(FlowLayout.RIGHT));       
         
         zoneSaisieAut = new JTabbedPane();
         
          f_espece = new JPanel();
         
         f_espece.setPreferredSize(new Dimension(80, 60));
         f_espece.setMaximumSize(f_espece.getPreferredSize());
         f_espece.setMinimumSize(f_espece.getPreferredSize());
         f_espece.setLayout(new FlowLayout(FlowLayout.TRAILING));
         f_espece.setLayout(new FlowLayout(FlowLayout.LEFT));
         
         f_especes = new JButton[especeFleur.length];
         //f_taille
         f_taille = new JPanel();
         f_tailles = new JButton[6];
         
         //constante
         constante = new JPanel();
         constantes = new JButton[20];
                  
         //variable
         variable = new JPanel();
         variables = new JButton[5];
         
                  //connecteur
         connecteur = new JPanel();
         connecteurs = new JButton[9];
                //position
         position = new JPanel();
         positions = new JButton[10];
         
          //f_couleur
         f_couleur = new JPanel();
         f_couleurs = new JButton[4];
         
         //bouton ajout
         ajout = new JButton();
         ajout.setPreferredSize(new Dimension(110, 25));
         ajout.setMaximumSize(zoneFormule.getPreferredSize());
         ajout.setMinimumSize(zoneFormule.getPreferredSize());
         ajout.setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
         ajout.setText("Ajouter");
         ajout.setFocusable(false);
        ajout.addActionListener((java.awt.event.ActionEvent evt) -> {
            ajoutActionPerformed(evt);
         });
        zoneFormule.add(ajout);
        
        /**bouton selectionner,analyser evaluer**/        
        for(i = 0; i < jLauncher.length;i++)
         {
            jLauncher[i] = new JButton();
            
           jLauncher[i].setPreferredSize(new Dimension(100, 25));
           
           
            jLauncher[i].setMaximumSize(zoneFormule.getPreferredSize());
            jLauncher[i].setMinimumSize(zoneFormule.getPreferredSize());
            jLauncher[i].setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
            jLauncher[i].setText(btnOperations[i]);
            zoneLauncher.add(jLauncher[i]);
            
              jLauncher[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            jLauncherActionPerformed(evt);
         });
  
              zoneFormule.add(zoneLauncher);
         }  
        
               for(i= 0 ; i <  zoneSaisie.length;i++)
         {
             
             zoneSaisie[i] = new JTextField();             
             zoneSaisie[i].setPreferredSize(new Dimension(500, 25)); 
             zoneSaisie[i].setMaximumSize(zoneSaisie[i].getPreferredSize());
             zoneSaisie[i].setMinimumSize(zoneSaisie[i].getPreferredSize());
             
             hasBeenModified[i]= false;
             formule[i] = new Formule();

             resultSaisie[i] = new JLabel();             
             resultSaisie[i].setPreferredSize(new Dimension(50, 25)); 
             resultSaisie[i].setMaximumSize(zoneSaisie[i].getPreferredSize());
             resultSaisie[i].setMinimumSize(zoneSaisie[i].getPreferredSize());
             resultSaisie[i].setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
             resultSaisie[i].setForeground(new java.awt.Color(0, 255, 0));
              resultSaisie[i].setBackground(new java.awt.Color(255, 255, 104));
             
             
             zSelect[i] = new JCheckBox();
             if(i==0)
             {
                 zoneSaisie[i].requestFocus();
                 zoneSaisie[i].setVisible(true);
                 zSelect[i].setVisible(true);
                 zSelect[i].setSelected(true);
                  resultSaisie[i].setVisible(false);
             }
             else
             {
                 zoneSaisie[i].setVisible(false);
                 zSelect[i].setVisible(false);

             }
             zoneFormule.add(zoneSaisie[i]);                         
             
             //zSelect[i].
             zoneFormule.add(zSelect[i]);
            zoneFormule.add(resultSaisie[i]);
               zoneSaisie[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            zoneSaisieActionPerformed(evt);
         });
                        zoneSaisie[i].addKeyListener(new java.awt.event.KeyListener() {
           @Override
           public void keyTyped(KeyEvent ke) {
               zoneSaisieActionPerformed(ke); 
               }



                 @Override
                 public void keyPressed(KeyEvent ke) {  
                      currentTextField = (JTextField)ke.getSource(); //                         
                 }

                 @Override
                 public void keyReleased(KeyEvent ke) {
                     //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }
        });
                        
         zoneSaisie[i].addMouseListener(new java.awt.event.MouseListener(){
                 @Override
                 public void mouseClicked(MouseEvent me) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    currentTextField = (JTextField)me.getSource();
               
                    currentPosition = currentTextField.getCaretPosition();
                 }

                 @Override
                 public void mousePressed(MouseEvent me) {
                    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                     currentTextField = (JTextField)me.getSource();
                
                 
                 }

                 @Override
                 public void mouseReleased(MouseEvent me) {
                   //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public void mouseEntered(MouseEvent me) {
                     //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public void mouseExited(MouseEvent me) {
                   //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }
             
         });
             
         }
                  //// Panel de saisie
         zoneFormule.setPreferredSize(new Dimension(650, 750));
         zoneFormule.setMaximumSize(zoneFormule.getPreferredSize());
         zoneFormule.setMinimumSize(zoneFormule.getPreferredSize());
         zoneFormule.setLayout(new FlowLayout(FlowLayout.TRAILING));
         zoneFormule.setLayout(new FlowLayout(FlowLayout.LEFT));
         zoneFormule.setBorder(javax.swing.BorderFactory.createTitledBorder("Formules"));  
         
         for(i = 0; i < f_especes.length;i++)
         {
            f_especes[i] = new JButton();
            f_especes[i].setPreferredSize(new Dimension(100, 25));
            f_especes[i].setMaximumSize(zoneFormule.getPreferredSize());
            f_especes[i].setMinimumSize(zoneFormule.getPreferredSize());
            f_especes[i].setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
            f_especes[i].setFocusable(false);
            switch(i){
                case 0:
                    text = "Rose";
                    break;                    
                case 1:
                    text = "Tulipe";
                    break;                    
                case 2:
                    text = "Paquerette";
                    break;
            }
            
            f_especes[i].setText(text);
            f_espece.add(f_especes[i]);
            f_especes[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            f_especesActionPerformed(evt);
         });
         } 
         
                 f_espece.setPreferredSize(new Dimension(200, 100));
         f_espece.setMaximumSize(zoneFormule.getPreferredSize());
         f_espece.setMinimumSize(zoneFormule.getPreferredSize());
         f_espece.setBorder(javax.swing.BorderFactory.createEtchedBorder());
         

         //ajout à tabbed Panne
         
         zoneSaisieAut.add("Espèces", f_espece);
         
         //// buttons f_tailles 

         for(i = 0; i <f_tailles.length;i++)
         {
            f_tailles[i] = new JButton();
            f_tailles[i].setPreferredSize(new Dimension(120, 25));
            f_tailles[i].setMaximumSize(zoneFormule.getPreferredSize());
            f_tailles[i].setMinimumSize(zoneFormule.getPreferredSize());
            f_tailles[i].setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
            f_tailles[i].setFocusable(false);
            switch(i){
                case 0:
                    text = "est_grand";
                    break;                    
                case 1:
                    text = "est_moyen";
                    break;                    
                case 2:
                    text = "est_petit";
                    break;                    
                case 3:
                    text = "plus_grand_que";
                    break;                    
                case 4:
                    text = "meme_taille_que";
                    break;                    
                case 5:
                    text = "plus_petit_que";
                    break;        
                    
            }
            
            f_tailles[i].setText(text);
            f_taille.add(f_tailles[i]);
            f_tailles[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            f_taillesActionPerformed(evt);
         });
           
         } 
    
         
          // pannel boutons f_especes
         f_taille.setPreferredSize(new Dimension(200, 100));
         f_taille.setMaximumSize(zoneFormule.getPreferredSize());
         f_taille.setMinimumSize(zoneFormule.getPreferredSize());
         f_taille.setBorder(javax.swing.BorderFactory.createEtchedBorder());        
         //ajout à tabbed Panne
         
         zoneSaisieAut.add("Taille", f_taille);
         
                  //// buttons constantes   
                  
                  
          i = 0;
         text ="";
         for(i=0; i < constantes.length;i++)
         {
            constantes[i] = new JButton();
            constantes[i].setPreferredSize(new Dimension(45, 25));
            constantes[i].setMaximumSize(zoneFormule.getPreferredSize());
            constantes[i].setMinimumSize(zoneFormule.getPreferredSize());
            constantes[i].setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
            constantes[i].setFocusable(false);
            
            switch(i){
                case 0:
                    text = "a";
                    break;                    
                case 1:
                    text = "b";
                    break;                    
                case 2:
                    text = "c";
                    break;                    
                case 3:
                    text = "d";
                    break;                    
                case 4:
                    text = "e";
                    break;                    
                case 5:
                    text = "f";
                    break;                     
                case 6:
                    text = "g";
                    break;                     
                case 7:
                    text = "h";
                    break;                     
                case 8:
                    text = "i";
                    break;                    
                case 9:
                    text = "j";
                    break;                      
                case 10:
                    text = "k";
                    break;                      
                case 11:
                    text = "l";
                    break;                     
                case 12:
                    text = "m";
                    break;                    
                case 13:
                    text = "n";
                    break;                    
                case 14:
                    text = "o";
                    break;                    
                case 15:
                    text = "p";
                    break;                    
                case 16:
                    text = "q";
                    break;                    
                case 17:
                    text = "r";
                    break;                    
                case 18:
                    text = "s";
                    break;                    
                case 19:
                    text = "t";
                    break;
                    
                    
            }
            
            constantes[i].setText(text);
            constante.add(constantes[i]);
            constantes[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            constantesActionPerformed(evt);
         });
            
         }          
         zoneSaisieAut.add("Constantes", constante);  
                  
         //// buttons variables 
         i = 0;
         text ="";
         for(i = 0 ; i <variables.length;i++)
         {
           variables[i] = new JButton();
           variables[i].setPreferredSize(new Dimension(45, 25));
           variables[i].setMaximumSize(zoneFormule.getPreferredSize());
           variables[i].setMinimumSize(zoneFormule.getPreferredSize());
           variables[i].setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
           variables[i].setFocusable(false);
           
            switch(i){
                case 0:
                    text = "v";
                    break;                    
                case 1:
                    text = "w";
                    break;                    
                case 2:
                    text = "x";
                    break;                    
                case 3:
                    text = "y";
                    break;                    
                case 4:
                    text = "z";
                    break;                   
            }
            
            variables[i].setText(text);
            variable.add(variables[i]);    
            variables[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            variablesActionPerformed(evt);
         });
            
           
         }       
         
         zoneSaisieAut.add("Variables", variable);
                  
                  //// buttons connecteur    
                  
                                    
          i = 0;
         text ="";
         for(i = 0; i < connecteurs.length; i++)
         {
            connecteurs[i] = new JButton();
            connecteurs[i].setPreferredSize(new Dimension(45, 25));
            connecteurs[i].setMaximumSize(zoneFormule.getPreferredSize());
            connecteurs[i].setMinimumSize(zoneFormule.getPreferredSize());
           connecteurs[i].setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
           connecteurs[i].setFocusable(false);
            
            switch(i){
                case 0:
                    text = "∀";
                    break;                    
                case 1:
                    text = "∃";
                    break;                    
                case 2:
                    text = "˥";
                    break;                    
                case 3:
                    text = "=";
                    break;                    
                case 4:
                    text = "∨";
                    break;                    
                case 5:
                    text = "∧";
                    break;                     
                case 6:
                    text = "⇒";
                    break;                     
                case 7:
                    text = "(";
                    break;                     
                case 8:
                    text = ")";
                    break;                    
                    
            }
            
            connecteurs[i].setText(text);
            connecteur.add(connecteurs[i]);
          connecteurs[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            connecteursActionPerformed(evt);
         });            
            
         }
         
          zoneSaisieAut.add("Connecteurs", connecteur);
          
          //position
          i = 0;
           text="";
          for(i = 0 ; i < positions.length; i++)
          {
              positions[i] = new JButton();
              positions[i].setPreferredSize(new Dimension(120, 25));
              positions[i].setMaximumSize(zoneFormule.getPreferredSize());
              positions[i].setMinimumSize(zoneFormule.getPreferredSize());
              positions[i].setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
              positions[i].setFocusable(false);
              
              switch(i)
              {
                  
                    case 0:
                    text ="a_l_est" ;  
                    break;                                      
                    case 1:
                    text ="a_l_ouest" ;  
                    break;                                      
                    case 2:
                    text ="au_nord" ;  
                    break;                  
                    case 3:
                    text ="au_sud" ;  
                    break;                  
                    case 4:
                    text ="a_l_est_de" ;  
                    break;                  
                    case 5:
                    text ="a_l_ouest_de" ;  
                    break;                  
                    case 6:
                    text ="au_nord_de" ;  
                    break;                  
                    case 7:
                    text ="au_sud_de" ;  
                    break;                  
                    case 8:
                    text ="meme_latitude" ;  
                    break;                  
                    case 9:
                    text ="meme_longitude" ;  
                    break;
                    
              }
              positions[i].setText(text);
              position.add(positions[i]);
              positions[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            positionsActionPerformed(evt);
         });
              
          }
          
         zoneSaisieAut.add("Positions", position);
         
                   //position
          i = 0;
          text="";
          for(i = 0; i < f_couleurs.length; i++)
          {
              f_couleurs[i] = new JButton();
              f_couleurs[i].setPreferredSize(new Dimension(130, 25));
              f_couleurs[i].setMaximumSize(zoneFormule.getPreferredSize());
              f_couleurs[i].setMinimumSize(zoneFormule.getPreferredSize());
              f_couleurs[i].setFont(new java.awt.Font("Tahoma Arial Times New Roman",0,11));
               f_couleurs[i].setFocusable(false);
              
              switch(i)
              {
                  
                    case 0:
                    text ="est_rose" ;  
                    break;                                      
                    case 1:
                    text ="est_rouge" ;  
                    break;                                      
                    case 2:
                    text ="est_blanc" ;  
                    break;                  
                    case 3:
                    text ="meme_couleur_que" ;  
                    break;                   
              }
              f_couleurs[i].setText(text);
              f_couleur.add(f_couleurs[i]);
               f_couleurs[i].addActionListener((java.awt.event.ActionEvent evt) -> {
            f_couleursActionPerformed(evt);
         });
            
          }
          
         zoneSaisieAut.add("Couleurs", f_couleur);
         
        
        //creation du layout pour GFormule

        javax.swing.GroupLayout GFormuleLayout = new javax.swing.GroupLayout(GFormule);
        GFormule.setLayout(GFormuleLayout);
        GFormuleLayout.setHorizontalGroup(
            GFormuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GFormuleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zoneFormule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(703, Short.MAX_VALUE))
                .addGroup(GFormuleLayout.createSequentialGroup()
                .addComponent(zoneSaisieAut, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        GFormuleLayout.setVerticalGroup(
            GFormuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GFormuleLayout.createSequentialGroup()
                .addComponent(zoneSaisieAut, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(GFormuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zoneFormule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(626, Short.MAX_VALUE))
        );      
        
        this.getContentPane().add(GFormule);
        
   
        
        /*******************************************************/
        avalaibleNomFLeur = new boolean[ nomFleur.length];
    	for(int i = 0; i < nomFleur.length;i++)
    		avalaibleNomFLeur[i]= true;
    	
        chargementDesFleurs();

        //creation du menu
        creationMenu();
        
        //nombre de ligne et colone du jardin
        this.nbligne=ligne;
        this.nbcolone=colone;
        
        this.mesFleurs=new JLabel[ligne][colone];
        this.panelFleurs=new JPanel[ligne][colone];
        
        
        /* panel espece */
        panelEspece =new JPanel();
        panelEspece.setBorder(new TitledBorder("espece")); 
        // creation des radiobouton 
        rbRose=new JRadioButton("rose");
        rbtulipe=new JRadioButton("tulipe");
        rbpaquerette=new JRadioButton("paquerette");
        //ajout des radioboutons dans le panel
        panelEspece.add(rbRose);
        panelEspece.add(rbpaquerette);
        panelEspece.add(rbtulipe);
        
        /*panel taille */
        ptaille =new JPanel();
        ptaille.setBorder(new TitledBorder("Taille"));
        //creation des radiobouton
        rbpetite=new JRadioButton("Petite");
        rbmoyen=new JRadioButton("Moyenne");
        rbgrande=new JRadioButton("Grande");
        //ajout dans le panel
        ptaille.add(rbpetite);
        ptaille.add(rbmoyen);
        ptaille.add(rbgrande);
        
        
        /* panel Nom des fleurs */
        panelNomFleurs =new JPanel();
        panelNomFleurs.setBorder(new TitledBorder("Nom"));
        //creation       
        combNOmFleur=new JComboBox<String>();
        for(int i=0;i<20;i++){
        	combNOmFleur.addItem(nomFleur[i]); 
        }      
       //creation d'un label      
        labelNomFleurs=new JLabel("Nom des fleurs ");
        panelNomFleurs.add(labelNomFleurs);
        panelNomFleurs.add(combNOmFleur);

        
        
       /* panel couleur */
       pCouleur=new JPanel();
       pCouleur.setBorder(new TitledBorder("Couleur"));

       rbcouleurRose=new JRadioButton("Rose");
       rbcouleurRouge=new JRadioButton("Rouge");
       rbcouleurBlanche=new JRadioButton("Blanche");
       
       pCouleur.add(rbcouleurRose);
       pCouleur.add(rbcouleurRouge);
       pCouleur.add(rbcouleurBlanche);
       
       panelBouton =new JPanel();
       panelBouton.setBorder(new TitledBorder("action"));
       
       btnAjouter =new JButton("Ajouter");
       btnEffacer =new JButton("Effacer");
          
       panelBouton.add(btnAjouter);
       panelBouton.add(btnEffacer);
             
      
       
       
       panelFormule=new JPanel();
       panelFormule.setBorder(new TitledBorder("formules"));
       panelFormule.setLayout(new GridLayout(1,1));
       btnEvaluer=new JButton("Evaluer");
      // panelFormule.add(btnEvaluer);
      panelFormule.add(GFormule,BorderLayout.CENTER);
              
      
        pentete=new JPanel();
       
        pentete.setLayout(new GridLayout(1, 5));
        pentete.add(panelEspece);
        pentete.add(ptaille);
        pentete.add(pCouleur);
        pentete.add(panelNomFleurs);
        pentete.add(panelBouton);
        
         creerJardin();
         
         
        //panel central qui contient le jardin et les formules
        panelCentre=new JPanel();
        panelCentre.setLayout(new GridLayout(1,2));
        panelCentre.add(panelJardin,BorderLayout.WEST)   ;
        panelCentre.add(panelFormule,BorderLayout.EAST)   ;
        
        this.getContentPane().add(pentete,BorderLayout.NORTH);
        this.getContentPane().add(panelCentre,BorderLayout.CENTER);
        
       
    
        /* les radioboutons ecoutent les evenements */
        rbRose.addActionListener(this);
        rbpaquerette.addActionListener(this);
        rbtulipe.addActionListener(this);
        
        rbpetite.addActionListener(this);
        rbmoyen.addActionListener(this);
        rbgrande.addActionListener(this);
        
       
        rbcouleurRose.addActionListener(this);
        rbcouleurRouge.addActionListener(this);
        rbcouleurBlanche.addActionListener(this);
         
        btnAjouter.addActionListener(this);
        btnEffacer.addActionListener(this);
        btnEvaluer.addActionListener(this);
        
        combNOmFleur.addActionListener(this);
        

        
    }

    
    public void actionPerformed(ActionEvent e)
    {
        
    	int ajoutEstFait=0;
        
        //espece selectionne
        if(e.getSource()==rbRose){
            
            rbtulipe.setSelected(false);
            rbpaquerette.setSelected(false);        
            espece=0;
        }else
         if(e.getSource()==rbpaquerette){
            rbtulipe.setSelected(false);
            rbRose.setSelected(false); 
            espece=1;
        }else
        if(e.getSource()==rbtulipe){
            rbRose.setSelected(false);
            rbpaquerette.setSelected(false); 
            espece=2;
        }else
        
        //couleur
        if (e.getSource()==rbcouleurRose){
             rbcouleurBlanche.setSelected(false);
            rbcouleurRouge.setSelected(false); 
            couleur=0;
        }else
        
        if (e.getSource()==rbcouleurRouge){
             rbcouleurBlanche.setSelected(false);
            rbcouleurRose.setSelected(false);
            couleur=1;
        }else
        if (e.getSource()==rbcouleurBlanche){
                rbcouleurRose.setSelected(false);
               rbcouleurRouge.setSelected(false);
               couleur=2;
         }
        
        //taille
         if (e.getSource()==rbpetite){
              rbmoyen.setSelected(false);
            rbgrande.setSelected(false);
            
            taille=0;
        }else
        if (e.getSource()==rbmoyen){
            rbpetite.setSelected(false);
            rbgrande.setSelected(false);
            taille=1;
        }else
        if (e.getSource()==rbgrande){
              rbmoyen.setSelected(false);
            rbpetite.setSelected(false);
            taille=2;
        }else
        if(e.getSource()==combNOmFleur){
        	nom=combNOmFleur.getSelectedIndex();
   
        }
         
          //bouton valider
        if(e.getSource()==btnAjouter){
            jardinHasChanged = true;
         	
        	if(!avalaibleNomFLeur[nom])
        	{
        		
        		nom = 0;
        	}
        	else
        	{
        		if(nom != 0)
        			{
        				
        				avalaibleNomFLeur[nom]=false;
        			}
        	}
            
            for(int i=0;i<nbligne;i++){
                
                for(int j=0;j<nbcolone;j++){
                
                    if(this.mesFleurs[i][j].getIcon()==blanc){
                        ajouterFleur(i,j,espece,couleur,taille,nom);
                        this.validate();
                        ajoutEstFait=1;
                        break;
                    }
                
                }
                if(ajoutEstFait==1){
                    ajoutEstFait=0;
                    break;
                }
            }
        }
        //efface tout le jardin 
        if(e.getSource()==btnEffacer){
        	 jardinHasChanged = true;	
        	
           for(int i=0;i<nbligne;i++){
               for(int j=0;j<nbcolone;j++){
                    
                    	panelFleurs[i][j].setBorder(new TitledBorder(""));
                    	mesFleurs[i][j].setText("");
                        mesFleurs[i][j].setIcon(blanc);
                        
               }       
           }
           jardin.suppAll();
         
        }

        if (e.getSource()==Ouvrir){      	
        	
        	String nomFile="";
        	JFileChooser chooser = new JFileChooser();
            int retour = chooser.showOpenDialog(this);
            if(retour == JFileChooser.APPROVE_OPTION) {
               // un fichier a été choisi ( sortie par OK)
            	nomFile=chooser.getSelectedFile().getName();       // nom du fichier                                                chooser.getSelectedFile().getAbsolutePath();// chemin absolu du fichier
               //tout ce qu'il faut faire apres...            	
            	ouvrir();
            }
        	
        }
        if(e.getSource()==Fermer){
        	System.exit(0);
        	
        }
        if(e.getSource()==Sauvegarder){
        	
        	this.jardin.sauvegarder_Jardin();
        	try {
				saveFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        }
        
      
        
}
    
    public void ouvrir(){
    	
    	FileReader fr;
		BufferedReader br;
		String s="";
		int x,y,i=0;
		
		try {
			fr = new FileReader("jardin");
			br=new BufferedReader(fr);
			
		while((s=br.readLine())!=null){
			
			
			s.split(",");
			while(i<8){
				//x,y,espece,taille,couleur,nom
				x=Integer.parseInt(s.valueOf(0));
				y=Integer.parseInt(s.valueOf(1));
				
				switch (s.valueOf(2)) {
				case "rose":
					espece=0;
					break;
				case "paquerette":
					espece=1;
					break;
				case "tulipe":
					espece=2;
					break;
				default:
					break;
				}
				switch (s.valueOf(3)) {
				case "petite":
					taille=0;
					break;
				case "moyenne":
					taille=1;
					break;
				case "grande":
					taille=2;
					break;
				default:
					break;
				}
				
				switch (s.valueOf(4)) {
				case "rose":
					couleur=0;
					break;
				case "rouge":
					couleur=1;
					break;
				case "blanche":
					couleur=2;
					break;
				default:
					break;
				}
				
				ajouterFleur(x, y, espece, couleur, taille, nom);
			
				i++;
			}
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			
		}
    }
    boolean saveFile () throws IOException {
    	File file = new File("jardin");
    	JFileChooser fc = new JFileChooser ();
    	FileWriter fw=new FileWriter(file);
    	// Start in current directory
    	fc.setCurrentDirectory (new File ("."));


    	// Open chooser dialog
    	int result = fc.showSaveDialog (this);

    	if (result == JFileChooser.CANCEL_OPTION) {
    		return true;
    	} else if (result == JFileChooser.APPROVE_OPTION) {
	    	file = fc.getSelectedFile ();
	    	if (file.exists ()) {
	    		int response = JOptionPane.showConfirmDialog (null,"ecraser le fichier existant?",
	    												"Confirm Overwrite",
	    												JOptionPane.OK_CANCEL_OPTION,
	    												JOptionPane.QUESTION_MESSAGE);
	    		if (response == JOptionPane.CANCEL_OPTION) return false;
	    		else {
	    			fw.write(this.jardin.get_Jardin());
	    			fw.flush();
	    			fw.close();
	    		}
	    	}
    	}
		return false;
	    
    	}    
    //creer la fleur en fonction des proprietes 
    public void ajouterFleur(int i,int j,int espece,int couleur,int taille,int nom){
       Espece e = null;
       Taille t;
       Couleur c;
       Nom n;
        int width=0,heigth=0;
      
        if (taille==0){
            width=50;
            heigth=50;
           
            
        }else if(taille==1){
            width=100;heigth=100;
           
            
        }else if(taille==2){
            width=150;heigth=150;
           
        } 
        e = Espece.values()[espece];
        c=Couleur.values()[couleur];
        n=Nom.values()[nom];        
        t=Taille.values()[taille];       
        
        switch (e) {
		case rose:
			switch(t)
			{
				case petite:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursRose[2]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursRose[5]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursRose[8]);
							break;							
					}
					break;
				case moyenne:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursRose[1]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursRose[4]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursRose[7]);
							break;							
					}
					break;
				case grande:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursRose[0]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursRose[3]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursRose[6]);
							break;							
					}
					break;			
			}
			break;
		case tulipe:
			switch(t)
			{
				case petite:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[2]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[5]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[8]);
							break;							
					}
					break;
				case moyenne:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[1]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[4]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[7]);
							break;							
					}
					break;
				case grande:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[0]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[3]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursTulipe[6]);
							break;							
					}
					break;			
			}
			break;
		case paquerette:
			switch(t)
			{
				case petite:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[2]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[5]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[8]);
							break;							
					}
					break;
				case moyenne:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[1]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[4]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[7]);
							break;							
					}
					break;
				case grande:
					switch(c)
					{
						case blanc:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[0]);	
							break;
						case rose:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[3]);
							break;
						case rouge:
							this.mesFleurs[i][j].setIcon(this.fleursPaquerette[6]);
							break;							
					}
					break;			
			}
			
			break;
		
		default:
			break;
		}
        
        
        
        
       
        
        this.mesFleurs[i][j].setSize(width,heigth);
        if(!nomFleur[nom].equals("None"))
             this.mesFleurs[i][j].setText(nomFleur[nom]);
        this.mesFleurs[i][j].setName(nomFleur[nom]);
       //construction du jardin 
        uneFleur =new Fleur(e,t,c,n);
        jardin.ajouter_Fleur(i,j,uneFleur);
       
      
    }
    
    /*
     * creation du jardin 
     */
    private void creerJardin() {
    	
    	//creation du jardin 
        jardin=new Jardin();
    	
        
        
        
        panelJardin=new JPanel();
        panelJardin.setLayout(new GridLayout(nbligne, nbcolone));
        panelJardin.setBorder(new TitledBorder("jardin"));
       
        
        //creation des labels qui contiendront les fleurs du jardin
        for(int i=0; i<nbligne;i++){
            for(int j=0;j<nbcolone;j++){
                
                panelFleurs[i][j]=new JPanel();
                mesFleurs[i][j]=new JLabel("");
                mesFleurs[i][j].setIcon(blanc);            
                
     
                
                mesFleurs[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    	
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                     
                    	jCurrentLabel=(JLabel)e.getSource();
                    	for(int i = 0 ; i < nbligne; i++ )
                    		for(int j = 0 ; j < nbcolone ; j++)
                    		{
                    			if(jCurrentLabel == mesFleurs[i][j])
                    			{
                                    jCurrentLabelX = i;
                                    jCurrentLabelY = j;                    				
                    			}
                    		}

                        oneKeyPresse=true;
                       
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                     
                            try {
                               
                            	if(enterLabel.getIcon()==blanc)
                            	{                            		
	                            	enterLabel.setIcon(jCurrentLabel.getIcon());  
	                            	enterLabel.setText(jCurrentLabel.getText());
	                                jCurrentLabel.setIcon(blanc);
	                                jCurrentLabel.setText("");
	                                jCurrentLabel=null;
	                                jardinHasChanged =true;
	                              // jardin.deplacer_Fleur(fleur, coordonnees)
	                            	for(int i = 0 ; i < nbligne; i++ )
	                            		for(int j = 0 ; j < nbcolone ; j++)
	                            		{
	                            			if(enterLabel == mesFleurs[i][j])
	                            			{
	                            				enterLabelX = i;
	                            				enterLabelY = j; 
	                            				break;
	                            			}
	                            		}	                            	
	                            	jardin.deplacer_Fleur(jardin.getFleur(jardin.getCoordonnes(jCurrentLabelX, jCurrentLabelY)),new  Coordonnees(enterLabelX,enterLabelY)); 
	                            	
                            	}
                            } catch (Exception ex) {
                            }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        enterLabel =(JLabel) e.getSource();                       
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                
                panelFleurs[i][j].add(mesFleurs[i][j]);
                panelFleurs[i][j].setSize(10,10);
                
              
                if ((i + j) % 2 == 0) {
                      panelFleurs[i][j].setBackground(Color.WHITE);
                      panelFleurs[i][j].setBorder(new TitledBorder(""));
                      
                }
                else {
                     panelFleurs[i][j].setBackground(Color.white);
                      panelFleurs[i][j].setBorder(new TitledBorder(""));
                }
                panelJardin.add(panelFleurs[i][j]);
                this.validate();
             
            }
            
        }

    }

 
public static void main(String[] args) {
        
        FenetreJardin fenetre=new FenetreJardin(8,8);
        fenetre.setSize(1350, 650);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        
       
 }




/***Gestion de l'espace formule***/

     private int i = 0 ;
     private String text ="";
     
    //creation du pannel contenant l'espace
     private int currentPosition = 0;
     
    private JPanel GFormule;   

    private JPanel zoneFormule;
    private JButton ajout;
    private JCheckBox[] zSelect ; 
    //creation de l'espace d'edition
    
    private JTextField[] zoneSaisie;   
    private JLabel[] resultSaisie;
    private boolean[] hasBeenModified;
    private JTextField currentTextField;
    private IFormules formules = new Formules();
    
    private IFormule[] formule;
    
   
     private JPanel zoneButton;
    private JPanel zoneLauncher;
    private JButton[] jLauncher;
    String[]btnOperations = {"Analyser","Evaluer","Supprimer","Tout"};
    String []especeFleur = {"Rose","Tulipe","Paquerette"};

   
    
    private javax.swing.JTabbedPane zoneSaisieAut;
    //panel espece
    private JPanel f_espece;
    private JButton[] f_especes;    
    //panel taille
    private JPanel f_taille;
    private JButton[] f_tailles;
        //panel Constante
    private JPanel constante;
    private JButton[] constantes;
            //panel Variable
    private JPanel variable;
    private JButton[] variables;
    
                //panel Connecteur
    private JPanel connecteur;
    private JButton[] connecteurs;
    
                    //panel Position
    private JPanel position;
    private JButton[] positions;
    
                        //panel Couleur
    private JPanel f_couleur;
    private JButton[] f_couleurs;
     public void jLauncherActionPerformed( ActionEvent evt)
  {
      JButton ob = (JButton)evt.getSource();
	int j;
	for(i = 0; i < jLauncher.length;i++)
	{
		if(jLauncher[i]==ob)
		{                    
			switch(i)
			{
                            
				case 3:
				if(zSelect[0].isSelected())
                for(j=0; j < zSelect.length; j++) zSelect[j].setSelected(false);
				else for(j=0; j < zSelect.length; j++) zSelect[j].setSelected(true);
         
				case 2:
				for(j=0; j < zSelect.length; j++) 
					if(zSelect[0].isSelected())
						zoneSaisie[j].setText("");
				this.validate();
                                    
                break;                
				case 0:
				for(j=0; j < zoneSaisie.length; j++)
				{
					analyserSaisie(j);
				}
				//formules
				break;
                case 1:
                if(!jardin.get_Jardin().isEmpty())
                {
                    // seConnecter();
                    connexion = new Client();
                    if(connexion.seConnecter())
                    {
                    	 connexion.envoyerJardin(jardin.get_Jardin());     
                        for(j=0; j < zoneSaisie.length; j++)
                        {
                        	if(zSelect[j].isSelected())
                        	{  
                        		analyserSaisie(j);
                        		if(formule[j].isSyntOk())
                        		{                       			                 			
                        			traiterFormule(formule[j]);

                        		}

                              }

                         }
                        
                        refresh_vue();
                    	connexion.seDeconnecter();
                    }                   				
  
 
                }
                else
                {
                	//boite de dialogue
                	System.out.println("le jardin est vide!");
                }
                                
                                 for(j=0; j < formules.getFormules().size();j++)
                                 {
                                	 if(formules.get_formule(j).isCorrect())
                                	 {
                                		 resultSaisie[j].setForeground(new java.awt.Color(0, 255, 0));
                                         resultSaisie[j].setText("True");                                		 
                                	 }
                                	 else
                                	 {
                                		 if(!zoneSaisie[j].getText().isEmpty() && zSelect[j].isSelected() && formules.get_formule(j).isSyntOk())
                                		 {
                                			 resultSaisie[j].setForeground(new java.awt.Color(255, 51, 0));
                                             resultSaisie[j].setText("False");
                                		 }
                                	 }
                                 }
                                break;

			}
			break;
		}
		

	}
 
  }
     
 
	private void analyserSaisie(int j)
    {
        String temp ="";
        
       if(zSelect[j].isSelected() && !((temp=zoneSaisie[j].getText()).isEmpty()) && hasBeenModified[j])
       {

    	   
    	   	 formule[j].setCorrect(false);
             formule[j].setFormule(temp);
             formule[j].analyser();
             
                                                
             if(formule[j].isSyntOk())
             {
                resultSaisie[j].setForeground(new java.awt.Color(0 ,255, 0));              
                resultSaisie[j].setText("ok");
             }                
            else
             {
 
                resultSaisie[j].setForeground(new java.awt.Color(255, 51, 0));
                resultSaisie[j].setText("nok");
              }           
               	
              resultSaisie[j].setVisible(true);
              hasBeenModified[j] = false;
	}   
    
    }
    
      
  private void ajoutActionPerformed(ActionEvent evt)
  {
       for(i = 0 ; i < zoneSaisie.length;i++)
       {
               if(!zoneSaisie[i].isVisible())
               {
                    
                   zoneSaisie[i].setVisible(true);
                   zSelect[i].setVisible(true);
                   zSelect[i].setSelected(true);                   
                   zoneFormule.validate();
                   break; 
               }
               
       }
       if(i == zoneSaisie.length )
       {
    	   //inserer boite de dialogue
    	   System.out.println("pas au dela de 10");
       }
  }
  
   public void zoneSaisieActionPerformed(KeyEvent evt)
  {	  
      currentTextField = (JTextField)evt.getSource();
      for(i = 0; i < zoneSaisie.length;i++)
          if(zoneSaisie[i] == currentTextField)
        	  {
        	  hasBeenModified[i] = true;
        	  break;
        	  }

  }
     private void zoneSaisieActionPerformed(ActionEvent evt) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
       public void f_especesActionPerformed(ActionEvent evt)
  {
      Object ob = evt.getSource();
      
      for(i = 0 ; i < f_especes.length;i++)
      {
          if(f_especes[i]==ob)
          {
              switch(i)
              {
                  case 0:
                   text = "Rose( )";   
                      break;
                   case 1:
                   text = "Tulipe( )";   
                      break ;
                   case 2:
                   text = "Paquerette( )";   
                      break;
              }
          }
          
      }
      updateTextJField(text);  
  }
       
    private void updateTextJField(String terme)
    {
          try
      {
          currentTextField.setText(currentTextField.getText()+terme);
          currentTextField.setCaretPosition(currentTextField.getCaretPosition()-2);
          currentPosition = currentTextField.getCaretPosition();
      }
      catch(NullPointerException e)
      {}    
    }
    
         @SuppressWarnings("empty-statement")
   public void  f_taillesActionPerformed(ActionEvent evt)
   {
         Object ob = evt.getSource();
      
      for(i = 0 ; i< f_tailles.length;i++)
      {
          if(f_tailles[i]==ob)
          {
              switch(i)
              {
                  case 0:
                   text = "est_grand( )";   
                      break;
                   case 1:
                   text = "est_moyen( )";   
                      break ;
                   case 2:
                   text = "est_petit( )";   
                      break;        
                   case 3:
                   text = "plus_grand_que( )";   
                      break;
                    case 4:
                   text = "meme_taille_que( )";   
                      break; 
                    case 5:
                   text = "plus_petit_que( )";   
                      break;                        
              }
          }
          
          
      }
     updateTextJField(text);
   }
   
    public void constantesActionPerformed(ActionEvent evt)
  {
      Object ob = evt.getSource();
      
      for(i = 0 ; i< constantes.length;i++)
      {
          if(constantes[i]==ob)
          {
              switch(i)
              {
                  case 0:
                   text = "a";   
                      break;
                   case 1:
                   text = "b";   
                      break ;
                   case 2:
                   text = "c";   
                      break;        
                   case 3:
                   text = "d";   
                      break;
                    case 4:
                   text = "e";   
                      break; 
                    case 5:
                   text = "f";   
                      break;
                   case 6:
                   text = "g";   
                      break;
                    case 7:
                   text = "h";   
                      break; 
                    case 8:
                   text = "i";   
                      break;
                   case 9:
                   text = "j";   
                      break;
                    case 10:
                   text = "k";   
                      break; 
                    case 11:
                   text = "l";   
                      break; 
                   case 12:
                   text = "m";   
                      break;
                    case 13:
                   text = "n";   
                      break; 
                    case 14:
                   text = "o";   
                      break; 
                    case 15:
                   text = "p";   
                      break; 
                   case 16:
                   text = "q";   
                      break;
                    case 17:
                   text = "r";   
                      break; 
                    case 18:
                   text = "s";   
                      break; 
                    case 19:
                   text = "t";   
                      break;                      
              }
          }
          
      }
      try
      {
          insererTerme(text);
      }
      catch(NullPointerException e)
      {}
  }
    
      public void variablesActionPerformed(ActionEvent evt)
   {
                 Object ob = evt.getSource();
      
      for(i = 0 ; i< variables.length;i++)
      {
          if(variables[i]==ob)
          {
              switch(i)
              {
                  case 0:
                   text = "v";   
                      break;
                   case 1:
                   text = "w";   
                      break ;
                   case 2:
                   text = "x";   
                      break;        
                   case 3:
                   text = "y";   
                      break;
                    case 4:
                   text = "z";   
                      break;                        
              }
          }
          
      }
      try
      {
         insererTerme(text);
      }
      catch(NullPointerException e)
      {}  
   }
      void   saveJActionPerformed(ActionEvent evt)
      {
   	   String pathFile = SaveFromFile(this, "Enregistrer un fichier ...", ".\\", "*.jdn");
   	   
   		/*afficher une boite de dialogue*/
   		try {
   			OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream(pathFile));
   			String s;
   			wr.write(jardin.get_Jardin());
   			wr.flush();
   			wr.close();
   		} catch (FileNotFoundException e) {
   			
   		} catch (IOException e) {

   		}
      }
      void   loadJActionPerformed(ActionEvent evt)
      {
   	   File pathFile = LoadFromFile(this, "Ouvrir un fichier ...", ".\\", "jdn");
   	  
   	   String s;
   	   
   	   try {
   		InputStreamLiner rd = new InputStreamLiner(new FileInputStream(pathFile));		
   		int i = 0,x,y;
   		while((s = rd.readLineWin())!=null && !s.isEmpty())
   		{
			String[] sn = s.split(":");
			for(i = 0; i < sn.length && !sn[i].isEmpty();i++)
			{
   			  				
   				
   				s.split(",");
   				while(i<8){
   					//x,y,espece,taille,couleur,nom
   					x=Integer.parseInt(s.valueOf(0));
   					y=Integer.parseInt(s.valueOf(1));
   					
   					switch (s.valueOf(2)) {
   					case "rose":
   						espece=0;
   						break;
   					case "paquerette":
   						espece=1;
   						break;
   					case "tulipe":
   						espece=2;
   						break;
   					default:
   						break;
   					}
   					switch (s.valueOf(3)) {
   					case "petite":
   						taille=0;
   						break;
   					case "moyenne":
   						taille=1;
   						break;
   					case "grande":
   						taille=2;
   						break;
   					default:
   						break;
   					}
   					
   					switch (s.valueOf(4)) {
   					case "rose":
   						couleur=0;
   						break;
   					case "rouge":
   						couleur=1;
   						break;
   					case "blanche":
   						couleur=2;
   						break;
   					default:
   						break;
   					}
   					
   					ajouterFleur(x, y, espece, couleur, taille, nom);
   				
   					i++;
   				}
			}
   		}
   		this.validate();
   	} catch (IOException e) {
   		// TODO Auto-generated catch block
   		
   	}
   	   
   	   
   	   
      } 
      
      
   void   saveFActionPerformed(ActionEvent evt)
   {
	   String pathFile = SaveFromFile(this, "Enregistrer un fichier ...", ".\\", "*.fml");
	  
		/*afficher une boite de dialogue*/
		try {
			OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream(pathFile));
			String s;
			for(int i = 0 ; i < zoneSaisie.length;i++)
			{
				if(( s=zoneSaisie[i].getText())!=null)
				{
					wr.write(s+'\n');					
				}
				wr.flush();
			}
			wr.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {

		}
   }
   void   loadFActionPerformed(ActionEvent evt)
   {
	   File pathFile = LoadFromFile(this, "Ouvrir un fichier ...", ".\\", "fml");
	   
	   String s;
	   
	   try {
		InputStreamLiner rd = new InputStreamLiner(new FileInputStream(pathFile));		
		int i = 0;
		while((s = rd.readLineWin())!=null && !s.isEmpty())
		{
			String[] sn = s.split("\n");
			for(i = 0; i < sn.length && !sn[i].isEmpty();i++)
			{
				
				zoneSaisie[i].setText(sn[i]);
				zoneSaisie[i].setVisible(true);
				zSelect[i].setVisible(true);
				zSelect[i].setSelected(true);				
			}
		
		}
		rd.close();
		this.validate();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		
	}
	   
	   
	   
   }
   public void  connecteursActionPerformed(ActionEvent evt)
     {
     Object ob = evt.getSource();
      
      for(i = 0 ; i< connecteurs.length;i++)
      {
          if(connecteurs[i]==ob)
          {
              switch(i)
              {
                  case 0:
                   text = "∀";   
                      break;
                   case 1:
                   text = "∃";   
                      break ;
                   case 2:
                   text = "¬";   
                      break;        
                   case 3:
                   text = "=";   
                      break;
                    case 4:
                   text = "∨";   
                      break; 
                    case 5:
                   text = "∧";   
                      break;
                   case 6:
                   text = "⇒";   
                      break;
                    case 7:
                   text = "(";   
                      break; 
                    case 8:
                   text = ")";   
                      break;
              }
          }
          
      }
      insererTerme(text);      
     
}
   
          public void     positionsActionPerformed(ActionEvent evt)
       {
        Object ob = evt.getSource();
      
      for(i = 0 ; i< positions.length;i++)
      {
          if(positions[i]==ob)
          {
              switch(i)
              {
                  case 0:
                   text = "a_l_est( )";   
                      break;
                   case 1:
                   text = "a_l_ouest( )";   
                      break ;
                   case 2:
                   text = "au_nord( )";   
                      break;        
                   case 3:
                   text = "au_sud( )";   
                      break;
                    case 4:
                   text = "a_l_est_de( )";   
                      break; 
                    case 5:
                   text = "a_l_ouest_de( )";   
                      break;
                   case 6:
                   text = "au_nord_de( )";   
                      break;
                    case 7:
                   text = "au_sud_de( )";   
                      break; 
                    case 8:
                   text = "meme_latitude_que( )";   
                      break;
                    case 9:
                   text = "meme_longitude_que( )";   
                      break;
              }
          }
       
    
 }
       updateTextJField(text);
}
          
          
public void f_couleursActionPerformed(ActionEvent evt)
 {
            Object ob = evt.getSource();
      
      for(i = 0 ; i< f_couleurs.length;i++)
      {
          if(f_couleurs[i]==ob)
          {
              switch(i)
              {
                  case 0:
                   text = "est_rose( )";   
                      break;
                   case 1:
                   text = "est_rouge( )";   
                      break ;
                   case 2:
                   text = "est_blanc( )";   
                      break;        
                   case 3:
                   text = "meme_couleur_que( )";   

              }
          }
       
       
 }
 }         
private void insererTerme(String terme)
    {

		int pos = currentTextField.getCaretPosition();
		 String temp= currentTextField.getText();
		 String newText ="";
		 
		 for(i = 0 ; i < pos ; i++)
		 {
			 newText+=temp.charAt(i);//ajout à la position indiquée
		 }
		newText += terme;
		
		for(i = pos; i < temp.length();i++)
			newText+=temp.charAt(i);
		
		currentTextField.setText(newText);
		currentTextField.setCaretPosition(pos+terme.length());
    }

private	void traiterFormule(IFormule f)
	{
		String s;		
		if(f.isSyntOk())
		{
			connexion.envoyerFormule(f.arbreToString());
			s= connexion.recevoirReponse();			
			
			if(s.trim().compareTo("ok")==0)
			{				
				f.setCorrect(true);
			}
			else f.setCorrect(false);
		}		
	}
	
	void refresh_vue()
	{
		for(int i = 0; i < formule.length;i++)
		{
			if(zSelect[i].isSelected() && !zoneSaisie[i].getText().isEmpty())
			{
				if(formule[i].isCorrect())
				{
					resultSaisie[i].setText("True");
				}
				else if (formule[i].isSyntOk())resultSaisie[i].setText("False");
				else resultSaisie[i].setText("nok");
					
			}
		}
		this.validate();
		
	}
	
    private File LoadFromFile(Frame _frame, String _title, String _path, String _fileFilter) {
    	File myFilename;
    	JFileChooser chooser = new JFileChooser();
    	chooser.setCurrentDirectory(new File("."));
    	chooser.addChoosableFileFilter(new OpenFileFilter(_fileFilter,"Format "+_fileFilter) );

    	int returnVal = chooser.showSaveDialog(_frame);
    	if (returnVal == JFileChooser.APPROVE_OPTION) {
    	     myFilename = chooser.getSelectedFile();
    	     return myFilename;
    	}
    	
    	return null;
        
    }
    
    public String SaveFromFile(Frame _frame, String _title, String _path, String _fileFilter) {
        FileDialog fileDialog = new FileDialog(_frame, _title, FileDialog.SAVE);
        fileDialog.setFile(_fileFilter);
        fileDialog.setDirectory(_path);
        fileDialog.setLocation(50, 50);
        fileDialog.setDirectory(_path);
        fileDialog.setVisible(true);
        return fileDialog.getDirectory() + fileDialog.getFile();
    }
 
}

