FROM java:8-jre

COPY ./target/rsvp-0.0.1-SNAPSHOT.jar /usr/app/src/rsvp-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "rsvp-0.0.1-SNAPSHOT.jar"]
