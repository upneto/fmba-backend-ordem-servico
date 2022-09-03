FROM openjdk:11-jdk-slim
VOLUME /tpm
ADD target/*.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]