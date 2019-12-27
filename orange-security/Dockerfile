FROM openjdk:8-jre-alpine

VOLUME /tem

WORKDIR /usr/local/src/boot

EXPOSE 40008

ADD target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]