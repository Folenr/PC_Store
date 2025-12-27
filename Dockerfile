# 1. Build the app using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . .

# FIX 1: Change directory into 'demo' so Maven can find the pom.xml
WORKDIR /demo

RUN mvn clean package -DskipTests

# 2. Run the app using Java
FROM eclipse-temurin:17-jdk-alpine

# FIX 2: We must tell Docker the jar file is inside 'demo/target', not just 'target'
COPY --from=build /demo/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]