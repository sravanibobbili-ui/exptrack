# Use an OpenJDK base image
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

EXPOSE 8080

# Copy the Spring Boot application JAR file into the container
ADD target/spring-boot-3.1.0.jar /app

# Specify the command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "spring-boot-3.1.0.jar"]
