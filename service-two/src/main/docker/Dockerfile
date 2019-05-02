FROM openjdk:8-jre-alpine

LABEL author="Batuhan Çam"

MAINTAINER batuc06@gmail.com

ARG PACKAGED_JAR=service-two.jar

ADD ${PACKAGED_JAR} mcy-sb-devtools-docker.jar

ENTRYPOINT ["java","-jar","-Xdebug","-Xrunjdwp:server=y,transport=dt_socket,address=8004,suspend=n","/mcy-sb-devtools-docker.jar"]

EXPOSE 8084:8084
EXPOSE 8004:8004
