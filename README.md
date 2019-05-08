Contenu du README

I  - Presentation de l'application web Blog
II - Installation et exécution de l'applition

I  - Presentation de l'application web Blog

Blog est une petite application web developpée en utilisant l'IDE eclipse, l'environnement java 8 et les framework spring boot version 2.1.4, Maven, Hibernate
et sa specification jpa. Elle stocke les données au moyen du SGBD MYSQL version 8.0.16. De manière générale, le projet montre comment développer un 
REST API qui réalise les opérations CRUD sur une base de données comportant des tables reliées entre elles par une relation une à plusieurs. L'utilisateur 
aura la possibité d'interagir avec l'application au moyen d'une interface graphique réalisée avec la spécification OpenAPI Swagger qui offre entre autres 
une interface permettant de tester de manière conviviale les différents services offerts par l'application.

II -Installation et exécution de l'applition

Comme prérequis il faudra disposer de la plateforme windows ou linux dans laquelle sont instalés  la jdk et jre version 1.8.0, l'IDE eclipse ou Netbeaans, 
le SGBD myql version 8.0.16, un navigateur performant tel que chrome ou mozilla firefox. Il faudra aussi disposer d'une connexion internet. Suivre 
scrupuleusement les étapes suivantes pour installer et exécuter l'application:

1- Téléchager l'application sur mon compte Github via le lien suivant: https://github.com/linuxciscoarnaud/blog.git Le fichier téléchargé aura une extension
   .zip. il faudra donc le dézipper et stocker le dossier comportant l'application dans un repertoire de votre ordinateur, de préférence celui dans lequel 
   vous stockez vos applications java.
   
2- Importer le project dans votre IDE. Pour ceux utilisant l'IDE eclipse, exécuter les étapes suivantes pour importer le project:
       * Clique sur File -> Import... 
       * Dans la fenetre qui s'affiche, cliquer sur "Existing Maven Project" puis sur "Next"
       * Cliquer sur "Browse" et naviger jusqu'au dossier du projet que vous venez de dézipper. Sélectionner ce dossier, puis cliquer sur "OK"
       * Pour terminer, cliquer sur "Finish"
   Le project va se charger et les fichiers de dépendance .jar seront automatiquement téléchargés 
   
3- Dans le SGBD mysql, créer la base de données: blog_db

4- Ouvrir le fichier "application.properties" du projet qui se trouve dans le repertoire: "src/main/resources" et modifier les informations suivantes selon
   les données de connexion au SGBD mysql de votre prope installation
        spring.datasource.username=......
        spring.datasource.password=...... 
   Vous trouverz que les miennes selon mon installation du SGBD msql sont les suivantes:
        spring.datasource.username=root
        spring.datasource.password=admin 
   Vous devez absolument faire ces modifications pour que l'application puisse se connecter et créer le schéma de la base de donnée (tables, champs et relations) au 
   lancement.

5- Pour lancer l'application, exécuter les étapes suivantes: 
        * Dans l'explorateur de projets d'eclipse, repérer le projet et naviguer jusqu'au fichier "BlogApplication.java", puis y faire un clique droit
        * Dans le menu deroulant, selectionner sur "Run As", puis cliquer sur "2 Java Application" 
   Au lancement de l'application, un enrégistrement d'un post est automatiquement creé dans la base de donnée. Ce post a pour identifiant la valeur 1.
   
6- Si le test/évaluation implique qu'il faille fréquement redémarrer l'application, alors apres le premier démarrage il faudra ouvrir le fichier 
   "application.properties" qui se trouve dans le repertoire: "src/main/resources" et y faire la modification suivante:
   spring.jpa.hibernate.ddl-auto=update
   Ceci va éviter la re-création du schéma de la base de donnée à chaque redémarrage, et par conséquent la perte de données.

7- Lorsque l'application démarre sans erreurs, ouvrir un navigateur et écrire dans la barre d'adresse le lien suivant: http://localhost:8080/, puis taper sur la 
   touche "Entrer". Vous serez alors redirigés vers la page d'accueil de Swagger qui va vous afficher les differents services déjà utilisables du REST API. Bien
   vouloir se reférer au fichier "Mini_guide_d'utilisation.pdf" qui se trouve dans le dossier de l'application pour les détails d'utilisation des services sur 
   Swagger.  
   

.



