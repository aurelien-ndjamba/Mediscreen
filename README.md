[![forthebadge](https://forthebadge.com/images/badges/open-source.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) 
![uses-spring-boot (2)](https://user-images.githubusercontent.com/66125882/150993441-590505b7-fd53-44df-9ac5-695d0fb59754.svg)
![uses-eclipse-ide (1)](https://user-images.githubusercontent.com/66125882/150993531-3f8d450c-0399-4c9f-920c-4296d0473f2d.svg)

# Mediscreen
![pmb](https://user-images.githubusercontent.com/66125882/165566469-0f1590a9-170d-4ae6-95cd-a5c228aab78f.PNG)

Web application to save patient information, consult it, modify it if necessary. Then add the patients' medical records and finally obtain the patients' level of diabetes risk based on criteria determined by medical experts.

## Pour commencer:
1. Créer un répertoire de travail :
  - "Workdir" par exemple -> mkdir Workdir
2. Se placer dans ce répertoire :
  - cd Workdir
3. Initialiser un depot local git:
  - git init
4. Cloner la branche "release" dans ce dossier :
  - git clone --branch release --single-branch https://github.com/aurelien-ndjamba/Mediscreen.git

## Démarrage:
1. Packager le microservice "infoPatient" puis générer son image docker : 
- cd Mediscreen/infoPatient"
- mvn clean package
- docker build -t infopatient . 
2. Packager le microservice "medicarlRecordPatient" puis générer son image docker : 
- cd Mediscreen/medicarlRecordPatient
- mvn clean package
- docker build -t medicarlrecordpatient . 
3. Packager le microservice "riskLevelPatient" puis générer son image docker : 
- cd Mediscreen/riskLevelPatient
- mvn clean package
- docker build -t risklevelpatient . 
4. Packager le microservice "webAppPatient" puis générer son image docker : 
- cd Mediscreen/webAppPatient
- mvn clean package
- docker build -t webapp . 
5. Se placer à la racine du projet et lancer docker-compose : 
- cd Mediscreen
- docker-compose up -d
6. Se connecter à l'applicaition depuis le navigateur de votre ordinateur:
- http://localhost:9001/

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
- infoPatient_0.0.1
- medicarlRecordPatient_0.0.1
- riskLevelPatient_0.0.1
- webAppPatient_0.0.1

## Autheur
- Aurélien NDJAMBA

## License
Eclipse Public License 1.0: JUnit

Eclipse Public License v2.0: JUnit Jupiter (Aggregator), JUnit Jupiter API, JUnit Jupiter Engine, JUnit Jupiter Params, JUnit Platform Commons, JUnit Platform Engine API

Eclipse Public License v1.0: JaCoCo :: Agent, JaCoCo :: Core, JaCoCo :: Maven Plugin, JaCoCo :: Report

The MIT License: Project Lombok, mockito-core, mockito-junit-jupiter

Apache License, Version 2.0: Apache Commons Codec, Apache Commons Lang, Apache Log4j API, Apache Log4j to SLF4J Adapter, AssertJ fluent assertions, Byte Buddy (without dependencies), Byte Buddy agent, JSR 354 (Money and Currency API), Objenesis, SnakeYAML, Spring AOP, Spring Beans, Spring Commons Logging Bridge, Spring Context, Spring Core, Spring Expression Language (SpEL), Spring TestContext Framework, Spring Web, Spring Web MVC, spring-boot, spring-boot-autoconfigure, spring-boot-devtools, spring-boot-starter, spring-boot-starter-json, spring-boot-starter-logging, spring-boot-starter-test, spring-boot-starter-tomcat, spring-boot-starter-web, spring-boot-test, spring-boot-test-autoconfigure, tomcat-embed-core, tomcat-embed-el, tomcat-embed-websocket, tourguide
