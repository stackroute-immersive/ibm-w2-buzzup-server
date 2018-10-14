FROM java:8-jre

COPY ./target/user-profile-0.0.1-SNAPSHOT.jar /usr/app/src/user-profile-0.0.1-SNAPSHOT.jar

WORKDIR usr/app/src

ENTRYPOINT ["java","-jar", "user-profile-0.0.1-SNAPSHOT.jar"]
