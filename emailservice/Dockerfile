FROM java:8-jre

COPY ./target/emailservice-0.0.1-SNAPSHOT.jar /usr/app/src/emailservice-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "emailservice-0.0.1-SNAPSHOT.jar"]
