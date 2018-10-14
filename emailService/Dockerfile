FROM java:8-jre

COPY ./target/emailService-0.0.1-SNAPSHOT.jar /usr/app/src/emailService-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "emailService-0.0.1-SNAPSHOT.jar"]
