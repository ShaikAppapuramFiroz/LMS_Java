# Use official OpenJDK 21 image
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Give execute permission to mvnw
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java","-jar","target/library-management-0.0.1-SNAPSHOT.jar"]
