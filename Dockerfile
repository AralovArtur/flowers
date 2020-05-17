FROM openjdk:8-jdk-alpine
MAINTAINER com.artur
VOLUME /tmp
EXPOSE 8086
ADD target/flowers.jar flowers.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/flowers.jar"]