FROM openjdk:8-jre-alpine

LABEL author="Batuhan Çam"

MAINTAINER batuc06@gmail.com

ARG PACKAGED_JAR=service-three.jar

ADD ${PACKAGED_JAR} mcy-sb-devtools-docker.jar

ENTRYPOINT ["java","-jar","-Xdebug","-Xrunjdwp:server=y,transport=dt_socket,address=8003,suspend=n","/mcy-sb-devtools-docker.jar"]

EXPOSE 8086:8086
EXPOSE 8003:8003
