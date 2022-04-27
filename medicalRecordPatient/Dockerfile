FROM openjdk:8-jre-alpine3.9

ADD ./target/medicalRecordPatient-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/

EXPOSE 9003
VOLUME /app/logs

CMD java -jar medicalRecordPatient-0.0.1-SNAPSHOT.jar
