FROM openjdk

ENV SERVER_PORT=9111
ENV ENDPOINT_ROUTING=http://localhost:9222/barclays/routing/v1
ENV ENDPOINT_DISPATCHER=http://localhost:9333/barclays/dispatcher/v1

COPY target/orchestrator-*.jar /app/orchestrator.jar

EXPOSE $SERVER_PORT

CMD ["java", "-jar", "/app/orchestrator.jar"]