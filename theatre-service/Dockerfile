FROM java:8-jre

COPY ./target/theatre-service-0.0.1-SNAPSHOT.jar /usr/app/src/theatre-service-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "theatre-service-0.0.1-SNAPSHOT.jar"]
