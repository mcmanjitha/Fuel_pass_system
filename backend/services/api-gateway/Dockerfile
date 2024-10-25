# Use an OpenJDK image with Java 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

# Expose the port for the API Gateway
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
