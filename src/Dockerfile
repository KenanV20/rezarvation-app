# Start with the ubuntu image for building
FROM ubuntu:latest AS build

# Install OpenJDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Copy the application files
COPY . .

# Build the application
RUN ./gradlew bootJar --no-daemon

# Switch to the openjdk:17-jdk-slim image for the final image
FROM openjdk:17-jdk-slim

# Expose the port if needed (assuming your Spring Boot app runs on 8080)
EXPOSE 8080

# Copy the built JAR file from the build image
COPY --from=build /path/to/your/app/build/libs/rezarvation-app-1.jar /app.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
