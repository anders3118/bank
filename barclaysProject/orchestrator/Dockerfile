FROM openjdk

ENV SERVER_PORT=9111

COPY target/orchestrator-*.jar /app/orchestrator.jar

EXPOSE $SERVER_PORT

CMD ["java", "-jar", "/app/orchestrator.jar"]