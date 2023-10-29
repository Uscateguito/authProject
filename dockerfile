# Es necesario ejecutar el comando
# mvn clean package -DskipTests
# para generar el jar

FROM openjdk:17-alpine
COPY target/AuthProjectWithJWT-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java","-jar","java-app.jar"]

###############################################

# Ejemplo de Dockerfile

## Utilizamos una imagen base
#FROM ubuntu:latest
#
## Etiqueta para identificar al mantenedor del Dockerfile
#LABEL maintainer="nombre@example.com"
#
## Variable de entorno
#ENV MY_VARIABLE=example_value
#
## Directorio de trabajo
#WORKDIR /app
#
## Copiar archivos del contexto local al contenedor
#COPY . .
#
## Ejecutar comandos para instalar paquetes o configurar el entorno
#RUN apt-get update && \
#    apt-get install -y package1 package2
#
## Puerto que el contenedor expondrá
#EXPOSE 8080
#
## Comando por defecto que se ejecuta cuando el contenedor se inicia
#CMD ["executable", "arg1", "arg2"]