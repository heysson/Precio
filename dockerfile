FROM openjdk:14-jdk-alpine

RUN apk add --no-cache tzdata
ENV TZ America/Bogota
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /precio-0.0.1-SNAPSHOT

RUN mkdir ./log
RUN mkdir ./config

COPY ./target/precio-0.0.1-SNAPSHOT.jar ./
COPY ./target/classes/application.properties ./config/
