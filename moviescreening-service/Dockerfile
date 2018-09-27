FROM java:8-jre
MAINTAINER UTKARSH <mksinha006@gmail.com>
COPY ./target/movie-screening-service-0.0.1-SNAPSHOT.jar /usr/app/src/movie-screening-service-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "movie-screening-service-0.0.1-SNAPSHOT.jar"]