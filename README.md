<img src="https://lylemi-projet-al04.s3.eu-west-3.amazonaws.com/image-logo/le-logo-noir.png">

Le projet Lyl'Emi Sugar and Salt est une application qui permet de trouver des recettes de cuisine.
Cette application est un regroupement de recettes venant de différents sites de recettes de cuisine.
Pour le moment il s'agit des sites *marmiton.org* et *750g.com*.
Ce projet a été construit avec une architecture back-end en **Spring Boot** et front-end **Angular 9**.
Les recettes scrapées en **NodeJS v12** et sont stockées dans une base de données non relationnnelle **MongoDB**.
Une autre base de données **MySQL** est utilisée pour stocker des données liées à l'utilisation du site, telles que l'enregistrement de compte utilisateur ou encore les ID des recettes favorites.

Ce projet est divisé en 4 repositories GitHub:  
https://github.com/lylia0204/site_cuisine_micro-services = microservice utilisateur : enregistrement utilisateurs et ajout aux favoris
https://github.com/lylia0204/site_cuisine_micro-services-recherche  = microservice recherche de recettes
https://github.com/lylia0204/site_cuisine-angular = partie Angular  
https://github.com/lylia0204/site_cuisine_scraper = partie alimentation de la base de donnée MongoDB (scrapping des sites).

Les technologies utilisées pour le deployement sont:  
AWS S3 pour le deployement des microservices  
AWS RDS pour l'hebergement de la base de données MySql.  
AWS  

---------------------------------------------------------------------------------------------------------------------------------------
# site_cuisine_micro-services-recherche

Environnement de developpement:

**Java V8**  
**Spring Boot**  
**MAVEN** 

Procédure:

IDE **Eclipse** est trés bien pour cette partie.

Créer un dossier: (Git bash here)
```sh
$ git https://github.com/lylia0204/site_cuisine_micro-services-recherche.git
$ site_cuisine_micro-services-recherche
```
Avec le jar:
```sh
$ java -jar microservices_recherche-0.0.1-SNAPSHOT.jar
```
Importer le dossier dans votre IDE : 

PORT_EVENT : un port libre  
HOST_NAME : le même que celui utilisé pour API Node

en ligne de commande:
```sh
$ set NOM_DE_LA_VARIABLE=valeur 
```
 

```sh
$ mvn clean install package
```
Executer l'application.  

Avec le jar:
```sh
$ java -jar microservices_recherche-0.0.1-SNAPSHOT.jar
```






