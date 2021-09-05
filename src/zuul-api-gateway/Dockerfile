FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} zuul-api-gateway.jar
ENTRYPOINT ["java","-jar","/zuul-api-gateway.jar"]