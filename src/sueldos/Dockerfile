FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-sueldos.jar
ENTRYPOINT ["java","-jar","/ms-sueldos.jar"]