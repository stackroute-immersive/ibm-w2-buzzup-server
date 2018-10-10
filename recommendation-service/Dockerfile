FROM java:8-jre
MAINTAINER UTKARSH <mksinha006@gmail.com>
COPY ./target/recommendation-service-0.0.1-SNAPSHOT.jar /usr/app/src/recommendation-service-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "recommendation-service-0.0.1-SNAPSHOT.jar"]