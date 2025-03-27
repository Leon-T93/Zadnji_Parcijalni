FROM openjdk:21-jdk
MAINTAINER apis-it.hr

COPY target/spring_boot-0.0.1-SNAPSHOT.jar spring_boot.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/spring_boot.jar"]