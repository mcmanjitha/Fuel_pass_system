# Use an OpenJDK image with Java 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/motor-traffic-service-0.0.1-SNAPSHOT.jar /app/motor-traffic-service.jar

# Expose the port for the motor traffic service
EXPOSE 8083

# Run the JAR file
ENTRYPOINT ["java", "-jar", "motor-traffic-service.jar"]
