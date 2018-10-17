FROM java:8-jre

COPY ./target/authentication-service-1.1.0.jar /usr/app/src/authentication-service-1.1.0.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "authentication-service-1.1.0.jar"]
