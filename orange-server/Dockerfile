FROM openjdk:8-jre-alpine

ADD target/*.jar app.jar

EXPOSE 40000

ENV sys_ip=193.112.143.164 \
    sys_port=40000

ENTRYPOINT ["java","-jar","/app.jar"]