# Use an OpenJDK base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/spring-boot-3.1.0.jar /app

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "spring-boot-3.1.0.jar"]
