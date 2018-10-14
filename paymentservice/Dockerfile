FROM java:8-jre

COPY ./target/paymentservice-0.0.1-SNAPSHOT.jar /usr/app/src/paymentservice-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/src

ENTRYPOINT ["java","-jar", "paymentservice-0.0.1-SNAPSHOT.jar"]
