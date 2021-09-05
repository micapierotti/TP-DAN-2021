FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ribbon-service.jar
ENTRYPOINT ["java","-jar","/ribbon-service.jar"]