FROM maven:3.8.3-openjdk-17
VOLUME /tmp
ENV SERVER_PORT=8082
ARG JAR_FILE
COPY ./.aws /root/.aws
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8082