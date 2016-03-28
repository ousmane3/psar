local-->serveur
git remote add origin https://github.com/ousmane3/trainning.git
git push -u origin master


serveur -->local machine

mkdir projet
cd projet
git init 
git pull -u https://github.com/ousmane3/hello.git master

modification
git status /* affiché l'etat du repository */
git add nouveaufichiermodifié
git commit --message="votre message concernant la modif"

/*envoyé cette modif sur le serveur */
git remote add origin https://github.com/ousmane3/hello.git(à executer pour la premiere fois)
git push -u origin master 
Username for 'https://github.com': "votre nom d'utilisateur git"
Password for 'https://ousmane3@github.com':"votre mot de passe"
allé dans votre compte git vous devriez voir le nouveaufichiermodifié 

/*creation de branche de travail */
git branch "nom de la nouvellebranche"

/*afficher les branches*/
git branch
/*aller dans la nouvelle branche*/
git checkout "la branche "
Basculement sur la branche 'la branche'
/*creer un fichier ou modifié un fichier existant */
git add filebranche.txt
git commit --message="filebranche"

/*merger la nouvelle branche sur la branche master*/
git checkout master
git merge "la branche a merger"
/*commiter la nouvelle vers le serveur  */
git push -u origin master /* verifier vos modif sont sur le serveur */


/*supprimer un fichier en local*/
rm file
/*valider et envoyé vos modif au serveur*/
git add file
git commit --message="modif de suppresion "
git push -u origin master


/*en cas de conflit */
git diff
/*editer pour corriger/choisir la bonne version */

/*supprimer les branches une fois terminé avec */
git branch -d nouvellebranche (/-D si vous voulez suprimer sans tenir compte de vos modif/)

/*historique de vos commit*/
git log

/*rappatrié toutes les branches sans faire de merge*/
git fetch

/*visualisation graphique */
gitk --all








