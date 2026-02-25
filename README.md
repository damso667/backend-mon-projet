# ProjetApiBts - Backend de Gestion de Laboratoire d'Analyses Médicales

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)

Ce projet est une API REST robuste développée avec **Spring Boot**, conçue pour la gestion complète d'un laboratoire d'analyses médicales. Il gère l'ensemble du flux métier, allant de l'enregistrement des patients à la validation des analyses par les médecins, en passant par la gestion des techniciens, des réactifs et la facturation.

---

##  Fonctionnalités Principales

-  **Authentification & Sécurité** : Système de connexion sécurisé basé sur JWT (JSON Web Tokens) avec gestion des rôles (Médecin, Technicien, Secrétaire, etc.).
-  **Gestion des Utilisateurs** :
  - **Patients** : Inscription et suivi de dossier.
  - **Médecins** : Validation et supervision des analyses.
  - **Techniciens** : Réalisation des analyses et gestion des échantillons.
  - **Secrétaires** : Gestion administrative et tickets de caisse.
- **Gestion des Analyses & Prélèvements** : Suivi des types d'examens, des prélèvements liés aux patients et de leur état d'avancement.
-  **Gestion des Stocks (Réactifs)** : Suivi des réactifs utilisés lors des analyses afin de maîtriser les stocks disponibles.
-  **Notifications** : Système d'envoi d'e-mails automatiques (ex. lorsqu'un médecin valide une analyse).

---

##  Stack Technique

- **Langage** : Java 17
- **Framework Principal** : Spring Boot
- **Base de données** : MySQL via Spring Data JPA et Hibernate
- **Sécurité** : Spring Security & JWT (JSON Web Token)
- **Mailing** : Spring Boot Starter Mail
- **Template Engine** : Thymeleaf (utilisé notamment pour la génération de mails ou pages d'erreurs)
- **Outils de Build** : Maven
- **Conteneurisation** : Docker

---

##  Installation & Exécution Locale

###  Prérequis

Vous devez avoir installé sur votre poste de travail :

- [Java Development Kit (JDK) 17](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://www.mysql.com/) (si exécution en local sans Docker)
- _Optionnel:_ [Docker](https://www.docker.com/)

###  Démarrage classique (Maven)

1. **Cloner le repository** (ou télécharger les sources) :

   ```bash
   git clone <url-du-repo>
   cd ProjetApiBts
   ```

2. **Configurer la base de données** :
   Modifiez le fichier de configuration `src/main/resources/application.properties` (ou `.yml`) pour y insérer vos identifiants MySQL :

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/votre_base_de_donnees
   spring.datasource.username=votre_utilisateur
   spring.datasource.password=votre_mot_de_passe
   ```

3. **Compiler et lancer avec Maven** :
   ```bash
   ./mvnw clean package -DskipTests
   ./mvnw spring-boot:run
   ```
   L'API sera accessible sur `http://localhost:8080`.

###  Démarrage avec Docker

1. **Générer le package Maven** :

   ```bash
   ./mvnw clean package -DskipTests
   ```

2. **Construire l'image Docker** :

   ```bash
   docker build -t backend-api-bts .
   ```

3. **Lancer le conteneur** :
   ```bash
   docker run -p 8080:8080 -d backend-api-bts
   ```
   L'API sera accessible sur `http://localhost:8080`.

---

##  Structure du Projet

```text
src/main/java/com/example/ProjetApiBts/
├── config/        # Configuration globale (Sécurité, Beans)
├── controller/    # Les contrôleurs REST exposant l'API (end-points)
├── dto/           # Data Transfer Objects pour manipuler et filtrer la donnée en I/O
├── enums/         # Enumérations (rôles, statuts des analyses)
├── error/         # Gestion globale des exceptions (ControllerAdvice)
├── models/        # Les entités JPA reflétant le schéma de la base de données
├── repository/    # Interfaces Spring Data JPA pour les requêtes BDD
├── service/       # La logique métier (Authentification, Analyses, Mails...)
└── shared/        # Utilitaires ou composants partagés
```

---

##  Contribution

1. Forkez le projet
2. Créez votre branche de fonctionnalité (`git checkout -b feature/IncroyableFonctionnalite`)
3. Commitez vos modifications (`git commit -m "Ajout d'une fonctionnalité"`)
4. Poussez vers la branche (`git push origin feature/IncroyableFonctionnalite`)
5. Ouvrez une Pull Request

---

