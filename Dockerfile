FROM openjdk:17-alpine

WORKDIR /app

EXPOSE 5005:5005

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/spring-app.jar

ENTRYPOINT ["java","-jar","spring-app.jar"]