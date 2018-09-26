FROM java:8-jre

COPY ./target/user-profile-1.0.0.jar /usr/app/src/user-profile-1.0.0.jar
WORKDIR /usr/app/src
ENTRYPOINT ["java","-jar", "user-profile-1.0.0.jar"]
