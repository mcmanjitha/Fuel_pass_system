FROM openjdk:21-jdk-slim
VOLUME /tmp
EXPOSE 8089
ARG JAR_FILE=target/mtd-integration-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
