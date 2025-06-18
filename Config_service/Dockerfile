FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY Config_service/build/libs/Config_service-0.0.1-SNAPSHOT.jar app.jar
COPY Config-repo /Config-repo
ENTRYPOINT ["java","-jar","/app.jar"]

