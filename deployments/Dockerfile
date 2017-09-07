FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD amazon-0.0.1.jar amazon.jar
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /amazon.jar" ]