# pull image of jdk
FROM java:8-jre
# copy jar file to docker file system
ADD ./target/ticket-engine-0.0.1-SNAPSHOT.jar /usr/app/ticket-engine-0.0.1-SNAPSHOT.jar
# java -jar <jar fileName>
WORKDIR usr/app
ENTRYPOINT ["java","-jar", "ticket-engine-0.0.1-SNAPSHOT.jar"]
EXPOSE 9079
