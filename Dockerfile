#!/bin/bash
FROM openjdk:8-jdk-alpine
COPY . /usr/src/app
WORKDIR /usr/src/app
ENTRYPOINT ["java","-jar","jobposting-0.0.1-SNAPSHOT.jar"]

