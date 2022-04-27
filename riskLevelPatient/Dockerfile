FROM openjdk:8-jre-alpine3.9

ADD ./target/riskLevelPatient-0.0.1-SNAPSHOT.jar /app/
ADD ./target/classes/triggers.txt /app/triggers.txt

WORKDIR /app/

EXPOSE 9004
VOLUME /app/logs

CMD java -jar riskLevelPatient-0.0.1-SNAPSHOT.jar
