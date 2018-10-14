FROM java:8-jre

COPY ./target/ticketingengine-service-0.0.1-SNAPSHOT.jar /usr/app/src/ticketingengine-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/app/src

ENTRYPOINT ["java","-jar", "ticketingengine-service-0.0.1-SNAPSHOT.jar"]
