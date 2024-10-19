# Use an OpenJDK image with Java 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/vehicle-service-0.0.1-SNAPSHOT.jar /app/vehicle-service.jar

# Expose the port for the vehicle service
EXPOSE 8082

# Run the JAR file
ENTRYPOINT ["java", "-jar", "vehicle-service.jar"]
