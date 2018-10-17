FROM java:8

RUN mkdir /src

WORKDIR /src

ADD target/eureka-server-1.1.0.jar /src/eureka-server-1.1.0.jar

EXPOSE 9090

RUN sh -c 'touch /src/eureka-server-1.1.0.jar'

ENTRYPOINT ["java","-jar","/src/eureka-server-1.1.0.jar"]
