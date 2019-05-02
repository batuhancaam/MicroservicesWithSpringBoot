FROM openjdk:8-jre-alpine

MAINTAINER batuc06@gmail.com

ARG PACKAGED_JAR=api-gateway.jar

ADD ${PACKAGED_JAR} mcy-sb-devtools-docker.jar

ENTRYPOINT ["java","-jar","-Xdebug","-Xrunjdwp:server=y,transport=dt_socket,address=8001,suspend=n","/mcy-sb-devtools-docker.jar"]

EXPOSE 8080:8080
EXPOSE 8001:8001