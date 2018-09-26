FROM java:8-jre
MAINTAINER VIGNESH <mksinha006@gmail.com>
COPY ./target/Distributor-service-0.0.1-SNAPSHOT.jar /usr/app/src/Distributor-service-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "Distributor-service-0.0.1-SNAPSHOT.jar"]