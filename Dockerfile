FROM openjdk:8-alpine3.9

MAINTAINER crack_byte

WORKDIR /app
COPY . .

RUN ./mvnw clean package

#COPY target/app.jar app.jar

ENTRYPOINT java -Dfile.encoding=UTF-8  -jar target/app.jar