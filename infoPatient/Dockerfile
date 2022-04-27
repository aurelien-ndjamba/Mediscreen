FROM openjdk:8-jre-alpine3.9

ADD ./target/infoPatient-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/

EXPOSE 9002
VOLUME /app/logs

CMD java -jar infoPatient-0.0.1-SNAPSHOT.jar
