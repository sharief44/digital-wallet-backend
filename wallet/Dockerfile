# Use Java 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy everything
COPY . .

# Give permission to mvnw (VERY IMPORTANT for Linux)
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Start Spring Boot
CMD ["java", "-jar", "target/*.jar"]
