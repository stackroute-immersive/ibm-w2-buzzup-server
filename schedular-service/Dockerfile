FROM java:8-jre

COPY ./target/schedular-service-0.0.1-SNAPSHOT.jar /usr/app/src/schedular-service-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "schedular-service-0.0.1-SNAPSHOT.jar"]
