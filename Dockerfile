FROM openjdk:11-jdk-slim

ENV SPRING_PROFILE="default"

ARG JAR_FILE

ADD ${JAR_FILE} service.jar
ENTRYPOINT exec java $JAVA_OPTS \
 -Djava.security.egd=file:/dev/./urandom \
 -Dspring.profiles.active=$SPRING_PROFILE \
 -jar service.jar