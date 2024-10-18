# Use an OpenJDK image with Java 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/qr-code-service-0.0.1-SNAPSHOT.jar /app/qr-code-service.jar

# Expose the port for the QR code service
EXPOSE 8084

# Run the JAR file
ENTRYPOINT ["java", "-jar", "qr-code-service.jar"]
