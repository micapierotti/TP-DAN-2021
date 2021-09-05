FROM openjdk:11.0.7-slim
LABEL maintainer="pgm@gmail.com"
ARG JAR_FILE
ADD target/${JAR_FILE} ms-cuentacorriente.jar
RUN echo ${JAR_FILE}
ENTRYPOINT ["java","-jar","/ms-cuentacorriente.jar"]