# Use official OpenJDK 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven build files
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Download dependencies (caches better)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Expose Render default port
EXPOSE 8080

# Run Spring Boot app
ENTRYPOINT ["java","-jar","target/library-management-0.0.1-SNAPSHOT.jar"]
