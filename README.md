# RentmanagerJava
BENOIT Marion
marion.benoit@epfedu.fr



Etat actuel du projet :

Tous les boutnons (ajouter, détails, modifier et supprimer) fonctionnent pour clients, véhicules et réservations.
Il n'y a pas de bouton détail pour réservations car je ne trouve pas ça utile.
L'affichage du nombre de clients, voitures et réservations se met bien à jour.
Par contre il n'y a pas de contraintes (comme avoir plus de 18 anns pour s'inscrire) ni de tests par manque de temps.



Les difficultés rencontrés :

- Beaucoup de bugs dû à des erreurs de nommages ou de frappes (oublie d'espace, de s, de majuscule, etc...) qui m'ont fait perdre pas mal de temps pour les trouver à chaque fois.

- Plusieurs erreur dans le jsp dû à peu de connasissance dans ce langage, ainsi je faisait facilement des erreurs dans le placement de mes balises ou dans leur nommage par exemple.

- Un bug dont l'origine à été difficile à trouver fût que ma fonction delete ne marchait pas. 
Malgrès un long temps de recherche de ma part mais aussi avec l'aide du regard extérieur d'une amie, impossible d'en trouver l'origine.
Le bug étant d'écrit comme un problème de sql par le debogage, cela me rendait encore plus confuse car je n'avais pas touché à la partie sql.
Au final la solution s'est avéré être de run à nouveau la fillDatabase.
Je pense que celle-ci avait été corrompu par l'ajout d'un client sans nom, créé lors de la réalisation et du débogage de la fonction création. 

- Un bug au niveau de la réservation faisait que je pouvais créer une nouvelle réservation avec les voitures et clients déjà présents par défaut dans la database mais pas avec des voitures ou clients que j'avais créé depuis le site ou le main.
Après recherche, il s'est avéré que cela été dû au fait qu'au moment de l'enregistrement d'une nouvelle réservation, j'échangeais la place de l'id du véhicle et celle de l'id du client dans la réervation.
