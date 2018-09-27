FROM java:8

RUN mkdir /src

WORKDIR /src

ADD target/eureka-server-1.0.0.jar /src/eureka.jar

EXPOSE 9090

RUN sh -c 'touch /src/eureka.jar'

ENTRYPOINT ["java","-jar","/src/eureka.jar"]
