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

#6 durabilité épée

La durabilité de l'épée change car lorsqu'elle est passée en paramêtre elle est passée par
référence et non pas valeur, c'est donc l'épée de départ qui est utilisée et pas une copie.

#TP3

4.2 : compute protection est une méthode abstraite, ce qui veut dire qu'elle doit être implémenté par toute les
classes filles de Character, hors elle n'est pas encore implémenté dans Hero ou Monster.

#TP4

3.3 Lors de l'itération d'un HashSet l'ordre n'est pas garanti et peut changer au cours du temps.

3.4 LinkedHashSet diffère d'un HashSet car elle conserve l'ordre du set. Lors d'itérations l'ordre sera
toujours celui que l'on a défini.
