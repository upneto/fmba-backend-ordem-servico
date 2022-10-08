# Maven
FROM maven:3-jdk-11
ADD . /fmba-backend-ordem-servico
WORKDIR /fmba-backend-ordem-servico
RUN ls -l
RUN mvn clean install

# Java App
FROM openjdk:11-jdk
VOLUME /tmp
COPY --from=0 "/fmba-backend-ordem-servico/target/fmba-backend-ordem-servico-*.jar" app.jar
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]