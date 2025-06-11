
### **TP Noté – Microservices : Poste et Compétences**

#### **Durée :** 4 heures

#### **Environnement :** Spring Boot (dernière LTS), Java 17

----------

## **Contexte et Objectifs**

L'objectif est de mettre en œuvre une architecture micro-services pour modéliser un outil de gestion de **Poste** (emploi) et les **Compétences** qui sont liées à ce dernier

-   Concevoir et implémenter deux micro-services indépendants.
-   Utiliser **Feign** pour assurer la communication entre services.
-   Appliquer les **bonnes pratiques** de développement.
-   Sécuriser les échanges interservices avec **Resilience4J**.
-   Mettre en place une architecture complète avec un **Discovery Service**, un **API Gateway** et un service de **configuration dynamique**.
-   Conteneuriser l'ensemble avec **Docker** et orchestrer le déploiement via **Docker Compose**. (bonus)

----------

## **Consignes Générales**

-   Tous les documents et outils sont autorisés.
-   **Le partage de code source entre étudiants est interdit.**
-   Le projet devra être documenté avec un README détaillé.

----------

## **Étapes du TP**

### **1. Implémentation des Microservices** (7 points)

#### **Microservice Poste**

-   Chaque Poste possède :
    -   Un identifiant (String) qui sera l'acronyme du poste (CTO / PDG / ...)
	- 	Un nom (String)
	- 	Une liste de **Compétences**. Vous aurez besoin l'annotation **@ElementCollection** pour modéliser cette relation.

#### **Microservice Competence**

-   Une **Compétence** est constituée de :
	- 	Un identifiant (Long)
	- 	Un nom (String)
----------

### **2. Communication entre Microservices avec Feign** (3 points)

-   Mettez **Feign** en place et utilisez le afin de proposer les endpoints suivants :

### Poste  
- **GET** `/postes` : Liste tous les **Postes**.  
- **GET** `/poste/{id}` : Retourne un **Poste** et les **Compétences** qui lui sont liées.

### Compétence  
- **GET** `/skills` : Liste toutes les **Compétences**.  
- **GET** `/skill/{id}` : Retourne une **Compétence** et les **Postes** qui necessite cette dernière.

Soyez prudent et réfléchissez bien avant de vous lancer dans la réalisation de cette partie, n'hésitez pas à abandonner certains objectifs pour passer à la suite si vous ne parvenez pas à réaliser tout ce qui est demandé.

----------

### **3. Application des Bonnes Pratiques** (3 points)

-   Découpler la logique métier via **interfaces de services**.
-   Utiliser **DTO et Mappers** pour séparer modèle et exposition.

----------

### **4. Mise en Place du Service de Discovery** (1.5 point)

-   Installer et configurer **Eureka Server** pour l'enregistrement dynamique des services.

----------

### **5. Mise en Place du Gateway API** (1.5 points)

-   Configurer **Spring Cloud Gateway** pour assurer la gestion des routes dynamiques.

----------

### **6. Sécurisation des Communications avec Resilience4J** (2 points)

-   Intégrer **Resilience4J** pour améliorer la tolérance aux pannes dès lors qu'un service communique avec un autre service.

----------

### **7. Service de Configuration Dynamique** (2 points)

-   Mettre en place **Spring Cloud Config Server** pour gérer les configurations centralisées.
-   Activer **Spring Boot Actuator** pour la mise à jour à chaud des configurations.

----------

### **8. Conteneurisation avec Docker et Orchestration avec Docker Compose (BONUS)** (2 points)

-   Rédiger les **Dockerfiles** pour chaque service.
-   Créer un fichier **docker-compose.yml** pour orchestrer le déploiement.

----------

### **9. Documentation et Rendu**

-   Fournir un **README complet** détaillant :
    -   L'architecture mise en place.
    -   Les endpoints des services.
    -   Les commandes pour exécuter le projet.
    -   Des tests (collection Postman ou autre) pour les différents point d'entrée & la mise à jour de configuration à chaud.
-   Pousser le projet sur un repository GitHub suivant : https://classroom.github.com/a/z0jGAuWp
- :warning:**ATTENTION**:warning: : Le dépôt ferme à 13h00, aucun retard ne sera accepté, il est de votre responsabilité de ne pas vous retrouver au dernier moment avec un problème d'envoi de votre code sur le Git. 
:warning:**PRENEZ LE TEMPS DES LE DEBUT DU PROJET DE METTRE EN PLACE VOTRE VERSIONING PROPREMENT**:warning: