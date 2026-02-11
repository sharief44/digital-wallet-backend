# -------- STAGE 1: Build the application --------
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


# -------- STAGE 2: Run the application --------
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy only the built jar from builder stage
COPY --from=builder /app/target/wallet-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
