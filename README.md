# Mediscreen
Web application to save patient information, consult it, modify it if necessary. Then add the patients' medical records and finally obtain the patients' level of diabetes risk based on criteria determined by medical experts.


[![forthebadge](https://forthebadge.com/images/badges/open-source.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) 
![uses-spring-boot (2)](https://user-images.githubusercontent.com/66125882/150993441-590505b7-fd53-44df-9ac5-695d0fb59754.svg)
![uses-eclipse-ide (1)](https://user-images.githubusercontent.com/66125882/150993531-3f8d450c-0399-4c9f-920c-4296d0473f2d.svg)

# TourGuide
Api permettant aux voyageurs d'obtenir des offres de voyages personnalisés et des points de récompense pour les attractions touristiques visités. 

## Pour commencer:
- Créer un répertoire de travail "Workdir" par exemple -> mkdir Workdir
- Se placer dans ce répertoire -> cd Workdir
- Initialiser un depot local git -> git init
- Cloner la branche Release dans ce dossier -> git clone https://github.com/aurelien-ndjamba/TourGuide.git

## Démarrage:
1. Packager le microservice gpsutil: 
- Se placer à la racine du microservice -> cd TourGuide/gpsutil
- mvn package
- docker build -t gpsutil 
2. Packager le microservice rewardcentral: 
- Se placer à la racine du microservice -> cd TourGuide/rewards
- mvn package
- docker build -t rewardcentral .
3. Packager le microservice trippricer: 
- Se placer à la racine du microservice -> cd TourGuide/trippricer
- mvn package
- docker build -t trippricer .
3. Packager le microservice tourguide: 
- Se placer à la racine du microservice -> cd TourGuide/tourguide
- mvn package -DskipTests
- docker build -t tourguide .
4. Lancer docker-compose: 
- Se placer à la racine du projet -> cd TourGuide
- docker-compose up -d

## Technologies
1. Framework: Spring Boot v2.6.5
2. Java v1.8.0_321
3. Junit v5.3.2
4. Jacoco v0.8.4
5. Maven v3.0
6. Eclipe IDE Version: 2020-09 v4.17.0
7. Docker v20.10.12
8. Docker-compose v1.29.2

## Version
tourguide_0.0.1

## Autheur
- Aurélien NDJAMBA

## License

