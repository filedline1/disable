FROM openjdk:8
VOLUME /tmp
ADD disable-date-personinfo-0.0.3-SNAPSHOT app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]