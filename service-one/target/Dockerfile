FROM openjdk:8-jre-alpine

LABEL author="Batuhan Çam"

MAINTAINER batuc06@gmail.com


ARG PACKAGED_JAR=service-one.jar

ADD ${PACKAGED_JAR} mcy-sb-devtools-docker.jar

ENTRYPOINT ["java","-jar","-Xdebug","-Xrunjdwp:server=y,transport=dt_socket,address=8002,suspend=n","/mcy-sb-devtools-docker.jar"]

EXPOSE 8082:8082
EXPOSE 8002:8002
