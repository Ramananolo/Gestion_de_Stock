FROM maven:3.8.6-openjdk-17 AS build
COPY . .
RUN mvn clean package -OskipTests

FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bonarson_spring_boot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/bonarson_spring_boot-0.0.1-SNAPSHOT.jar"]