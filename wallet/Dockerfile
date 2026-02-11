# Use Java 21 (or 20 if you prefer)
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests
s
EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]
