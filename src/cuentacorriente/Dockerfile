FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-cuentacorriente.jar
ENTRYPOINT ["java","-jar","/ms-cuentacorriente.jar"]