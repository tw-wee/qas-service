FROM debian:jessie
RUN add-apt-repository ppa:openjdk-r/ppa && apt-get update \
    apt-get install -y openjdk-8-jdk
VOLUME /tmp
ADD qas-service-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]