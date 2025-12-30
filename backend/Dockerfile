FROM eclipse-temurin:23-jdk-alpine

WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew .
RUN chmod +x gradlew
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .

# Copy source code
COPY src/ src/

# Build the application
RUN ./gradlew build --no-daemon -x test

# Expose port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "build/libs/nasa-social-media-app-0.0.1-SNAPSHOT.jar"]