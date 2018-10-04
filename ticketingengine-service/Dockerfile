FROM java:8-jre

ADD ./target/ticketingengine-0.0.1-SNAPSHOT.jar /usr/src/ticketingengine-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "ticketingengine-0.0.1-SNAPSHOT.jar"]

