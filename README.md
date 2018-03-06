# JAVA_TP_DARKSOULS
TP java darksouls


#6 Package lsg

L'appel direct à isAlive() fonctionne lorsque la méthode est en public ou en friendly
Afin de restreindre au maximum l'accès à cette méthode nous devons la mettre en friendly
Car nous devons communiquer seulement au sein du même  package.

#7 Packages

La visibilité optimale est public dans ce cas, c'est la seule permettant l'accès à isAlive() depuis l'exterieur

Début TP2

Il faut passer les attributs des character en protected car ils doivent être visibles aux classes filles