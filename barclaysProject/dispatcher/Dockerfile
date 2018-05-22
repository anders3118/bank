FROM openjdk

ENV SERVER_PORT=9333
ENV ENDPOINT_TRANS=http://localhost:9444/barclays/transform/v1

COPY target/dispatcher-*.jar /app/dispatcher.jar

EXPOSE $SERVER_PORT

CMD ["java", "-jar", "/app/dispatcher.jar"]