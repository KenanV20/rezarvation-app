# Build stage
FROM openjdk:17-jdk as build

WORKDIR /app

# Install wget, unzip, and other necessary tools
RUN apt-get update && apt-get install -y wget unzip

# Download and install Gradle
RUN wget https://services.gradle.org/distributions/gradle-7.3-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-*.zip && \
    rm -rf /tmp/gradle-*.zip

ENV GRADLE_HOME /opt/gradle/gradle-7.3
ENV PATH $GRADLE_HOME/bin:$PATH

COPY . .

RUN gradle build --no-daemon

# Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/build/libs/rezervationapp.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
