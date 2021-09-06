#DENTRO DEL PROYECTO TP-DAN-2021
#A continuación se buildearán las imágenes de los microservicios para poder utilizarlas
#con Docker.

cd src
#Microservicio USUARIOS
cd usuario
./mvnw spring-boot:build-image -DskipTests=true
cd ../

#Microservicio PEDIDOS
cd pedidos
./mvnw spring-boot:build-image -DskipTests=true
cd ../

#Microservicio PRODUCTOS
cd productos
./mvnw spring-boot:build-image -DskipTests=true
cd ../

#Microservicio CUENTA CORRIENTE
cd cuentacorriente
./mvnw spring-boot:build-image -DskipTests=true
cd ../

#Microservicio API-GATEWAY
cd zuul-api-gateway
./mvnw spring-boot:build-image -DskipTests=true
cd ../

#Microservicio EUREKA
cd eureka-service
./mvnw spring-boot:build-image -DskipTests=true
cd ../

#Microservicio RIBBON
cd ribbon-service
./mvnw spring-boot:build-image -DskipTests=true
cd ../

#Microservicio SUELDOS
#cd sueldos
#./mvnw spring-boot:build-image -DskipTests=true
#cd ../

