FROM java:8-jre

COPY ./target/distributor-service-0.0.1-SNAPSHOT.jar /usr/app/src/distributor-service-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "distributor-service-0.0.1-SNAPSHOT.jar"]
