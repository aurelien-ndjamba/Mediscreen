FROM openjdk:8-jre-alpine3.9

ADD ./target/webAppPatient-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/

EXPOSE 9001
VOLUME /app/logs

CMD java -jar webAppPatient-0.0.1-SNAPSHOT.jar
