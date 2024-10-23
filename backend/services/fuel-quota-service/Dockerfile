FROM openjdk:21-jdk-slim
VOLUME /tmp
EXPOSE 8085
ARG JAR_FILE=target/fuel-quota-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
]