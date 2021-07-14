FROM openjdk:8-jdk-alpine
ENV DB_URL='jdbc:h2:tcp://h2db:1521/jobposting'
COPY . /usr/src/app
WORKDIR /usr/src/app
ENTRYPOINT ["java","-jar","jobposting-0.0.1-SNAPSHOT.jar"]

