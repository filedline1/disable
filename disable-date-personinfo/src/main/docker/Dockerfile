FROM openjdk:8
VOLUME /tmp
ADD disable-date-personinfo-0.0.9-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]